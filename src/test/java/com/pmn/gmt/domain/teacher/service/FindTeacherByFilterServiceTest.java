package com.pmn.gmt.domain.teacher.service;

import com.pmn.gmt.domain.teacher.domain.entity.Teacher;
import com.pmn.gmt.domain.teacher.domain.repository.TeacherRepository;
import com.pmn.gmt.domain.teacher.presentation.data.dto.FilterDto;
import com.pmn.gmt.domain.teacher.presentation.data.dto.TeacherDto;
import com.pmn.gmt.domain.teacher.util.TeacherConverter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback
public class FindTeacherByFilterServiceTest {

    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    FindTeachersByFilterService findTeachersByFilterService;
    @Autowired
    TeacherConverter teacherConverter;

    @Test
    public void tagFilterTest(){
        Teacher teacher1 = new Teacher("테스트 1", "010-0000-0000","1학년부","1학년 교무실","1-1반 담임선생님","국어", null,null, null);
        Teacher teacher2 = new Teacher("테스트 2", "010-0000-0000","1학년부","1학년 교무실","1-2반 담임선생님","정보", "자유","전공", "사설");
        Teacher teacher3 = new Teacher("테스트 3", "010-0000-0000","2학년부","2학년 교무실","2-3반 담임선생님","역사", null,"전공", "사설");
        Teacher teacher4 = new Teacher("테스트 4", "010-0000-0000","3학년부","3학년 교무실","3-4반 담임선생님","사회", "자유","전공", "사설");
        Teacher teacher5 = new Teacher("테스트 5", "010-0000-0000",null,"음악실","음악선생님","음악", "자유",null, "사설");

        teacherRepository.save(teacher1);
        teacherRepository.save(teacher2);
        teacherRepository.save(teacher3);
        teacherRepository.save(teacher4);
        teacherRepository.save(teacher5);

        FilterDto filter = new FilterDto(true, false, true,true,false,false, "테스트");

        List<TeacherDto> teacherList = findTeachersByFilterService.execute(filter);

        assertThat(teacherList.get(0).getName()).isEqualTo("테스트 2");
    }

    @Test
    public void nameFilterTest(){
        Teacher teacher1 = new Teacher("홍길동", "010-0000-0000","1학년부","1학년 교무실","1-1반 담임선생님","국어", null,null, null);
        Teacher teacher2 = new Teacher("도깨비", "010-0000-0000","1학년부","1학년 교무실","1-2반 담임선생님","정보", "자유","전공", "사설");
        Teacher teacher3 = new Teacher("전래동화", "010-0000-0000","2학년부","2학년 교무실","2-3반 담임선생님","역사", null,"전공", "사설");
        Teacher teacher4 = new Teacher("점순이", "010-0000-0000","3학년부","3학년 교무실","3-4반 담임선생님","사회", "자유","전공", "사설");
        Teacher teacher5 = new Teacher("반쪽이", "010-0000-0000",null,"음악실","음악선생님","음악", "자유",null, "사설");

        teacherRepository.save(teacher1);
        teacherRepository.save(teacher2);
        teacherRepository.save(teacher3);
        teacherRepository.save(teacher4);
        teacherRepository.save(teacher5);

        FilterDto filter = new FilterDto(false, false, false,false,false,false, "홍길");

        List<TeacherDto> teacherList = findTeachersByFilterService.execute(filter);

        assertThat(teacherList.get(0).getName()).isEqualTo("홍길동");
    }
}
