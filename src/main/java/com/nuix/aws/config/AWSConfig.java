package com.nuix.aws.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.nuix.parser.ParseServiceConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration2.PropertiesConfiguration;


@Slf4j
public class AWSConfig {

    public static AmazonS3 amazonS3Client(PropertiesConfiguration properties) {
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
}
