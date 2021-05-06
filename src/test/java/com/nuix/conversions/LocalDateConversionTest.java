package com.nuix.conversions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LocalDateConversionTest {

    private LocalDateConversion localDateConversion;

    @BeforeEach
    void setUp() {
        localDateConversion = new LocalDateConversion(new String[]{"dd/MM/yyyy"});
    }

    @Test
    void execute() {
        LocalDate execute = localDateConversion.execute("05/05/2021");
        assertEquals(5,execute.getDayOfMonth());
    }

    @Test
    void revert() {
        // To be implemented
    }
}