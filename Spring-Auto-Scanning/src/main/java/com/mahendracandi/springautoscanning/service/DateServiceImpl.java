package com.mahendracandi.springautoscanning.service;

import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;


@Service("dateService")
public class DateServiceImpl implements DateService{
    @Override
    public LocalDate getNextAssesstmentDate() {
        return new LocalDate(2015, 12, 1);
    }
}
