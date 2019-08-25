package com.yl.work.test;
import com.yl.work.WorkApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.ConcurrentHashMap;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WorkApplication.class)
@WebAppConfiguration
public class BaseTest {

}
