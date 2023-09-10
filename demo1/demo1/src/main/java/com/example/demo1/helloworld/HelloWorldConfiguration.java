package com.example.demo1.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
record Person (String name, int age, Address myAddress){

};
record Address(String firstLine, String city){

};
@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name(){
        return "Lila";
    }
    @Bean
    public int age(){
        return 28;
    }
    @Bean
    public Person person(){
        var person = new Person(name(), age(), new Address("10 Pearl Pl", "Kitchener"));
        return person;
    }
    @Bean
    public Person personParameter(String name, int age, Address myAddress){
        var personParameter = new Person(name, age, myAddress);
        return personParameter;
    }
    @Bean(name = "myAddress")
    public Address address(){
        return new Address("1 Krug St", "Kitchener");
    }
}
