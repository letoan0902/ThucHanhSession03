package org.example.thuchanhsession03.service;

import org.example.thuchanhsession03.model.Student;
import org.example.thuchanhsession03.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    // TODO: getAverageGpa()
    // TODO: getTopStudent()
    // TODO: getStatusCount()
}
