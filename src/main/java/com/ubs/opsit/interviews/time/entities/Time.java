package com.ubs.opsit.interviews.time.entities;

/**
 * Created by kozak on 10.06.2017.
 */
public class Time extends BaseTime {

    public Time() {
    }

    public Time(int hours, int minutes, int seconds) {
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }
}
