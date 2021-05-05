package com.nuix.parser.csv;

import com.nuix.domain.MetaData;
import com.nuix.parser.config.CsvToParquetConfig;
import com.univocity.parsers.csv.CsvRoutines;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.parquet.hadoop.ParquetWriter;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

@Slf4j
public class CsvToParquetParser<T> {

    private CsvToParquetConfig<T> csvToParquetConfig;

    private MetaData<T> metaData;

    private Class<T> tClass;

    public CsvToParquetParser(CsvToParquetConfig<T> csvToParquetConfig, MetaData<T> metaData, Class<T> tClass) {
        this.csvToParquetConfig = csvToParquetConfig;
        this.metaData = metaData;
        this.tClass = tClass;
        cleanUpExistingFiles(metaData.getOutputfileName());
    }

    public MetaData<T> toParquet(InputStream isr, String searchString) throws IOException {
        CsvRoutines csvRoutines = csvToParquetConfig.csvRoutines(metaData.isHeaderExtractionEnabled());
        try (ParquetWriter<T> writer = csvToParquetConfig.<T>avroParquetWriter(metaData.getSchemaFilePath(), metaData.getOutputfileName());
        ) {
            for (T obj : csvRoutines.iterate(tClass, isr)) {
                boolean matches = obj.toString().matches(generateRegex(searchString));
                if (matches) {
                    writer.write(obj);
                }
            }
        }

        return metaData;
    }

    private void cleanUpExistingFiles(String outputfileName) {
        FileUtils.deleteQuietly(Paths.get(outputfileName).toFile());
        FileUtils.deleteQuietly(Paths.get("." + outputfileName + ".crc").toFile());
    }

    private String generateRegex(String searchString) {
        return ".*" + searchString + ".*";
    }
}
