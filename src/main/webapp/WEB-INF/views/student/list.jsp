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

</body>
</html>
