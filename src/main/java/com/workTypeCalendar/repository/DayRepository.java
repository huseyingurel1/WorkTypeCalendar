package com.workTypeCalendar.repository;

import com.workTypeCalendar.model.Day;
import com.workTypeCalendar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayRepository extends JpaRepository<Day,Long> {
    Day findByPersonDayAndUsers(String personDay, User user);
    boolean existsByPersonDayAndUsers(String personDay, User user);

}
