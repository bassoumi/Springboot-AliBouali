package com.bassoumi.demo;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

@Service
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom-file-2.properties"),


})
public class myFirstService {
    private final MyFirstClass myFirstClass;
    private String customProperty;
    @Value("${mycustom.property}")
    private String customPropertyFromAnotherFile;
    @Value("${my.prop.2}")
    private String customPropertyFromAnotherFile2;
    @Value("${mycustom.property.int}")
    private Integer customPropertyInt;




    public  myFirstService(
           @Qualifier("bean1") MyFirstClass myFirstClass
    ) {
        this.myFirstClass = myFirstClass;
    }


    public String tellaStory(){
        return "the dependency is saying: "+myFirstClass.sayHallow();

    }


    public String getCustomPropertyFromAnotherFile() {
        return customPropertyFromAnotherFile;
    }

    public String getCustomPropertyFromAnotherFile2() {
        return customPropertyFromAnotherFile2;
    }

    public String getCustomProperty() {
        return customProperty;
    }

    public Integer getCustomPropertyInt() {
        return customPropertyInt;
    }
}
