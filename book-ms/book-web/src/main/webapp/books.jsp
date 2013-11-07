<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>

<h3>Books</h3>
<table>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.title}</td>
            <td>
                <c:forEach items="${book.authors}" var="author">${author.name}, </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>