package org.aakkmm.students_web.repository;

import org.aakkmm.students_web.mapper.StudentMapper;
import org.aakkmm.students_web.service.StudentService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository<Student> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(String firstName, String lastName, String email, int age, String phoneNumber) {
        String query = "INSERT INTO students (firstName, lastName, email, age, phoneNumber) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, firstName, lastName, email, age, phoneNumber);
    }



}
