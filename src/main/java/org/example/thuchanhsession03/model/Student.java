package org.example.thuchanhsession03.model;

/**
 * ===== MODEL: Student =====
 * Lớp POJO đại diện cho một sinh viên trong hệ thống.
 *
 * NHIỆM VỤ:
 * 1. Khai báo 7 thuộc tính (private):
 *    - int id              → ID tự tăng
 *    - String studentCode  → Mã sinh viên (VD: "SV001")
 *    - String fullName     → Họ tên đầy đủ
 *    - String faculty      → Khoa (VD: "CNTT", "Kinh tế")
 *    - int enrollmentYear  → Năm nhập học (VD: 2023)
 *    - double gpa          → Điểm trung bình (VD: 3.6)
 *    - String status       → Trạng thái: "Đang học" | "Bảo lưu" | "Tốt nghiệp"
 *
 * 2. Tạo Constructor:
 *    - Constructor không tham số (mặc định)
 *    - Constructor đầy đủ 7 tham số
 *
 * 3. Tạo Getter/Setter cho TẤT CẢ thuộc tính
 *    (BẮT BUỘC — vì EL ${student.fullName} gọi getFullName() ngầm)
 *
 * LƯU Ý:
 * - Đây là class thuần Java (POJO), KHÔNG có annotation Spring.
 * - KHÔNG implements Serializable (chưa cần ở bài này).
 */
public class Student {

    // TODO: Khai báo 7 thuộc tính ở đây
    private int id;
    private String fullName;
    private String studentCode;
    private int id;
    private String studentCode;
    private String fullName;
    private String faculty;
    private int enrollmentYear;
    private double gpa;
    private String status;


    public Student() {
    }

    public Student() {
    }

    // TODO: Constructor đầy đủ 7 tham số

    public Student(int id, String fullName, String studentCode, String faculty, int enrollmentYear, double gpa, String status) {
        this.id = id;
        this.fullName = fullName;
        this.studentCode = studentCode;
        this.faculty = faculty;
        this.enrollmentYear = enrollmentYear;
        this.gpa = gpa;
        this.status = status;
    }

    // TODO: Getter & Setter cho tất cả thuộc tính

    public Student(int id, String studentCode, String fullName, String faculty, int enrollmentYear, double gpa, String status) {
        this.id = id;
        this.studentCode = studentCode;
        this.fullName = fullName;
        this.faculty = faculty;
        this.enrollmentYear = enrollmentYear;
        this.gpa = gpa;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(int enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
