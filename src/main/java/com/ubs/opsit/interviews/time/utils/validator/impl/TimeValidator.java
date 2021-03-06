package com.ubs.opsit.interviews.time.utils.validator.impl;

import com.ubs.opsit.interviews.time.utils.validator.ITimeValidator;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.regex.Pattern;

import static com.ubs.opsit.interviews.time.utils.Constants.TimeStringValidationRegEx;

/**
 * Created by kozak on 10.06.2017.
 */

public class TimeValidator implements ITimeValidator {

    private boolean isValidString(String inputTimeString) {
        if (inputTimeString.replaceAll("\\s+", "").isEmpty()) {
            return false;
        } else {
            Pattern pattern = Pattern.compile(TimeStringValidationRegEx);
            return pattern.matcher(inputTimeString).matches();
        }
    }

    private boolean isValidDate(Date inputTimeDate) {
        return true;
    }

    @Override
    public boolean isValid(Object timeObject) {
        if (timeObject == null) {
            return false;
        }

        boolean isTimeValid = true;
        if (timeObject instanceof String) {
            isTimeValid = isValidString((String) timeObject);
        } else if (timeObject instanceof Date) {
            isTimeValid = isValidDate((Date) timeObject);
        }

        return isTimeValid;
    }

}
