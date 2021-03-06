package com.example.so62843109;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Repository
public interface VehicleInterface extends JpaRepository<vehicle, Long> {

    @Query("select u from vehicle u where u.year = :year")
    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    List<vehicle> findByYearEquals(@Param("year") Integer year);
}
