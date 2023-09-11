package com.example.demo2.Exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
class YourBusiness{
    DataService dataService;

    public YourBusiness(DataService dataService) {
        this.dataService = dataService;
    }
    public int findMax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
@Component
@Primary
class MongoDbDataService implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[]{ 11, 22, 33, 44, 55};
    }
}
@Component
class MySQLDataService implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[]{1, 2, 3, 4, 5};
    }
}
@Configuration
@ComponentScan
public class BusinessCalculationService {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BusinessCalculationService.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println(context.getBean(YourBusiness.class).findMax());

    }
}
