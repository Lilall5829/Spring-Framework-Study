<%@ include file="common/header.jspf" %>

<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h1>Hi ${name}, your Todos</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Completed?</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
                <td><a href="update-todo?id=${todo.id}" class="btn btn-warning">UPDATE</a></td>
                <td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">DELETE</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="add-todo" class="btn btn-success">Add todo</a>
</div>

<script src="webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.4/jquery.min.js"></script>
<script src="webjars/bootstrap-datepicker/1.10.0/js/bootstrap-datepicker.min.js"></script>


</body>
</html>