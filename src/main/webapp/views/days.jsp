<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
<body>
<form method="get">
    <table border 3>
    Select days: <input type="number" value="${daysParam}" name="days"><br/>
    <input type="submit" value="show">
</form>
<br/>
<c:choose>
    <c:when test="${dupa == null}">
        <tr>
            <td>List is empty</td>
        </tr>
    </c:when>
    <c:otherwise>
        <c:forEach items="${dupa}" var="day">
            <tr>
                <td>Date after: <c:out value="${day.daysAfter}"/></td> <td>days: <c:out value="${day.after}"/> <br/></td>
            </tr>
        </c:forEach>
    </c:otherwise>
</c:choose>
</table>
</body>
</html>