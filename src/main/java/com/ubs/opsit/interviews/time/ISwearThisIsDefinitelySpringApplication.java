package com.ubs.opsit.interviews.time;

import com.ubs.opsit.interviews.time.utils.converter.ITimeConverter;
import com.ubs.opsit.interviews.time.utils.converter.impl.BerlinClockTimeConverter;

import java.util.Date;

/**
 * Created by kozak on 11.06.2017.
 */
public class ISwearThisIsDefinitelySpringApplication {
    public static void main(String[] args) {
        ITimeConverter timeConverter = new BerlinClockTimeConverter();
        String berlinClockPresentation = timeConverter.convertTime(new Date());
        System.out.println(berlinClockPresentation);
    }
}
