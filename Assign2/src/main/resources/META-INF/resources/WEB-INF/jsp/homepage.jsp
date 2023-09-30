<html>
<head>
    <title>Palindrome Check</title>
</head>
<body>
<div>
    <h2>Palindrome Checker</h2>
    <form method="post">
        <label for="palindrome">Please input a palindrome:</label>
        <input type="text" id="palindrome" name="palindrome"/>
        <label for="submit1">
            <input
                    type="submit"
                    id="submit1"
                    name="submit"
                    value="submit"
            />
        </label>
        <div>Check Result:</div>
        <pre>${palindrome}</pre>
    </form>
</div>

<div>
    <h2>Substring Checker</h2>
    <form method="post">
        <label for="s1">Please input the first string:</label>
        <input type="text" id="s1" name="s1"/>
        <label for="s2">Please input the second string:</label>
        <input type="text" id="s2" name="s2"/>
        <label for="submit2">
            <input
                    type="submit"
                    id="submit2"
                    name="submit"
                    value="submit"
            />
        </label>
        <div>Check output:</div>
        <pre>${substring}</pre>
    </form>
</div>

<div><h2>Substring(Unique Char) Checker</h2>
    <form method="post">
        <label for="suc1">Please input the first string:</label>
        <input type="text" id="suc1" name="suc1"/>
        <label for="suc2">Please input a unique char:</label>
        <input type="text" id="suc2" name="suc2"/>
        <label for="submit3">
            <input
                    type="submit"
                    id="submit3"
                    name="submit"
                    value="submit"
            />
        </label>
        <div>Check output:</div>
        <pre>${substringUC}</pre>
    </form>
</div>
<div>
    <h2>Matrix Transpose</h2>
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
</div>
<div><h2>Please input a URL:</h2>
    <form method="post">
        <label for="url">URL:</label>
        <input type="text" id="url" name="url"/>
        <label for="submit">
            <input
                    type="submit"
                    id="submit"
                    name="submit"
                    value="submit"
            />
        </label>
        <div>Encoder output:</div>
        <pre>${urlEncoder}</pre>
    </form></div>
</body>
</html>