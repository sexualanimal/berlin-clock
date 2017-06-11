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

        return getSecondsLine(time.getSeconds())
                .concat(getNewLine())
                .concat(getHoursTopLine(time.getHours()))
                .concat(getNewLine())
                .concat(getHoursBottomLine(time.getHours()))
                .concat(getNewLine())
                .concat(getMinutesTopLine(time.getMinutes()))
                .concat(getNewLine())
                .concat(getMinutesBottomLine(time.getMinutes()));
    }

    private String getNewLine() {
        return "\n";
    }

    private String getSecondsLine(int seconds) {
        return seconds % 2 == 0 ? LAMP_COLOR_YELLOW : LAMP_COLOR_DISABLED;
    }

    private String getHoursTopLine(int hours) {
        return getRow(LAMP_COLOR_RED,
                COUNT_OF_TOP_HOURS_ROW_LAMPS,
                hours / TIME_BY_TOP_LAMP_MULTIPLICATOR);
    }

    private String getHoursBottomLine(int hours) {
        return getRow(LAMP_COLOR_RED,
                COUNT_OF_BOTTOM_HOURS_ROW_LAMPS,
                hours % TIME_BY_TOP_LAMP_MULTIPLICATOR);
    }

    private String getMinutesTopLine(int minutes) {
        return getRow(LAMP_COLOR_YELLOW,
                LAMP_COLOR_RED,
                WITH_ADDITIONAL_COLOR_MULTIPLICATOR,
                COUNT_OF_TOP_MINUTES_ROW_LAMPS,
                minutes / TIME_BY_TOP_LAMP_MULTIPLICATOR);
    }

    private String getMinutesBottomLine(int minutes) {
        return getRow(LAMP_COLOR_YELLOW,
                COUNT_OF_BOTTOM_MINUTES_ROW_LAMPS,
                minutes % TIME_BY_TOP_LAMP_MULTIPLICATOR);
    }

    private String getRow(String colorOfLamps, int commonCount, int lightedCount) {
        return getRow(colorOfLamps, colorOfLamps, WITH_ADDITIONAL_COLOR_MULTIPLICATOR, commonCount, lightedCount);
    }

    private String getRow(String colorOfLamps, String additionalColorOfLamps, int additionalMultiplicator, int commonCount, int lightedCount) {
        String lampsRow = "";
        for (int currentLampIndex = 1; currentLampIndex <= commonCount; currentLampIndex++) {
            if (currentLampIndex <= lightedCount) {
                if ((currentLampIndex % additionalMultiplicator) == 0) {
                    lampsRow = lampsRow.concat(additionalColorOfLamps);
                } else {
                    lampsRow = lampsRow.concat(colorOfLamps);
                }
            } else {
                lampsRow = lampsRow.concat(LAMP_COLOR_DISABLED);
            }
        }
        return lampsRow;
    }
}
