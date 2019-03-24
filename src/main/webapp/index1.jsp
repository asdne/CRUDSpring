<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>
<h2>Hello World!</h2>
<c:choose>
    <c:when test="${empty persons}">
        <p>There are no comments in system yet.</p>
    </c:when>
    <c:otherwise>
        <table border="1">
            <tr>
                <td>INDEX</td>
                <td>Фамилия</td>
                <td>Имя</td>
                <td>адрес</td>
                <td>Редактировать</td>
                <td>Удалить нафиг!</td>
            </tr>
            <c:forEach items="${persons}" var="comment" varStatus="status">
                <tr valign="top">
                    <td>${status.index+1}</td>
                    <td>${comment.surname}</td>
                    <td>${comment.name}</td>
                        <%-- The c:out will escape html/xml characters. --%>
                    <td><pre><c:out value="${comment.address}"/></pre></td>
                    <td><a href="./edit?id=${comment.id}">ага</a></td><td><a href="./del?id=${comment.id}">ага</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="./new">создать, блин</a>
    </c:otherwise>
</c:choose>
</body>
</html>
