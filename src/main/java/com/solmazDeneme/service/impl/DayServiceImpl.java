package com.solmazDeneme.service.impl;

import com.solmazDeneme.model.Day;
import com.solmazDeneme.repository.DayRepository;
import com.solmazDeneme.service.DayService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayServiceImpl implements DayService {

    private DayRepository dayRepository;

    public DayServiceImpl(DayRepository dayRepository) {
        super();
        this.dayRepository = dayRepository;
    }

    @Override
    public Day saveDay(Day day) {
        return dayRepository.save(day);
    }

    @Override
    public List<Day> getAllDays() {
        return dayRepository.findAll();
    }


}
