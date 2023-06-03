package com.pmn.gmt.domain.teacher.service;

import com.pmn.gmt.domain.teacher.domain.entity.Teacher;
import com.pmn.gmt.domain.teacher.domain.repository.TeacherRepository;
import com.pmn.gmt.domain.teacher.service.impl.FindAllTeacherServiceImpl;
import com.pmn.gmt.domain.teacher.util.TeacherConverter;
import com.pmn.gmt.domain.teacher.util.impl.TeacherConverterImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FindAllTeacherServiceImplTest {

    @Autowired
    TeacherRepository teacherRepository;
    TeacherConverter teacherConverter;
    FindAllTeacherService findAllTeacherService;

    @BeforeEach
    public void setup() {
        teacherConverter = new TeacherConverterImpl();
        findAllTeacherService = new FindAllTeacherServiceImpl(teacherRepository, teacherConverter);
    }

    @Test
    void execute(){
        teacherRepository.save(Teacher.builder().name("테스트 선생님1").contact("010-0000-0000").department("2학년부").location("2학년 진로실").position("2학년 4반 담임선생님").subject("통신").free("자율동아리1").major("전공동아리1").skill("사설동아리1").build());
        teacherRepository.save(Teacher.builder().name("테스트 선생님2").contact("010-5555-5555").department("학생부").location("학생부실").position("2학년 4반 부담임선생님").subject("과학").free(null).major("전공동아리2").skill(null).build());
        teacherRepository.save(Teacher.builder().name("테스트 선생님3").contact("선생님#4040").department("취업진로부").location("취업진로실").position("교사").subject("미술").free("자율동아리2").major(null).skill(null).build());
        teacherRepository.save(Teacher.builder().name("테스트 선생님4").contact("안녕!#0022").department("3학년부").location("3학년 진로실").position("3학년 2반 담임선생님").subject("네트워크").free(null).major(null).skill(null).build());
        teacherRepository.save(Teacher.builder().name("테스트 선생님5").contact("mona4012@gmail.com").department("마이스터부").location("마이스터부실").position("교사").subject("수학").free("자율동아리3").major(null).skill("사설동아리2").build());

        System.out.println(findAllTeacherService.execute().toString());
    }
}
