package com.kyle.drools.controller;

import com.kyle.drools.entity.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *@ ClassName DroolsTestController
 *@ Description TODO
 *@ author sunkai-019
 *@ Date 2019/6/28 9:52
 *@ version 1.0
 **/
@RequestMapping(("/drools"))
@Controller
public class DroolsTestController {

    @GetMapping("/test")
    @ResponseBody
    public void test() {
        Person person = new Person();
        person.setAge(40);
        person.setName("张三");
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kieSession = kContainer.newKieSession("ksession-rules");
        kieSession.insert(person);
        int i = kieSession.fireAllRules();
        System.out.println("成功执行了：" + i + "条规则");
    }
}
