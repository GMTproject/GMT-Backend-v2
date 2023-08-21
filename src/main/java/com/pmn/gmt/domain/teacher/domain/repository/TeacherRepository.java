package com.pmn.gmt.domain.teacher.domain.repository;

import com.pmn.gmt.domain.teacher.domain.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    List<Teacher> findByFreeIsNotNull();
    List<Teacher> findByMajorIsNotNull();
    List<Teacher> findBySkillIsNotNull();


    List<Teacher> findByPositionContaining(String position);

    List<Teacher> findByNameContaining(String nameKeyword);
}
