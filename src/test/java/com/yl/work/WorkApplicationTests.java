package com.yl.work;

import com.yl.work.entity.ConceptAmountEntity;
import com.yl.work.mapper.ConceptAmountMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkApplicationTests {
    @Autowired
    private ConceptAmountMapper conceptAmountMapper;

    @Test
    public void contextLoads() {
        ConceptAmountEntity aEntity = new ConceptAmountEntity();
        aEntity.setCname("你好");
        List<ConceptAmountEntity> result = conceptAmountMapper.select(aEntity,null,null,null);
        System.out.println("size = " + result.size());
    }

}
