package com.nuix.aws.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.nuix.parser.ParseServiceConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration2.PropertiesConfiguration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipFile;


@Slf4j
public class AWSS3Service {


    private AmazonS3 amazonS3;

    public AWSS3Service(PropertiesConfiguration properties) {
        this.amazonS3 = getS3Client(properties);
    }

    private AmazonS3 getS3Client(PropertiesConfiguration properties) {
        return AmazonS3Client.builder().withRegion(properties.getString(ParseServiceConstants.AWS_REGION_STATIC))
                .withCredentials(new AWSCredentialsProvider() {
                    @Override
                    public AWSCredentials getCredentials() {
                        return new BasicAWSCredentials(properties.getString(ParseServiceConstants.AWS_CREDENTIALS_ACCESS_KEY),
                                properties.getString(ParseServiceConstants.AWS_CREDENTIALS_SECRET_KEY));
                    }

                    @Override
                    public void refresh() {

                    }
                }).build();
    }

    public ZipFile downloadZipFileFromBucket(String fileName, String bucketName) throws IOException {
        Path path = Paths.get(fileName);
        Files.deleteIfExists(path);
        File file = path.toFile();
        InputStream inputStream = amazonS3.getObject(bucketName, fileName).getObjectContent().getDelegateStream();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.getChannel().transferFrom(Channels.newChannel(inputStream), 0, Long.MAX_VALUE);
        return new ZipFile(file);
    }

    public String uploadFileToBucket(File file, String fileName, String bucketName) {
        PutObjectResult result = amazonS3.putObject(bucketName, fileName, file);
        return result.getETag();
    }

}
