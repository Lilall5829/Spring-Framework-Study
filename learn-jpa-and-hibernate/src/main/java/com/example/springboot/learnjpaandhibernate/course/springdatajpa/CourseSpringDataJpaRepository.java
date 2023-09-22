package com.example.springboot.learnjpaandhibernate.course.springdatajpa;

import com.example.springboot.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//One of the advantage of this interface is you can customize methods like findByAuthor
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    List<Course> findByAuthor(String author);
    List<Course> findByName(String name);
}
