package org.example.thuchanhsession03.repository;

import org.example.thuchanhsession03.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private List<Student> students = new ArrayList<>();
    public StudentRepository() {
        students.add(new Student(1, "SV001", "Lê Tiến Đức", "CNTT", 2024, 3.9, "Đang học"));
        students.add(new Student(2, "SV002", "Nguyễn Văn A", "CNTT", 2024, 3.2, "Bảo lưu"));
        students.add(new Student(3, "SV003", "Trần Thị B", "Kinh tế", 2023, 3.8, "Tốt nghiệp"));
        students.add(new Student(4, "SV004", "Phạm Văn C", "Ngoại ngữ", 2024, 2.5, "Đang học"));
    }

    public List<Student> findAll() {
        return students;
    }

    public Student findById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }
}