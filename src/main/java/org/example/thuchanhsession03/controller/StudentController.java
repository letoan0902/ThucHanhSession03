package org.example.thuchanhsession03.controller;

import org.example.thuchanhsession03.model.Student;
import org.example.thuchanhsession03.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * ===== CONTROLLER: StudentController =====
 * Tầng Presentation — nhận Request, gọi Service, đẩy dữ liệu vào Model, trả về tên View.
 *
 * NGUYÊN TẮC "THIN CONTROLLER":
 * - Controller CHỈ làm 3 việc: nhận param → gọi Service → trả view.
 * - KHÔNG viết logic tính toán, sắp xếp, lọc ở đây.
 *
 * NHIỆM VỤ — 3 endpoints:
 *
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │ 1. GET /students                                                       │
 * │    Params (tất cả optional):                                           │
 * │      - sortBy: "name" hoặc "gpa"                                       │
 * │      - search: từ khóa tìm kiếm theo tên                              │
 * │      - faculty: tên khoa để lọc                                        │
 * │    Logic:                                                              │
 * │      - Nếu có search → gọi service.search(search)                     │
 * │      - Nếu có faculty → gọi service.filterByFaculty(faculty)           │
 * │      - Nếu có sortBy → gọi service.findAllSorted(sortBy)              │
 * │      - Mặc định → gọi service.findAll()                               │
 * │    Model attributes: "studentList", "totalCount", "search", "faculty"  │
 * │    Return: "student/list"  → /WEB-INF/views/student/list.jsp           │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │ 2. GET /students/detail?id=...                                         │
 * │    Param: id (bắt buộc)                                                │
 * │    Logic: gọi service.findById(id)                                     │
 * │    Model attribute: "student"                                          │
 * │    Return: "student/detail"  → /WEB-INF/views/student/detail.jsp       │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │ 3. GET /dashboard                                                      │
 * │    Logic: gọi các phương thức thống kê từ Service                      │
 * │    Model attributes: "totalStudents", "averageGpa",                    │
 * │                       "topStudent", "statusCount"                      │
 * │    Return: "dashboard"  → /WEB-INF/views/dashboard.jsp                 │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * LƯU Ý:
 * - @Controller BẮT BUỘC.
 * - Dùng @Autowired inject StudentService.
 * - Dùng @RequestParam(required = false) cho các param không bắt buộc.
 * - Dùng Model model để đẩy dữ liệu: model.addAttribute("key", value).
 */
@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String listStudents(
            @RequestParam(required = false) String sortBy,
            Model model
    ) {
        List<Student> studentList;

        if (sortBy != null && !sortBy.isEmpty()) {
            studentList = studentService.findAllSorted(sortBy);
        } else {
            studentList = studentService.findAll();
        }

        model.addAttribute("studentList", studentList);
        model.addAttribute("sortBy", sortBy);


    // ===== UC-01 + UC-03: Danh sách + Sắp xếp + Tìm kiếm/Lọc =====
    // Code của UC-01 sẽ ở đây...

    // ===== UC-02: Chi tiết sinh viên (Phần của bạn) =====
    @GetMapping("/students/detail")
    public String getStudentDetail(@RequestParam("id") String id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "student/detail";
    }


    // ===== UC-04: Dashboard =====
    // TODO: @GetMapping("/dashboard")
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("totalStudents", studentService.getTotalStudents());
        model.addAttribute("averageGpa", studentService.getAverageGpa());
        model.addAttribute("topStudent", studentService.getTopStudent());
        model.addAttribute("statusStats", studentService.getStatusPercentages());

        return "dashboard"; // Trả về file dashboard.jsp
    }

    // Code của UC-04 sẽ ở đây...
}
    @Autowired
    private StudentService studentService;
    // ===== UC-01 + UC-03: Danh sách + Sắp xếp + Tìm kiếm/Lọc =====
    @GetMapping("/students")
    public String listStudents(
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "faculty", required = false) String faculty,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            Model model) {

        List<Student> studentList;

        // Xử lý logic ưu tiên theo Note hướng dẫn
        if (search != null && !search.isEmpty()) {
            // UC-03: Tìm kiếm theo tên
            studentList = studentService.search(search);
        } else if (faculty != null && !faculty.isEmpty()) {
            // UC-03: Lọc theo khoa
            studentList = studentService.filterByFaculty(faculty);
        } else if (sortBy != null && !sortBy.isEmpty()) {
            // UC-01: Sắp xếp (giả sử bạn đã viết findAllSorted trong Service)
            studentList = studentService.findAllSorted(sortBy);
        } else {
            // Mặc định: Lấy toàn bộ
            studentList = studentService.findAll();
        }
        model.addAttribute("studentList", studentList);
        model.addAttribute("totalCount", studentList.size());
        model.addAttribute("search", search);
        model.addAttribute("faculty", faculty);
        return "student/list";
    }
}
