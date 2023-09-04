package com.pmn.gmt.domain.map.domain.repository;

import com.pmn.gmt.domain.map.domain.entity.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapRepository extends JpaRepository<Map, Integer> {
    List<Map> findByName(String name);
}
