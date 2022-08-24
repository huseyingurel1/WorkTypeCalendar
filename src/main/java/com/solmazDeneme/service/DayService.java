package com.solmazDeneme.service;


import com.solmazDeneme.model.Day;

import java.util.List;

public interface DayService {

    Day saveDay(Day day);

    List<Day> getAllDays();

}
