package org.example.thuchanhsession03.repository;

import org.example.thuchanhsession03.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * ===== REPOSITORY: StudentRepository =====
 * Tầng Persistence — nơi lưu trữ và cung cấp dữ liệu sinh viên.
 *
 * NHIỆM VỤ:
 * 1. Khai báo một List<Student> làm "cơ sở dữ liệu giả" (hardcoded).
 *
 * 2. Trong Constructor, khởi tạo danh sách với dữ liệu thực của các thành viên nhóm.
 *    Ví dụ:
 *      students.add(new Student(1, "SV001", "Nguyễn Văn A", "CNTT", 2023, 3.5, "Đang học"));
 *      students.add(new Student(2, "SV002", "Trần Thị B", "CNTT", 2022, 3.8, "Tốt nghiệp"));
 *      ... (thêm đủ thành viên nhóm)
 *
 * 3. Viết các phương thức truy vấn:
 *    - List<Student> findAll()          → Trả về toàn bộ danh sách
 *    - Student findById(int id)         → Tìm sinh viên theo ID, trả null nếu không tìm thấy
 *
 * LƯU Ý:
 * - Annotation @Repository BẮT BUỘC để Spring quản lý Bean này.
 * - Repository CHỈ làm nhiệm vụ truy xuất dữ liệu, KHÔNG chứa logic sắp xếp/lọc.
 * - Dữ liệu phải bao gồm đủ cả 3 trạng thái: "Đang học", "Bảo lưu", "Tốt nghiệp".
 */
@Repository
public class StudentRepository {

    // TODO: Khai báo List<Student> students

    // TODO: Constructor — khởi tạo dữ liệu mẫu (thông tin thành viên nhóm)

    public Student findById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // TODO: findById(int id) — tìm sinh viên theo ID
}
