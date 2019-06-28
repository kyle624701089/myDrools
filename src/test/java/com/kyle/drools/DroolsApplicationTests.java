package com.kyle.drools;

import com.kyle.drools.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DroolsApplicationTests {

    @Resource
    private KieSession kieSession;

    @Test
    public void contextLoads() {
        Person person = new Person();
        person.setAge(40);
        person.setName("张三");
        kieSession.insert(person);
        int i = kieSession.fireAllRules();
        System.out.println("成功执行了：" + i + "条规则");
    }

}
