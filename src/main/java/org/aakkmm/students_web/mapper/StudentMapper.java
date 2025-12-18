package org.aakkmm.students_web.mapper;

import org.aakkmm.students_web.model.StudentModel;
import org.aakkmm.students_web.service.StudentService;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<StudentModel> {

    @Override
    public StudentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        long id = rs.getLong("id");
        String name = rs.getString("firstName");
        String surname = rs.getString("lastName");
        String email = rs.getString("email");
        String age = rs.getString("age");
        String phone = rs.getString("phoneNumber");
        return new StudentModel(id, name, surname, email, age, phone);
    }
}
