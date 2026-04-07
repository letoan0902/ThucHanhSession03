<%--
    ===== VIEW: Dashboard — Báo cáo Tổng quan (UC-04) =====
    File: /WEB-INF/views/dashboard.jsp

    NGƯỜI PHỤ TRÁCH: Phạm Phương Anh

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
    <title>Báo cáo tổng quan</title>
    <style>
        .card {
            border: 1px solid #ccc;
            padding: 15px; margin: 10px 0;
            border-radius: 8px;
            font-family: Arial, sans-serif;
        }
        .highlight {
            background-color: #f0f8ff;
            border-left: 5px solid #007bff; }
        .status-item {
            margin-bottom: 5px; }
    </style>
</head>
<body>

<h1>Báo cáo Tổng quan quản lý sinh viên</h1>
<hr>

<%-- 1. Hiển thị tổng số sinh viên --%>
<div class="card">
    <h3>Tổng số sinh viên trong nhóm</h3>
    <p>Số lượng: <strong>${totalStudents}</strong> sinh viên</p>
</div>

<%-- 2. Hiển thị GPA trung bình (dùng fmt:formatNumber) --%>
<div class="card">
    <h3>GPA Trung bình toàn hệ thống</h3>
    <p>Điểm số:
        <strong>
            <fmt:formatNumber value="${averageGpa}" maxFractionDigits="2" />
        </strong>
    </p>
</div>

<%-- 3. Hiển thị thông tin Thủ khoa --%>
<div class="card highlight">
    <h3>🏆 Thủ khoa của nhóm</h3>
    <c:choose>
        <c:when test="${not empty topStudent}">
            <p>Họ tên: <strong>${topStudent.fullName}</strong></p>
            <p>Mã SV: ${topStudent.studentCode}</p>
            <p>GPA: <span style="color: #d9534f; font-weight: bold;">${topStudent.gpa}</span></p>
        </c:when>
        <c:otherwise>
            <p>Chưa có dữ liệu sinh viên.</p>
        </c:otherwise>
    </c:choose>
</div>

<%-- 4. Hiển thị tỷ lệ % theo trạng thái --%>
<div class="card">
    <h3>📈 Thống kê trạng thái học tập</h3>
    <c:if test="${totalStudents > 0}">
        <c:forEach var="entry" items="${statusCount}">
            <div class="status-item">
                <span>${entry.key}: </span>
                <strong>
                        <%-- Tính toán % trực tiếp trong EL: (Số lượng / Tổng) --%>
                    <fmt:formatNumber value="${entry.value / totalStudents}" type="percent" />
                </strong>
                (${entry.value} sinh viên)
            </div>
        </c:forEach>
    </c:if>
</div>

<%-- 5. Link quay về danh sách --%>
<div style="margin-top: 20px;">
    <a href="${pageContext.request.contextPath}/students">⬅️ Quay lại danh sách sinh viên</a>
</div>

</body>
</html>