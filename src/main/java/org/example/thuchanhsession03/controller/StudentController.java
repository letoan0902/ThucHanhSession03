package org.example.thuchanhsession03.controller;

import org.example.thuchanhsession03.model.Student;
import org.example.thuchanhsession03.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

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
