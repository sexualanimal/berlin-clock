package com.ubs.opsit.interviews.time.utils;

/**
 * Created by kozak on 10.06.2017.
 */
public class Constants {
    public static final String TimeStringValidationRegEx = "^([01]?[0-9]|2[0-3])[-_:\\s/\\\\][0-5][0-9][-_:\\s/\\\\][0-5][0-9]$";
    public static final String NEWLINE_CHARACTER = "\n";
    public static final String LAMP_COLOR_YELLOW = "Y";
    public static final String LAMP_COLOR_DISABLED = "O";
    public static final String LAMP_COLOR_RED = "R";
    public static final int TIME_BY_TOP_LAMP_MULTIPLICATOR = 5;
    public static final int TIME_BY_BOTTOM_LAMP_MULTIPLICATOR = 1;
    public static final int COUNT_OF_SECONDS_LAMP_STATES = 2;
    public static final int COUNT_OF_TOP_HOURS_ROW_LAMPS = 4;
    public static final int COUNT_OF_BOTTOM_HOURS_ROW_LAMPS = 4;
    public static final int COUNT_OF_TOP_MINUTES_ROW_LAMPS = 11;
    public static final int COUNT_OF_BOTTOM_MINUTES_ROW_LAMPS = 4;
    public static final int WITH_ADDITIONAL_COLOR_MULTIPLICATOR = 3;
    public static final String VALID_STRING_TIME_SEPARATORS = "-_: \\";

}
