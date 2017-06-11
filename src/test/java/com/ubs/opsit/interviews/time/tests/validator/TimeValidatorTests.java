package com.ubs.opsit.interviews.time.tests.validator;

import com.ubs.opsit.interviews.time.utils.validator.ITimeValidator;
import com.ubs.opsit.interviews.time.utils.validator.impl.TimeValidator;
import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by kozak on 09.06.2017.
 */
public class TimeValidatorTests {

    private static final ITimeValidator timeValidator = new TimeValidator();

    @Test
    public void testValidateTimeFromDateNull() {
        Date nullDate = null;
        Boolean validationResult = timeValidator.isValid(nullDate);
        assertFalse(validationResult);
    }

    @Test
    public void testValidateTimeFromStringEmpty() {
        String emptyTime = "";
        Boolean validationResult = timeValidator.isValid(emptyTime);
        assertFalse(validationResult);
    }

    @Test
    public void testValidateTimeFromStringEmptySpace() {
        String emptySpaceTime = "     ";
        Boolean validationResult = timeValidator.isValid(emptySpaceTime);
        assertFalse(validationResult);
    }

    @Test
    public void testValidateTimeFromStringNull() {
        String nullTime = null;
        Boolean validationResult = timeValidator.isValid(nullTime);
        assertFalse(validationResult);
    }

    @Test
    public void testValidateTimeFromStringInvalidHours() {
        String invalidTime = "99:00:00";
        Boolean validationResult = timeValidator.isValid(invalidTime);
        assertFalse(validationResult);
    }

    @Test
    public void testValidateTimeFromStringInvalidMinutes() {
        String invalidTime = "00:99:00";
        Boolean validationResult = timeValidator.isValid(invalidTime);
        assertFalse(validationResult);
    }

    @Test
    public void testValidateTimeFromStringInvalidSeconds() {
        String invalidTime = "00:00:99";
        Boolean validationResult = timeValidator.isValid(invalidTime);
        assertFalse(validationResult);
    }

    @Test
    public void testValidateTimeFromStringValidZero() {
        String validTime = "00:00:00";
        Boolean validationResult = timeValidator.isValid(validTime);
        assertTrue(validationResult);
    }

    @Test
    public void testValidateTimeFromStringValidHours() {
        String validTime = "01:00:00";
        Boolean validationResult = timeValidator.isValid(validTime);
        assertTrue(validationResult);
    }

    @Test
    public void testValidateTimeFromStringValidMinutes() {
        String validTime = "00:01:00";
        Boolean validationResult = timeValidator.isValid(validTime);
        assertTrue(validationResult);
    }

    @Test
    public void testValidateTimeFromStringValidSeconds() {
        String validTime = "00:00:01";
        Boolean validationResult = timeValidator.isValid(validTime);
        assertTrue(validationResult);
    }

    @Test
    public void testValidateTimeFromStringValidSeparator1() {
        String validTime = "00-00-00";
        Boolean validationResult = timeValidator.isValid(validTime);
        assertTrue(validationResult);
    }

    @Test
    public void testValidateTimeFromStringValidSeparator2() {
        String validTime = "00_00_00";
        Boolean validationResult = timeValidator.isValid(validTime);
        assertTrue(validationResult);
    }

    @Test
    public void testValidateTimeFromStringValidSeparator3() {
        String validTime = "00/00/00";
        Boolean validationResult = timeValidator.isValid(validTime);
        assertTrue(validationResult);
    }

    @Test
    public void testValidateTimeFromStringValidSeparator4() {
        String validTime = "00\\00\\00";
        Boolean validationResult = timeValidator.isValid(validTime);
        assertTrue(validationResult);
    }

    @Test
    public void testValidateTimeFromStringValidSeparator5() {
        String validTime = "00 00 00";
        Boolean validationResult = timeValidator.isValid(validTime);
        assertTrue(validationResult);
    }
}
