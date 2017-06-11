package com.ubs.opsit.interviews.time.tests.parser;

import com.ubs.opsit.interviews.time.entities.BaseTime;
import com.ubs.opsit.interviews.time.utils.parser.ITimeParser;
import com.ubs.opsit.interviews.time.utils.parser.impl.TimeParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kozak on 10.06.2017.
 */
public class TimeParserTests {
    ITimeParser timeParser = new TimeParser();

    @Test(expected = IllegalArgumentException.class)
    public void testParseTimeFromStringNull() {
        Object nullTime = null;
        timeParser.parseTime(nullTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseTimeFromStringEmpty() {
        Object emptyTime = "";
        timeParser.parseTime(emptyTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseTimeFromStringEmptySpace() {
        Object emptySpaceTime = "   ";
        timeParser.parseTime(emptySpaceTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseTimeFromStringInvalidCount() {
        Object invalidTime = "001:00:00";
        timeParser.parseTime(invalidTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseTimeFromStringInvalidChars() {
        Object invalidTime = "lal228";
        timeParser.parseTime(invalidTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseTimeFromStringInvalidSeparator() {
        Object invalidTime = "00+00+00";
        timeParser.parseTime(invalidTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseTimeFromStringInvalidShifted() {
        Object invalidTime = "59-59-23";
        timeParser.parseTime(invalidTime);
    }

    @Test
    public void testParseTimeFromStringValidHours() {
        Object validTime = "22_00_00";
        int expectedHours = 22;
        int actualHours = timeParser.parseTime(validTime).getHours();
        assertEquals(actualHours, expectedHours);
    }

    @Test
    public void testParseTimeFromStringValidMinutes() {
        Object validTime = "00-33-00";
        int expectedMinutes = 33;
        int actualMinutes = timeParser.parseTime(validTime).getMinutes();
        assertEquals(actualMinutes, expectedMinutes);
    }

    @Test
    public void testParseTimeFromStringValidSeconds() {
        Object validTime = "00/00/44";
        int expectedSeconds = 44;
        int actualSeconds = timeParser.parseTime(validTime).getSeconds();
        assertEquals(actualSeconds, expectedSeconds);
    }
}
