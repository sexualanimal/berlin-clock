package com.ubs.opsit.interviews.time.entities;

import lombok.Data;

/**
 * Created by kozak on 09.06.2017.
 */
@Data
public abstract class BaseTime {
    private int hours;
    private int minutes;
    private int seconds;
}
