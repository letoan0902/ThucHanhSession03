package org.example.thuchanhsession03.service;

import org.example.thuchanhsession03.model.Student;
import org.example.thuchanhsession03.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // ===== UC-01: Danh sách + Sắp xếp =====
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
public List<Student> findAllSorted(String sortBy) {
    List<Student> students = studentRepository.findAll();
    if ("name".equalsIgnoreCase(sortBy)) {
        students.sort((s1, s2) -> s1.getFullName().compareToIgnoreCase(s2.getFullName()));
    } else if ("gpa".equalsIgnoreCase(sortBy)) {
        students.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa())); // Cao -> Thấp
    }
    return students;
}
}
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
