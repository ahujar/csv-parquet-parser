package com.nuix.aws.service;

import com.nuix.parser.ParseServiceConstants;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipFile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AWSS3ServiceTest {


    private AWSS3Service awss3Service;
    private PropertiesConfiguration properties;

    @BeforeEach
    void setUp() throws ConfigurationException {
        Configurations config = new Configurations();
        properties = config.properties("src/main/resources/application.properties");
        awss3Service = new AWSS3Service(properties);
    }

    @Test
    void downloadFromBucket() throws IOException {
        ZipFile zipFile = awss3Service.downloadZipFileFromBucket(ParseServiceConstants.DATA_ZIP, properties.getString(ParseServiceConstants.AWS_S3_BUCKET_NAME));
        assertTrue(Files.exists(Paths.get(ParseServiceConstants.DATA_ZIP)));
        assertEquals(ParseServiceConstants.DATA_ZIP,zipFile.getName());
    }

    @Test
    void uploadFileToBucket() {
        // To be implemented
    }
}