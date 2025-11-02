package com.app.repository;

import com.app.entity.evaluation.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AreaRepository extends JpaRepository<Area, Long> {


    //joining the area table with agent table via agent id
//    @Query(" SELECT ag FROM Area a JOIN a.agent ag " +
//            "where ag.id=: id")
//    List<Area> searchAgent(@Param("id") long id);

    List<Area> findByPinCode(long pinCode);
}