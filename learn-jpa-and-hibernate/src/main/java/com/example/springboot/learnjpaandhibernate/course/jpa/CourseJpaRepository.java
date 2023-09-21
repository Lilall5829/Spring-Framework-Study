package com.example.springboot.learnjpaandhibernate.course.jpa;

import com.example.springboot.learnjpaandhibernate.course.Course;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {
//    @Autowired
    @PersistenceContext
    private EntityManager entityManager;
    //Mapping entity to the table by entityManager.merge
    public void insert(Course course){
        entityManager.merge(course);
    }
    //Find operation
    public Course findById(long id){
        return entityManager.find(Course.class, id);
    }
    //Delete operation
    public void deleteById(long id){
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

}
