package com.mahendracandi.springautoscanning.service;

import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;

public interface DateService {
    public LocalDate getNextAssesstmentDate();
}
