package com.nuix.parser;

import com.nuix.avro.AirbnbListing;
import com.nuix.avro.AusNews;
import com.nuix.avro.NetflixTitles;
import com.nuix.aws.service.AWSS3Service;
import com.nuix.domain.MetaData;
import com.nuix.parser.csv.CsvToParquetParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@Slf4j
public class ParseServiceClient {

    private static AWSS3Service awss3Service;
    private static PropertiesConfiguration properties;
    private static CsvToParquetParserFactory parserFactory;

    private static void init() throws ConfigurationException {
        Configurations config = new Configurations();
        properties = config.properties(ParseServiceConstants.APPLICATION_PROPERTIES);
        awss3Service = new AWSS3Service(properties);
        parserFactory = new CsvToParquetParserFactory();
    }

    public static void main(String[] args) throws ConfigurationException, IOException {
        init();
        String bucketName = properties.getString(ParseServiceConstants.AWS_S3_BUCKET_NAME);
        log.info("Downloading zip file from bucket {} ..", bucketName);
        ZipFile zipFile = awss3Service.downloadZipFileFromBucket(ParseServiceConstants.DATA_ZIP,
                bucketName);
        log.info("Downloaded zip.");
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            MetaData metaData = parseCsv(zipFile, entries);
            String outputfileName = metaData.getOutputfileName();
            log.info("Uploading {} to bucket {} ..", outputfileName, bucketName);
            String eTag = awss3Service.uploadFileToBucket(Paths.get(outputfileName).toFile(),
                    outputfileName, bucketName);
            log.info("Uploaded eTag {}",eTag);
        }
    }

    private static MetaData parseCsv(ZipFile zipFile, Enumeration<? extends ZipEntry> entries) throws IOException {
        MetaData metaData = null;
        ZipEntry entry = entries.nextElement();
        String fileName = entry.getName().substring(0, entry.getName().lastIndexOf("."));
        log.info("Parsing {}", fileName);
        CsvToParquetParser parquetParser = parserFactory.getParser(fileName, extractClass(fileName));
        try (InputStream isr = zipFile.getInputStream(entry)) {
            metaData = parquetParser.toParquet(isr, "ellipsis");
            log.info("Created {} ", metaData.getOutputfileName());
        }
        return metaData;
    }

    private static Class extractClass(String fileName) throws IOException {
        switch (fileName) {
            case "netflix_titles":
                return NetflixTitles.class;
            case "ausnews":
                return AusNews.class;
            case "AirbnbListing":
                return AirbnbListing.class;
            default:
                log.error("Unknown FileName : {}", fileName);
                throw new IOException("File Unsupported :" + fileName);
        }
    }

}
