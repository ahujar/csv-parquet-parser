package com.nuix.domain;

import java.io.File;

public class MetaData<T> {

    private String outputfileName;
    private String schemaFilePath;
    private boolean headerExtractionEnabled;

    public MetaData(String fileName,Boolean headerExtractionEnabled) {
        this.setSchemaFilePath("avro" + File.separator + fileName + ".avsc");
        this.setOutputfileName(fileName + ".parquet");
        this.setHeaderExtractionEnabled(headerExtractionEnabled);
    }

    public boolean isHeaderExtractionEnabled() {
        return headerExtractionEnabled;
    }

    public void setHeaderExtractionEnabled(boolean headerExtractionEnabled) {
        this.headerExtractionEnabled = headerExtractionEnabled;
    }

    public String getOutputfileName() {
        return outputfileName;
    }

    public void setOutputfileName(String outputfileName) {
        this.outputfileName = outputfileName;
    }

    public String getSchemaFilePath() {
        return schemaFilePath;
    }

    public void setSchemaFilePath(String schemaFilePath) {
        this.schemaFilePath = schemaFilePath;
    }

}
