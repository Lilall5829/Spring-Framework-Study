<!DOCTYPE html>
<html>
<head>
    <title>Matrix Transpose</title>
</head>
<body>
<h1>Matrix Transpose</h1>
<form id="matrixForm" method="post">
    <table>
        <tr>
            <td><input type="text" name="matrix00"></td>
            <td><input type="text" name="matrix01"></td>
        </tr>
        <tr>
            <td><input type="text" name="matrix10"></td>
            <td><input type="text" name="matrix11"></td>
        </tr>
    </table>
    <input type="submit" value="Transpose">
</form>
<h2>Result:</h2>
<table>
    <tr>
        <td>${matrix00}</td>
        <td>${matrix01}</td>
    </tr>
    <tr>
        <td>${matrix10}</td>
        <td>${matrix11}</td>
    </tr>
</table>
</body>
</html>
