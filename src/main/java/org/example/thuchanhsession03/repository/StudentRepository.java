package org.example.thuchanhsession03.repository;

import org.example.thuchanhsession03.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Student> students;

    // TODO: Constructor — khởi tạo dữ liệu mẫu (thông tin thành viên nhóm)
    public StudentRepository() {
        this.students = new ArrayList<>();

        // Khởi tạo dữ liệu mock (Bạn nên thay bằng tên thật của thành viên trong nhóm mình)
        students.add(new Student(1, "Nguyễn Văn A", "B21DCCN001", "CNTT", 2021, 3.85, "Đang học"));
        students.add(new Student(2, "Trần Thị B", "B21DCCN002", "An toàn thông tin", 2021, 3.20, "Bảo lưu"));
        students.add(new Student(3, "Lê Văn C", "B21DCCN003", "Kế toán", 2021, 3.92, "Tốt nghiệp"));
        students.add(new Student(4, "Phạm Minh D", "B21DCCN004", "CNTT", 2021, 3.45, "Đang học"));
        students.add(new Student(5, "Hoàng Thị E", "B21DCCN005", "Đa phương tiện", 2021, 2.80, "Đang học"));

        students.add(new Student(6, "Ngô Văn H", "B21DCCN006", "CNTT", 2021, 3.10, "Bảo lưu"));
        students.add(new Student(7, "Vũ Thùy Linh", "B21DCCN007", "Quản trị kinh doanh", 2020, 3.75, "Tốt nghiệp"));
        students.add(new Student(8, "Đỗ Anh Tuấn", "B21DCCN008", "Viễn thông", 2022, 2.50, "Đang học"));
        students.add(new Student(9, "Bùi Mai Phương", "B21DCCN009", "CNTT", 2021, 4.00, "Đang học")); // Thủ khoa mới đây!
        students.add(new Student(10, "Trần Gia Hân", "B21DCCN010", "An toàn thông tin", 2021, 3.65, "Đang học"));
    }

    // TODO: findAll() — trả về toàn bộ danh sách
    public List<Student> findAll() {
        return students;
    }

    // TODO: findById(int id) — tìm sinh viên theo ID
    public Student findById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        // Nếu không tìm thấy, trả về null (Controller sẽ xử lý hiển thị lỗi sau)
        return null;
    }
}
