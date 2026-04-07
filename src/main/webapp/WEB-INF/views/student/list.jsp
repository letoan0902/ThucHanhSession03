<%--
    ===== VIEW: Danh sách Sinh viên (UC-01 + UC-03) =====
    File: /WEB-INF/views/student/list.jsp

    NGƯỜI PHỤ TRÁCH: [Thành viên phụ trách UC-01 & UC-03]

    DỮ LIỆU NHẬN TỪ CONTROLLER (qua Model):
      - ${studentList}  → List<Student> danh sách sinh viên
      - ${totalCount}   → int tổng số kết quả
      - ${search}       → String từ khóa tìm kiếm (có thể null)
      - ${faculty}      → String khoa đang lọc (có thể null)
      - ${sortBy}       → String tiêu chí sắp xếp hiện tại (có thể null)

    YÊU CẦU HIỂN THỊ:
    1. Bảng có cột: STT (tự động), Mã SV, Họ tên, Khoa, Năm nhập học, GPA, Trạng thái
    2. STT dùng varStatus.count trong <c:forEach>
    3. Tiêu đề cột "Họ tên" và "GPA" là link sắp xếp:
       - <a href="<c:url value='/students'><c:param name='sortBy' value='name'/></c:url>">Họ tên</a>
       - <a href="<c:url value='/students'><c:param name='sortBy' value='gpa'/></c:url>">GPA</a>
    4. Màu trạng thái (dùng <c:choose>):
       - "Đang học"    → color: green
       - "Bảo lưu"    → color: orange
       - "Tốt nghiệp" → color: blue
    5. Cột "Họ tên" là link đến chi tiết: /students/detail?id=...
    6. Nếu có search hoặc faculty → hiển thị "Tìm thấy [N] sinh viên phù hợp"
    7. Link đến Dashboard: /dashboard

    TAGLIB CẦN KHAI BÁO:
      <%@ taglib prefix="c" uri="jakarta.tags.core" %>
      <%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>StudentHub - Danh sách Sinh viên</title>
    <style>
        .status-studying { color: green; font-weight: bold; }
        .status-on-leave { color: orange; font-weight: bold; }
        .status-graduated { color: blue; font-weight: bold; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .btn-dashboard { margin-bottom: 20px; display: inline-block; padding: 10px 15px; background-color: #007bff; color: white; text-decoration: none; border-radius: 5px; }
    </style>
</head>
<body>

    <h1>Hệ thống Quản lý Sinh viên - StudentHub</h1>

    <table>
        <thead>
            <tr>
                <th>STT</th>
                <th>Mã SV</th>
                <th>
                    <a href="<c:url value='/students'><c:param name='sortBy' value='name'/></c:url>">Họ tên</a>
                </th>
                <th>Khoa</th>
                <th>Năm nhập học</th>
                <th>
                    <a href="<c:url value='/students'><c:param name='sortBy' value='gpa'/></c:url>">GPA</a>
                </th>
                <th>Trạng thái</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${studentList}" var="student" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${student.studentCode}</td>
                    <td>${student.fullName}</td>
                    <td>${student.faculty}</td>
                    <td>${student.enrollmentYear}</td>
                    <td>${student.gpa}</td>
                    <td>
                        <c:choose>
                            <c:when test="${student.status == 'Đang học'}">
                                <span class="status-studying">Đang học</span>
                            </c:when>
                            <c:when test="${student.status == 'Bảo lưu'}">
                                <span class="status-on-leave">Bảo lưu</span>
                            </c:when>
                            <c:when test="${student.status == 'Tốt nghiệp'}">
                                <span class="status-graduated">Tốt nghiệp</span>
                            </c:when>
                            <c:otherwise>
                                ${student.status}
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
