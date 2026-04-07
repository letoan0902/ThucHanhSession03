<%--
    ===== VIEW: Dashboard — Báo cáo Tổng quan (UC-04) =====
    File: /WEB-INF/views/dashboard.jsp

    NGƯỜI PHỤ TRÁCH: [Thành viên phụ trách UC-04]

    DỮ LIỆU NHẬN TỪ CONTROLLER (qua Model):
      - ${totalStudents}  → int tổng số sinh viên
      - ${averageGpa}     → double GPA trung bình
      - ${topStudent}     → Object Student (thủ khoa - GPA cao nhất)
      - ${statusCount}    → Map<String, Long> số lượng theo trạng thái
        Ví dụ: {"Đang học": 3, "Bảo lưu": 1, "Tốt nghiệp": 2}

    YÊU CẦU HIỂN THỊ:
    1. Tổng số sinh viên trong nhóm
    2. GPA trung bình (format 2 chữ số thập phân):
       <fmt:formatNumber value="${averageGpa}" maxFractionDigits="2"/>
    3. Thủ khoa: Tên + GPA của sinh viên có điểm cao nhất
    4. Tỷ lệ % theo trạng thái (tính: count / total * 100):
       <fmt:formatNumber value="${phanTram}" type="percent"/>
    5. Link quay về danh sách: /students

    TAGLIB CẦN KHAI BÁO:
      <%@ taglib prefix="c" uri="jakarta.tags.core" %>
      <%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>StudentHub - Dashboard</title>
</head>
<body>

    <%-- TODO: Hiển thị tổng số sinh viên --%>

    <%-- TODO: Hiển thị GPA trung bình (dùng fmt:formatNumber) --%>

    <%-- TODO: Hiển thị thông tin Thủ khoa --%>

    <%-- TODO: Hiển thị tỷ lệ % theo trạng thái --%>

    <%-- TODO: Link quay về danh sách --%>

</body>
</html>
