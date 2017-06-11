package com.ubs.opsit.interviews.time.utils.parser.impl;

import com.ubs.opsit.interviews.time.entities.BaseTime;
import com.ubs.opsit.interviews.time.entities.Time;
import com.ubs.opsit.interviews.time.utils.parser.ITimeParser;
import com.ubs.opsit.interviews.time.utils.validator.ITimeValidator;
import com.ubs.opsit.interviews.time.utils.validator.impl.TimeValidator;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by kozak on 10.06.2017.
 */

public class TimeParser implements ITimeParser {

    private ITimeValidator timeValidator = new TimeValidator();

    @Override
    public BaseTime parseTime(Object timeObject) {
        if (!timeValidator.isValid(timeObject)) {
            throw new IllegalArgumentException();
        }
        if ((timeObject instanceof String)) {
            return parseFromString((String) timeObject);
        } else if ((timeObject instanceof Date)) {
            return parseFromDate((Date) timeObject);
        } else {
            return null;
        }
    }

    private BaseTime parseFromString(String timeString) {
        int hours = Integer.valueOf(timeString.substring(0, 2));
        int minutes = Integer.valueOf(timeString.substring(3, 5));
        int seconds = Integer.valueOf(timeString.substring(6, 8));
        return new Time(hours, minutes, seconds);
    }

    private BaseTime parseFromDate(Date timeDate) {
        return new Time(timeDate.getHours(),timeDate.getMinutes(),timeDate.getSeconds());
    }
}
