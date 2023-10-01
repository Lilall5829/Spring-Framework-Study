<html lang="en">
<head>
    <title>Document</title>
</head>
<body>
<div class="container">
    <h1>Login</h1>
    <form method="post">
        <pre>${errorMessage}</pre>
        <div>
            <label for="username">Username:</label>
            <%--            name property should be consistent with @RequestParam!!!--%>
            <input type="text" id="username" name="name"/>

        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password"/>
            <p></p>
        </div>
        <label for="submit">
            <input
                    type="submit"
                    id="submit"
                    name="submit"
                    value="Login"
            />
        </label>
    </form>
</div>
</body>
</html>