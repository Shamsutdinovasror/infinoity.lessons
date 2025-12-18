package org.aakkmm.students_web.service;

import jakarta.annotation.PostConstruct;
import org.aakkmm.students_web.model.StudentModel;
import org.aakkmm.students_web.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentService {

    private final UserRepository userRepository;
    AtomicLong id = new AtomicLong(0);
    ArrayList<StudentModel> students = new ArrayList<>();

    public StudentService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public void addStudent(String firstName, String lastName, String email, int age, String phoneNumber) {
        try{
            userRepository.save(firstName, lastName, email, age, phoneNumber);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteStudent(Long id) {
        for (StudentModel s : students) {
            if (s.getId().equals(id)) {
                students.remove(s);
                return;
            }
        }
    }


    public StudentModel getStudent(Long id) {
        for (StudentModel s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        throw new RuntimeException("Student not found");
    }

    public  ArrayList<StudentModel> getAllStudents() {
        return students;
    }

    public void editStudent(Long id, String firstName, String lastName, String email, String age, String phoneNumber) {
        for (StudentModel s : students) {
            if (s.getId().equals(id)) {
                s.setFirstName(firstName);
                s.setLastName(lastName);
                s.setEmail(email);
                s.setAge(age);
                s.setPhoneNumber(phoneNumber);
                return;
            }
        }
    }


}
