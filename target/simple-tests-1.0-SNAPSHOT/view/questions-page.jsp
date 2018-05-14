<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=utf-8" %>

<head>
    <title>Add Quiz</title>
    <link href="https://v4-alpha.getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/question-page.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://v4-alpha.getbootstrap.com/dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/question-page.js"></script>
</head>
<body>

<%@include file="parts/header.jsp"%>

<div class="container-fluid">
    <div class="row">
        <nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar">
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link" href="#">Overview</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="#">Add quiz<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Statistics</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Account</a>
                </li>
            </ul>

        </nav>

        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">


            <div class="signup-form">
                <form action="/add" method="post">
                    <h2>Add new Quize</h2>
                    <hr>
                    <h4>Enter question</h4>
                    <!-- HIDDEN DYNAMIC ELEMENT TO CLONE -->
                    <!-- you can replace it with any other elements -->
                    <div class="form-group dynamic-element" style="display:none">
                        <div class="row">
                            <div class="col-md-2"></div>

                            <!-- Replace these fields -->
                            <div class="col-md-4">
                                <select id="profesor" name="profesor[]" class="form-control">
                                    <option value="1">Profesor</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <select id="rol" name="rol[]" class="form-control">
                                    <option>Rol</option>
                                    <option value="1">Guia</option>
                                    <option value="2">Co-Guia</option>
                                    <option value="3">Presidente</option>
                                    <option value="4">Invitado</option>
                                </select>
                            </div>
                            <!-- End of fields-->
                            <div class="col-md-1">
                                <p class="delete">x</p>
                            </div>
                        </div>
                    </div>
                    <!-- END OF HIDDEN ELEMENT -->





                    <div class="form-container">
                        <form class="form-horizontal">
                            <fieldset>
                                <!-- Form Name -->
                                <legend class="title">Comisión</legend>

                                <div class="dynamic-stuff">
                                    <!-- Dynamic element will be cloned here -->
                                    <!-- You can call clone function once if you want it to show it a first element-->
                                </div>

                                <!-- Button -->
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <p class="add-one">+ Añadir Profesor</p>
                                        </div>
                                        <div class="col-md-5"></div>
                                        <div class="col-md-6">
                                            <button id="singlebutton" name="singlebutton" class="btn btn-primary">Guardar Comisión</button>
                                        </div>
                                    </div>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </form>
            </div>


        </main>
    </div>
</div>

</body>
</html>