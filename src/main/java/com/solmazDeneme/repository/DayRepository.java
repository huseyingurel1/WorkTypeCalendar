package com.solmazDeneme.repository;

import com.solmazDeneme.model.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayRepository extends JpaRepository<Day,Long> {

}
