package com.nuix.parser;

import com.nuix.domain.MetaData;
import com.nuix.parser.config.CsvToParquetConfig;
import com.nuix.parser.csv.CsvToParquetParser;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CsvToParquetParserFactory<T> {

    public CsvToParquetParser getParser(String fileName, Class<T> t) {
        Boolean headerExists = getHeaderSettings(fileName);
        MetaData<T> metaData = new MetaData<>(fileName, headerExists);
        CsvToParquetConfig<T> csvToParquetConfig = new CsvToParquetConfig<>();
        return new CsvToParquetParser<>(csvToParquetConfig, metaData, t);

    }

    private Boolean getHeaderSettings(String fileName) {
        return "AirbnbListing".equals(fileName) || "netflix_titles".equals(fileName);
    }
}
