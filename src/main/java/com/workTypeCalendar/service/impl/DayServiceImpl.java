package com.workTypeCalendar.service.impl;

import com.workTypeCalendar.repository.DayRepository;
import com.workTypeCalendar.service.DayService;
import org.springframework.stereotype.Service;


@Service
public class DayServiceImpl implements DayService {

    private DayRepository dayRepository;

    public DayServiceImpl(DayRepository dayRepository) {
        super();
        this.dayRepository = dayRepository;
    }



}
