package com.ubs.opsit.interviews.time.utils.parser;

import com.ubs.opsit.interviews.time.entities.BaseTime;

/**
 * Created by kozak on 09.06.2017.
 */
public interface ITimeParser {
    BaseTime parseTime(Object timeObject);
}
