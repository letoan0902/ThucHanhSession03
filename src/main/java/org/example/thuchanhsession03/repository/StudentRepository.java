package org.example.thuchanhsession03.repository;

import org.example.thuchanhsession03.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final List<Student> students = new ArrayList<>();
    public List<Student> findAll() {
        return students;
    }

    public StudentRepository() {
        students.add(new Student(1, "SV001", "Nguyễn Văn A", "CNTT", 2021, 3.8, "Đang học"));
        students.add(new Student(2, "SV002", "Trần Thị B", "CNTT", 2022, 3.5, "Tốt nghiệp"));
        students.add(new Student(3, "SV003", "Lê Văn C", "Kinh tế", 2023, 2.5, "Bảo lưu"));
        students.add(new Student(4, "SV004", "Phạm Thị D", "Kinh tế", 2022, 3.9, "Đang học"));
        students.add(new Student(5, "SV005", "Hoàng Văn E", "Điện tử", 2021, 3.2, "Tốt nghiệp"));
    }

    public List<Student> findAll() {
        return new ArrayList<>(students);
    }
    public Student findById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
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
}
