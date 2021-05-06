package com.nuix.conversions;

import com.univocity.parsers.conversions.Conversion;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Slf4j
public class LocalDateConversion implements Conversion<String, LocalDate> {

    private String[] formats = {"dd/MM/yyyy"};

    public LocalDateConversion(String[] format) {
        if (format.length > 0) {
            this.formats = format;
        }
    }

    @Override
    public LocalDate execute(String s) {
        int i = 0;
        if (StringUtils.isNotBlank(s)) {
            for (String format : formats) {
                try {
                    i++;
                    return LocalDate.parse(s.trim(), DateTimeFormatter.ofPattern(format));
                } catch (DateTimeParseException ex) {
                    if (formats.length == i) {
                        throw ex;
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String revert(LocalDate o) {
        return null;
    }
}
