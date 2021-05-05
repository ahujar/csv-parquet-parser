package com.nuix.parser.csv;

import com.nuix.avro.NetflixTitles;
import com.nuix.domain.MetaData;
import com.nuix.parser.config.CsvToParquetConfig;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.zip.ZipFile;

class CsvToParquetParserTest {

    @Test
    void parse() throws IOException {
        /*ZipFile zipFile = new ZipFile("./data.zip");
        zipFile.stream().forEach(entry -> {
            String fileNamefromZip = entry.getName().substring(0, entry.getName().lastIndexOf("."));
            if (fileNamefromZip.contains(fileName)) {
                try {
                    csvToParquetParser.toParquet( zipFile.getInputStream(entry), "ellipsis", netflixTitles);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });*/
    }
}