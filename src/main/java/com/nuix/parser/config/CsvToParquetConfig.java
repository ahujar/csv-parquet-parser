package com.nuix.parser.config;

import com.nuix.domain.LocalInputFile;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.csv.CsvRoutines;
import org.apache.avro.Schema;
import org.apache.avro.data.TimeConversions;
import org.apache.avro.reflect.ReflectData;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.avro.AvroParquetReader;
import org.apache.parquet.avro.AvroParquetWriter;
import org.apache.parquet.hadoop.ParquetReader;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;
import org.apache.parquet.hadoop.util.HadoopOutputFile;
import org.apache.parquet.io.OutputFile;

import java.io.IOException;
import java.nio.file.Paths;

public class CsvToParquetConfig<T> {

    public CsvRoutines csvRoutines(boolean headerExtractionEnabled) {
        CsvParserSettings parserSettings = new CsvParserSettings();
        parserSettings.getFormat().setLineSeparator("\n");
        parserSettings.setHeaderExtractionEnabled(headerExtractionEnabled);
        return new CsvRoutines(parserSettings);
    }

    public ParquetWriter<T> avroParquetWriter(String schemaPath, String outPutFile, Class<T> t) throws IOException {
        OutputFile fileToWrite = HadoopOutputFile.fromPath(new Path(outPutFile), new org.apache.hadoop.conf.Configuration());
        return AvroParquetWriter
                .<T>builder(fileToWrite)
                .withSchema(parseSchema(schemaPath))
                .withDataModel(getReflectData(t))
                .withConf(new org.apache.hadoop.conf.Configuration())
                .withCompressionCodec(CompressionCodecName.SNAPPY)
                .build();
    }

    private ReflectData getReflectData(Class<T> t) {
        ReflectData reflectData = new ReflectData(t.getClassLoader());
        reflectData.addLogicalTypeConversion(new TimeConversions.DateConversion());
        return reflectData;
    }

    public ParquetReader<T> avroParquetReader(String fileName, Class<T> tClass) throws IOException {
        return AvroParquetReader.<T>
                builder(new LocalInputFile(Paths.get(fileName)))
                .withDataModel(getReflectData(tClass))
                .withConf(new org.apache.hadoop.conf.Configuration())
                .build();
    }

    private static Schema parseSchema(String schemaPath) throws IOException {
        Schema.Parser parser = new Schema.Parser();
        return parser.parse(ClassLoader.getSystemResourceAsStream(
                schemaPath));
    }
}
