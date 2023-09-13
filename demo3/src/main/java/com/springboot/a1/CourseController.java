package com.springboot.a1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    @RequestMapping("/courses")
    public List<Course> retrieveAllCourse(){
        return Arrays.asList(
                new Course(1,"LEARN AWS", "IN 28DAYS"),
                new Course(2,"LEARN DEC", "IN 28DAYS"),
                new Course(3,"LEARN Azure", "IN 28DAYS")
        );
    }
}
