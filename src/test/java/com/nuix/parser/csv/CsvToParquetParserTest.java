package com.nuix.parser.csv;

import com.nuix.avro.NetflixTitles;
import com.nuix.domain.MetaData;
import com.nuix.parser.config.CsvToParquetConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.parquet.hadoop.ParquetReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipFile;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class CsvToParquetParserTest {

    private CsvToParquetParser<NetflixTitles> netflixTitlesCsvToParquetParser;

    private MetaData<NetflixTitles> netflixTitlesMetaData;

    private CsvToParquetConfig<NetflixTitles> csvToParquetConfig;

    private ParquetReader<NetflixTitles> reader;

    @BeforeEach
    void setUp() {
        csvToParquetConfig = new CsvToParquetConfig<>();
        netflixTitlesMetaData = new MetaData<>("netflix_titles", true);
        netflixTitlesCsvToParquetParser = new CsvToParquetParser<>(
                csvToParquetConfig, netflixTitlesMetaData, NetflixTitles.class);
    }

    @Test
    void parse() throws IOException {
        ZipFile zipFile = new ZipFile("src/test/resources/data.zip");
        zipFile.stream().forEach(entry -> {
            String fileNamefromZip = entry.getName().substring(0, entry.getName().lastIndexOf("."));
            if (fileNamefromZip.contains("netflix")) {
                try {
                    MetaData<NetflixTitles> metaData = netflixTitlesCsvToParquetParser.toParquet(zipFile.getInputStream(entry), "ellipsis");
                } catch (IOException e) {
                    log.error("Error occured : {}", e);
                }
            }
        });
        assertEquals("netflix_titles.parquet", netflixTitlesMetaData.getOutputfileName());
        reader = csvToParquetConfig.avroParquetReader(netflixTitlesMetaData.getOutputfileName(), NetflixTitles.class);
        NetflixTitles record;
        final List<NetflixTitles> list = new ArrayList<>();
        while ((record = reader.read()) != null) {
            list.add(record);
        }
        assertEquals(8, list.size());
    }
}