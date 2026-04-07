package org.example.thuchanhsession03.service;

import org.example.thuchanhsession03.model.Student;
import org.example.thuchanhsession03.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    // TODO: Inject StudentRepository (dùng @Autowired)

    // ===== UC-01: Danh sách + Sắp xếp =====
    // TODO: findAll()
    // TODO: findAllSorted(String sortBy)

    public Student findById(String id) {
        return studentRepository.findById(id);
    }
    @Autowired
    private StudentRepository studentRepository;

    // ===== UC-03: Tìm kiếm / Lọc =====
    public List<Student> search(String keyword) {
        List<Student> allStudents = studentRepository.findAll();
        if (keyword == null || keyword.trim().isEmpty()) {
            return allStudents;
        }
        return allStudents.stream()
                .filter(s -> s.getFullName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Student> filterByFaculty(String faculty) {
        List<Student> allStudents = studentRepository.findAll();

        if (faculty == null || faculty.trim().isEmpty()) {
            return allStudents;
        }

        // Thực hiện lọc theo khoa (so sánh chính xác)
        return allStudents.stream()
                .filter(s -> s.getFaculty().equalsIgnoreCase(faculty))
                .collect(Collectors.toList());
    }
}