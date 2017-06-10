package com.ubs.opsit.interviews.time.tests.validator;

import com.ubs.opsit.interviews.time.utils.validator.ITimeValidator;
import com.ubs.opsit.interviews.time.utils.validator.impl.TimeValidator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by kozak on 09.06.2017.
 */
public class TimeValidatorTests {

    private static final ITimeValidator timeValidator = new TimeValidator();

    @Test
    public void testTimeFromDateNull() {
        Date nullDate = null;
        Boolean validationResult = timeValidator.isValid(nullDate);
        assertFalse(validationResult);
    }

    @Test
    public void testTimeFromStringEmpty() {
        String emptyTime = "";
        Boolean validationResult = timeValidator.isValid(emptyTime);
        assertFalse(validationResult);
    }

    @Test
    public void testTimeFromStringEmptySpace() {
        String emptySpaceTime = "     ";
        Boolean validationResult = timeValidator.isValid(emptySpaceTime);
        assertFalse(validationResult);
    }

    @Test
    public void testTimeFromStringNull() {
        String nullTime = null;
        Boolean validationResult = timeValidator.isValid(nullTime);
        assertFalse(validationResult);
    }

    @Test
    public void testTimeFromStringInvalidHours() {
        String invalidTime = "99:00:00";
        Boolean validationResult = timeValidator.isValid(invalidTime);
        assertFalse(validationResult);
    }

    @Test
    public void testTimeFromStringInvalidMinutes() {
        String invalidTime = "00:99:00";
        Boolean validationResult = timeValidator.isValid(invalidTime);
        assertFalse(validationResult);
    }

    @Test
    public void testTimeFromStringInvalidSeconds() {
        String invalidTime = "00:00:99";
        Boolean validationResult = timeValidator.isValid(invalidTime);
        assertFalse(validationResult);
    }

    @Test
    public void testTimeFromStringValidZero() {
        String validTime = "00:00:00";
        Boolean validationResult = timeValidator.isValid(validTime);
        assertTrue(validationResult);
    }

    @Test
    public void testTimeFromStringValidHours() {
        String validTime = "01:00:00";
        Boolean validationResult = timeValidator.isValid(validTime);
        assertTrue(validationResult);
    }

    @Test
    public void testTimeFromStringValidMinutes() {
        String validTime = "00:01:00";
        Boolean validationResult = timeValidator.isValid(validTime);
        assertTrue(validationResult);
    }

    @Test
    public void testTimeFromStringValidSeconds() {
        String validTime = "00:00:01";
        Boolean validationResult = timeValidator.isValid(validTime);
        assertTrue(validationResult);
    }
}
