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
</head>
<body>

    <%-- TODO: Hiển thị thông báo tìm kiếm nếu có search/faculty --%>

    <%-- TODO: Tạo bảng danh sách sinh viên với <c:forEach> --%>

    <%-- TODO: Link sắp xếp trên tiêu đề cột --%>

    <%-- TODO: Màu trạng thái với <c:choose> --%>

    <%-- TODO: Link đến chi tiết sinh viên --%>

    <%-- TODO: Link đến Dashboard --%>
    <h2>Hệ thống Quản lý Sinh viên - StudentHub</h2>

    <%-- UC-03: Hiển thị thông báo tìm kiếm nếu có search/faculty --%>
    <c:if test="${not empty search or not empty faculty}">
        <div style="background-color: #e7f3fe; padding: 10px; margin-bottom: 15px; border-left: 6px solid #2196F3;">
            <p>Kết quả lọc cho:
                <strong>${not empty search ? 'Tên: ' : ''}${search}</strong>
                <strong>${not empty faculty ? ' Khoa: ' : ''}${faculty}</strong>
            </p>
            <p>Tìm thấy <strong>${totalCount}</strong> sinh viên phù hợp.</p>
            <a href="<c:url value='/students'/>">Xóa bộ lọc</a>
        </div>
    </c:if>

    <%-- TODO: Link đến Dashboard --%>
    <p><a href="<c:url value='/dashboard'/>">Xem Dashboard Thống kê</a></p>

    <%-- TODO: Tạo bảng danh sách sinh viên với <c:forEach> --%>
    <table border="1" cellpadding="10" cellspacing="0" style="width: 100%; border-collapse: collapse;">
        <thead>
        <tr style="background-color: #f2f2f2;">
            <th>STT</th>
            <th>Mã SV</th>
            <%-- UC-01: Link sắp xếp trên tiêu đề cột --%>
            <th>
                <a href="<c:url value='/students'><c:param name='sortBy' value='name'/></c:url>">Họ tên (A-Z)</a>
            </th>
            <th>Khoa</th>
            <th>Năm nhập học</th>
            <th>
                <a href="<c:url value='/students'><c:param name='sortBy' value='gpa'/></c:url>">GPA (Cao-Thấp)</a>
            </th>
            <th>Trạng thái</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${studentList}" var="student" varStatus="loop">
            <tr>
                    <%-- STT tự động dùng varStatus --%>
                <td>${loop.count}</td>
                <td>${student.studentCode}</td>

                    <%-- UC-02: Link đến chi tiết sinh viên --%>
                <td>
                    <a href="<c:url value='/students/detail'><c:param name='id' value='${student.id}'/></c:url>">
                            ${student.fullName}
                    </a>
                </td>

                <td>${student.faculty}</td>
                <td>${student.enrollmentYear}</td>
                <td>${student.gpa}</td>

                    <%-- UC-01: Màu trạng thái với <c:choose> --%>
                <td>
                    <c:choose>
                        <c:when test="${student.status eq 'Đang học'}">
                            <span class="status-studying">${student.status}</span>
                        </c:when>
                        <c:when test="${student.status eq 'Bảo lưu'}">
                            <span class="status-reserved">${student.status}</span>
                        </c:when>
                        <c:when test="${student.status eq 'Tốt nghiệp'}">
                            <span class="status-graduated">${student.status}</span>
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

    <c:if test="${empty studentList}">
        <p style="text-align: center; color: red;">Không có dữ liệu sinh viên nào phù hợp!</p>
    </c:if>

</body>
</html>
