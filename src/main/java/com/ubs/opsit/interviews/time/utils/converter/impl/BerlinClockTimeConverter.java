package com.ubs.opsit.interviews.time.utils.converter.impl;

import com.ubs.opsit.interviews.time.entities.BaseTime;
import com.ubs.opsit.interviews.time.utils.converter.ITimeConverter;
import com.ubs.opsit.interviews.time.utils.parser.ITimeParser;
import com.ubs.opsit.interviews.time.utils.parser.impl.TimeParser;

import static com.ubs.opsit.interviews.time.utils.Constants.*;

/**
 * Created by kozak on 09.06.2017.
 */
public class BerlinClockTimeConverter implements ITimeConverter {

    private ITimeParser timeParser = new TimeParser();

    @Override
    public String convertTime(Object timeObject) {
        BaseTime time = timeParser.parseTime(timeObject);
        int topHourLamps = time.getHours() / TIME_BY_TOP_LAMP_MULTIPLICATOR;
        int bottomHourLamps = time.getHours() % TIME_BY_TOP_LAMP_MULTIPLICATOR;
        int topMinuteLamps = time.getMinutes() / TIME_BY_TOP_LAMP_MULTIPLICATOR;
        int bottomMinuteLamps = time.getMinutes() % TIME_BY_TOP_LAMP_MULTIPLICATOR;
        boolean secondsLamp = (time.getSeconds() % COUNT_OF_SECONDS_LAMP_STATES) == 0;
        String berlinClockPresentation = "";

        if (secondsLamp) {
            berlinClockPresentation = berlinClockPresentation.concat(LAMP_COLOR_YELLOW);
        } else {
            berlinClockPresentation = berlinClockPresentation.concat(LAMP_COLOR_DISABLED);
        }
        berlinClockPresentation = berlinClockPresentation.concat(NEWLINE_CHARACTER);
        for (int i = 1; i <= COUNT_OF_TOP_HOURS_ROW_LAMPS; i++) {
            if (i <= topHourLamps) {
                berlinClockPresentation = berlinClockPresentation.concat(LAMP_COLOR_RED);
            } else {
                berlinClockPresentation = berlinClockPresentation.concat(LAMP_COLOR_DISABLED);
            }
        }
        berlinClockPresentation = berlinClockPresentation.concat(NEWLINE_CHARACTER);
        for (int i = 1; i <= COUNT_OF_BOTTOM_HOURS_ROW_LAMPS; i++) {
            if (i <= bottomHourLamps) {
                berlinClockPresentation = berlinClockPresentation.concat(LAMP_COLOR_RED);
            } else {
                berlinClockPresentation = berlinClockPresentation.concat(LAMP_COLOR_DISABLED);
            }
        }
        berlinClockPresentation = berlinClockPresentation.concat(NEWLINE_CHARACTER);
        for (int i = 1; i <= COUNT_OF_TOP_MINUTES_ROW_LAMPS; i++) {
            if (i <= topMinuteLamps) {
                if ((i % 3) == 0) {
                    berlinClockPresentation = berlinClockPresentation.concat(LAMP_COLOR_RED);
                } else {
                    berlinClockPresentation = berlinClockPresentation.concat(LAMP_COLOR_YELLOW);
                }
            } else {
                berlinClockPresentation = berlinClockPresentation.concat(LAMP_COLOR_DISABLED);
            }
        }
        berlinClockPresentation = berlinClockPresentation.concat(NEWLINE_CHARACTER);
        for (int i = 1; i <= COUNT_OF_BOTTOM_MINUTES_ROW_LAMPS; i++) {
            if (i <= bottomMinuteLamps) {
                berlinClockPresentation = berlinClockPresentation.concat(LAMP_COLOR_YELLOW);
            } else {
                berlinClockPresentation = berlinClockPresentation.concat(LAMP_COLOR_DISABLED);
            }
        }

        return berlinClockPresentation;
    }
}
