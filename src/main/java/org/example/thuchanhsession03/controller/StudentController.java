package org.example.thuchanhsession03.controller;

import org.example.thuchanhsession03.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
public class StudentController {

    // TODO: Inject StudentService (dùng @Autowired)

    // ===== UC-01 + UC-03: Danh sách + Sắp xếp + Tìm kiếm/Lọc =====
    // TODO: @GetMapping("/students")

    // ===== UC-02: Chi tiết sinh viên =====
    // TODO: @GetMapping("/students/detail")

    // ===== UC-04: Dashboard =====
    // TODO: @GetMapping("/dashboard")
}
