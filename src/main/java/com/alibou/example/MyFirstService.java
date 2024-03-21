package com.alibou.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    private MyFirstClass myFirstClass;
    @Value("${my.custom.property}")
    private String customProperty;
    @Value("${my.custom.property.int}")
    private Integer customPropertyInt;

    @Autowired
    public void setMyFirstClass (
            @Qualifier("bean1") MyFirstClass myFirstClass
    ) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory () {
        return "the dependency is saying : " + myFirstClass.sayHello();
    }


    public String getCustomProperty() {
        return customProperty;
    }

    public Integer getCustomPropertyInt() {
        return customPropertyInt;
    }
}
