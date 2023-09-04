package com.pmn.gmt.domain.map.service;

import com.pmn.gmt.domain.map.domain.entity.Map;
import com.pmn.gmt.domain.map.domain.entity.location.Structure;
import com.pmn.gmt.domain.map.domain.repository.MapRepository;
import com.pmn.gmt.domain.map.presentation.data.dto.ClassNameDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback
public class FindClassByNameServiceTest {

    @Autowired
    private FindDetailClassByNameService findDetailClassByNameService;
    @Autowired
    private MapRepository mapRepository;

    @Test
    public void findClassByNameTest(){
        Map class1 = new Map(0, "테스트 교실1", null, 1, Structure.MAIN,"실 설명을 입력해주세요.");
        Map class2 = new Map(0, "테스트 교실2", null, 2, Structure.DORMITORY,"실 설명을 입력해주세요.");
        Map class3 = new Map(0, "테스트 교실3", null, 3, Structure.ANNEX,"실 설명을 입력해주세요.");

        mapRepository.save(class1);
        mapRepository.save(class2);
        mapRepository.save(class3);

        assertThat(findDetailClassByNameService.execute(new ClassNameDto("테스트 교실2")).getLocation()).isEqualTo(Structure.DORMITORY.getDescription());
        assertThat(findDetailClassByNameService.execute(new ClassNameDto("테스트 교실2")).getFloor()).isEqualTo(2);
    }
}
