<%--
    ===== VIEW: Chi tiết Sinh viên (UC-02) =====
    File: /WEB-INF/views/student/detail.jsp

    NGƯỜI PHỤ TRÁCH: [Thành viên phụ trách UC-02]

    DỮ LIỆU NHẬN TỪ CONTROLLER (qua Model):
      - ${student}  → Object Student chứa đầy đủ thông tin

    YÊU CẦU HIỂN THỊ:
    1. Hiển thị TẤT CẢ thuộc tính của Student:
       - ${student.id}
       - ${student.studentCode}
       - ${student.fullName}
       - ${student.faculty}
       - ${student.enrollmentYear}
       - ${student.gpa}
       - ${student.status}
    2. Trạng thái có màu (giống trang list)
    3. Nút "Quay lại danh sách" → link về /students

    TAGLIB CẦN KHAI BÁO:
      <%@ taglib prefix="c" uri="jakarta.tags.core" %>
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>StudentHub - Chi tiết Sinh viên</title>
</head>
<body>

    <%-- TODO: Hiển thị thông tin chi tiết sinh viên --%>

    <%-- TODO: Màu trạng thái --%>

    <%-- TODO: Nút "Quay lại danh sách" --%>

</body>
</html>
