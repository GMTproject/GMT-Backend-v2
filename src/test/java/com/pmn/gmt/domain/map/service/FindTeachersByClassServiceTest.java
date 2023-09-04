package com.pmn.gmt.domain.map.service;

import com.pmn.gmt.domain.map.domain.entity.Map;
import com.pmn.gmt.domain.map.domain.entity.location.Structure;
import com.pmn.gmt.domain.map.domain.repository.MapRepository;
import com.pmn.gmt.domain.map.presentation.data.dto.ClassNameDto;
import com.pmn.gmt.domain.map.presentation.data.dto.TeacherDto;
import com.pmn.gmt.domain.map.util.MapConverter;
import com.pmn.gmt.domain.teacher.domain.entity.Teacher;
import com.pmn.gmt.domain.teacher.domain.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback
public class FindTeachersByClassServiceTest {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private MapRepository mapRepository;
    @Autowired
    private FindTeachersByClassNameService findTeachersByClassNameService;
    @Autowired
    private MapConverter mapConverter;

    @Test
    public void findTeachersByClassTest(){
        Teacher teacher1 = new Teacher("홍길동", "010-0000-0000","1학년부","1학년 교무실","1-1반 담임선생님","국어", null,null, null);
        Teacher teacher2 = new Teacher("도깨비", "010-0000-0000","1학년부","1학년 교무실","1-2반 담임선생님","정보", "자유","전공", "사설");
        Teacher teacher3 = new Teacher("전래동화", "010-0000-0000","2학년부","2학년 교무실","2-3반 담임선생님","역사", null,"전공", "사설");

        Map class1 = new Map(0, "테스트 교실1", teacherRepository.save(teacher1), 3, Structure.MAIN,"실 설명을 입력해주세요.");
        Map class2 = new Map(0, "테스트 교실1", teacherRepository.save(teacher2), 3, Structure.MAIN,"실 설명을 입력해주세요.");
        Map class3 = new Map(0, "테스트 교실2", teacherRepository.save(teacher3), 4, Structure.MAIN,"실 설명을 입력해주세요.");

        mapRepository.save(class1);
        mapRepository.save(class2);
        mapRepository.save(class3);

        List<TeacherDto> teachers = findTeachersByClassNameService.execute(new ClassNameDto("테스트 교실1"));

        assertThat(teachers.get(0).getName()).isEqualTo("홍길동");
        assertThat(teachers.get(1).getName()).isEqualTo("도깨비");
    }
}
