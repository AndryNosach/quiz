<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/sidebar.css">

<nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar">
    <ul class="nav nav-pills flex-column">
        <li class="nav-item">
            <c:choose>
                <c:when test="${param.currentPage eq 'list'}">
                    <a class="nav-link active" href="/available">Overview<span class="sr-only">(current)</span></a>
                </c:when>
                <c:otherwise>
                    <a class="nav-link" href="/available">Overview</a>
                </c:otherwise>
            </c:choose>
        </li>
        <li class="nav-item">
            <c:choose>
                <c:when test="${param.currentPage eq 'add'}">
                    <a class="nav-link active" href="list">Add Quiz<span class="sr-only">(current)</span></a>
                </c:when>
                <c:otherwise>
                    <a class="nav-link" href="/add">Add Quiz</a>
                </c:otherwise>
            </c:choose>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Statistics</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Account</a>
        </li>
    </ul>

</nav>