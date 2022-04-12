<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Students</title>
</head>
<body>
<h2>Students List</h2>
<p><a href='<c:url value="/add_student" />'>Add</a></p>
<table>
    <tr><th>Id</th><th>Name</th><th>Action</th></tr>
    <c:forEach var="student" items="${students}">
        <tr><td>${student.id}</td>
            <td>${student.name}</td>
<%--            <td>${product.price}</td>--%>
            <td>
                <a href='<c:url value="/edit?id=${student.id}" />'>Edit</a> |
                <form method="post" action='<c:url value="/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${student.id}">
                    <input type="submit" value="Delete">
                </form>
            </td></tr>
    </c:forEach>
</table>
</body>
</html>