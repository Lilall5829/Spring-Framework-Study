<%@ include file="common/header.jspf" %>

<%@ include file="common/navigation.jspf" %>

<div class="container">
    <h1>Enter Todo Details</h1>
    <form:form method="post" modelAttribute="todo">
        <fieldset class="mb-3">
            <form:label path="description">Description</form:label>
            <form:input type="text" path="description" required="required"/>
            <form:errors path="description" cssClass="text-warning text-bg-danger"/>
        </fieldset>
        <fieldset class="mb-3">
            <form:label path="targetDate">Target Date</form:label>
            <form:input type="text" path="targetDate" required="required"/>
            <form:errors path="targetDate" cssClass="text-warning text-bg-danger"/>
        </fieldset>
        <fieldset class="mb-3">
            <form:label path="done">Status</form:label>
            <form:input type="text" path="done" required="required"/>
            <form:errors path="done" cssClass="text-warning text-bg-danger"/>
        </fieldset>

        <form:input type="hidden" path="id"/>
<%--        <form:input type="hidden" path="done"/>--%>
        <input type="submit" class="btn btn-success">

    </form:form>
</div>
<%@ include file="common/footer.jspf" %>
<%--The footer file must before the following js code block--%>
<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd',
        startDate: '-3d'
    });
</script>

