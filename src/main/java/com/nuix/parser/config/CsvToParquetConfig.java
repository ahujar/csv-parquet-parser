package com.nuix.parser.config;

import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.csv.CsvRoutines;
import org.apache.avro.Schema;
import org.apache.avro.data.TimeConversions;
import org.apache.avro.generic.GenericData;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.avro.AvroParquetWriter;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;
import org.apache.parquet.hadoop.util.HadoopOutputFile;
import org.apache.parquet.io.OutputFile;

import java.io.IOException;

public class CsvToParquetConfig<T> {

    public CsvRoutines csvRoutines(boolean headerExtractionEnabled) {
        CsvParserSettings parserSettings = new CsvParserSettings();
        parserSettings.getFormat().setLineSeparator("\n");
        parserSettings.setHeaderExtractionEnabled(headerExtractionEnabled);
        return new CsvRoutines(parserSettings);
    }

    public ParquetWriter<T> avroParquetWriter(String schemaPath, String outPutFile) throws IOException {
        OutputFile fileToWrite = HadoopOutputFile.fromPath(new Path(outPutFile), new org.apache.hadoop.conf.Configuration());
        Schema schema = parseSchema(schemaPath);
        GenericData genericData = GenericData.get();
        genericData.addLogicalTypeConversion(new TimeConversions.DateConversion());
        return AvroParquetWriter
                .<T>builder(fileToWrite)
                .withSchema(schema)
                .withDataModel(genericData)
                .withConf(new org.apache.hadoop.conf.Configuration())
                .withCompressionCodec(CompressionCodecName.SNAPPY)
                .build();
    }

    private static Schema parseSchema(String schemaPath) throws IOException {
        Schema.Parser parser = new Schema.Parser();
        return parser.parse(ClassLoader.getSystemResourceAsStream(
                schemaPath));
    }
}
