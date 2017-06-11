package com.ubs.opsit.interviews.time.tests.converter;

import com.ubs.opsit.interviews.time.utils.converter.ITimeConverter;
import com.ubs.opsit.interviews.time.utils.converter.impl.BerlinClockTimeConverter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kozak on 10.06.2017.
 */
public class TimeConverterTests {
    ITimeConverter berlinClockTimeConverter = new BerlinClockTimeConverter();

    @Test(expected = IllegalArgumentException.class)
    public void testConvertTimeFromStringNull() {
        Object nullTime = null;
        berlinClockTimeConverter.convertTime(nullTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertTimeFromStringEmpty() {
        Object emptyTime = "";
        berlinClockTimeConverter.convertTime(emptyTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertTimeFromStringEmptySpace() {
        Object emptySpaceTime = "   ";
        berlinClockTimeConverter.convertTime(emptySpaceTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertTimeFromStringInvalidHours() {
        Object invalidTime = "24:00:00";
        berlinClockTimeConverter.convertTime(invalidTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertTimeFromStringInvalidMinutes() {
        Object invalidTime = "00:60:00";
        berlinClockTimeConverter.convertTime(invalidTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertTimeFromStringInvalidSeconds() {
        Object invalidTime = "00:00:60";
        berlinClockTimeConverter.convertTime(invalidTime);
    }

    @Test
    public void testConvertTimeFromString_H13_M37_S59() {
        Object validTime = "13_37_59";
        String expectedBerlinClockPresentation = "O\nRROO\nRRRO\nYYRYYRYOOOO\nYYOO";
        String actualBerlinClockPresentation = berlinClockTimeConverter.convertTime(validTime);
        assertEquals(expectedBerlinClockPresentation, actualBerlinClockPresentation);
    }

    @Test
    public void testConvertTimeFromString_H00_M00_S00() {
        Object validTime = "00-00-00";
        String expectedBerlinClockPresentation = "Y\nOOOO\nOOOO\nOOOOOOOOOOO\nOOOO";
        String actualBerlinClockPresentation = berlinClockTimeConverter.convertTime(validTime);
        assertEquals(expectedBerlinClockPresentation, actualBerlinClockPresentation);
    }

    @Test
    public void testConvertTimeFromString_H23_M59_S59() {
        Object validTime = "23/59/59";
        String expectedBerlinClockPresentation = "O\nRRRR\nRRRO\nYYRYYRYYRYY\nYYYY";
        String actualBerlinClockPresentation = berlinClockTimeConverter.convertTime(validTime);
        assertEquals(expectedBerlinClockPresentation, actualBerlinClockPresentation);
    }

    @Test
    public void testConvertTimeFromStringDifferentSeparators() {
        Object validTime = "23 59\\59";
        String expectedBerlinClockPresentation = "O\nRRRR\nRRRO\nYYRYYRYYRYY\nYYYY";
        String actualBerlinClockPresentation = berlinClockTimeConverter.convertTime(validTime);
        assertEquals(expectedBerlinClockPresentation, actualBerlinClockPresentation);
    }
}
