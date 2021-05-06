package com.nuix.aws.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.nuix.aws.config.AWSConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;

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
        this.amazonS3 = AWSConfig.amazonS3Client(properties);
    }

    public ZipFile downloadZipFileFromBucket(String fileName, String bucketName) throws IOException {
        File file = Paths.get(fileName).toFile();
        FileUtils.deleteQuietly(file);
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
