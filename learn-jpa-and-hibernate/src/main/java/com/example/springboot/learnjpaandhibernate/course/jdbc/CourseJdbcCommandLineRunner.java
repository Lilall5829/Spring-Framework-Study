package com.example.springboot.learnjpaandhibernate.course.jdbc;

import com.example.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CourseJdbcRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1,"LearnAWS","in28days"));
        repository.insert(new Course(2,"LearnAzure","in28days"));
        repository.insert(new Course(3,"LearnDev","in28days"));
        repository.deleteById(1);
        System.out.println(repository.selectById(2));

    }
}
