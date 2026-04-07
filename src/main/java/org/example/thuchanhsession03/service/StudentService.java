package org.example.thuchanhsession03.service;

import org.example.thuchanhsession03.model.Student;
import org.example.thuchanhsession03.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ===== SERVICE: StudentService =====
 * Tầng Business — nơi chứa TOÀN BỘ logic nghiệp vụ.
 *
 * NGUYÊN TẮC: Controller KHÔNG được chứa logic tính toán.
 *             Mọi xử lý phải nằm ở Service này.
 *
 * NHIỆM VỤ:
 * 1. Inject StudentRepository bằng @Autowired (qua constructor hoặc field).
 *
 * 2. Viết các phương thức phục vụ từng UC:
 *
 *    --- UC-01: Danh sách + Sắp xếp ---
 *    - List<Student> findAll()
 *    - List<Student> findAllSorted(String sortBy)
 *      + sortBy = "name"  → sắp xếp theo fullName A-Z
 *      + sortBy = "gpa"   → sắp xếp theo GPA cao → thấp
 *      + sortBy = null    → trả về danh sách gốc (không sắp xếp)
 *
 *    --- UC-02: Chi tiết sinh viên ---
 *    - Student findById(int id)
 *
 *    --- UC-03: Tìm kiếm / Lọc ---
 *    - List<Student> search(String keyword)
 *      → Lọc sinh viên có fullName chứa keyword (không phân biệt hoa/thường)
 *    - List<Student> filterByFaculty(String faculty)
 *      → Lọc sinh viên thuộc khoa chỉ định
 *
 *    --- UC-04: Dashboard / Báo cáo ---
 *    - int getTotalStudents()           → Tổng số sinh viên
 *    - double getAverageGpa()           → GPA trung bình toàn nhóm
 *    - Student getTopStudent()          → Sinh viên có GPA cao nhất (Thủ khoa)
 *    - Map<String, Long> getStatusCount() → Đếm số lượng theo từng trạng thái
 *      Ví dụ: {"Đang học": 3, "Bảo lưu": 1, "Tốt nghiệp": 2}
 *
 * LƯU Ý:
 * - @Service BẮT BUỘC để Spring quản lý.
 * - Dùng @Autowired để inject StudentRepository.
 * - KHÔNG truy cập trực tiếp vào List — luôn gọi qua repository.
 */
@Service
public class StudentService {
    public StudentRepository studentRepository;

    // TODO: Inject StudentRepository (dùng @Autowired)

    // ===== UC-01: Danh sách + Sắp xếp =====
    // TODO: findAll()
    // TODO: findAllSorted(String sortBy)

    // ===== UC-02: Chi tiết =====
    // TODO: findById(int id)

    // ===== UC-03: Tìm kiếm / Lọc =====
    // TODO: search(String keyword)
    // TODO: filterByFaculty(String faculty)

    // ===== UC-04: Dashboard =====
    // TODO: getTotalStudents()
    public int getTotalStudents() {
        return studentRepository.findAll().size();
    }
    // TODO: getAverageGpa()
    public double getAverageGpa() {
        List<Student> list = studentRepository.findAll();
        if (list.isEmpty()) return 0.0;

        double sum = 0;
        for (Student s : list) {
            sum += s.getGpa();
        }
        return sum / list.size();
    }

    // TODO: getTopStudent()
    public Student getTopStudent() {
        List<Student> list = studentRepository.findAll();
        if (list.isEmpty()) return null;

        Student top = list.get(0);
        for (Student s : list) {
            if (s.getGpa() > top.getGpa()) {
                top = s;
            }
        }
        return top;
    }


    // TODO: getStatusCount()
    public Map<String, Double> getStatusPercentages() {
        List<Student> studentList = studentRepository.findAll();
        Map<String, Double> stats = new HashMap<>();
        if (studentList.isEmpty()){
            return stats;
        }

        int total = studentList.size();
        int active = 0, reserved = 0, graduated = 0;
        for (Student s : studentList) {
            switch (s.getStatus()) {
                case "Đang học": active++; break;
                case "Bảo lưu": reserved++; break;
                case "Tốt nghiệp": graduated++; break;
            }
        }

        // Tính toán phần trăm
        stats.put("Active", (active * 100.0) / total);
        stats.put("Reserved", (reserved * 100.0) / total);
        stats.put("Graduated", (graduated * 100.0) / total);

        return stats;
    }
}
