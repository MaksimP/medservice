<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Авторизация</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <#if logout>

    </#if>
    <#if error>
        
    </#if>
    <form method="post" action="/login" class="form_login">
        <fieldset>
            <label for="login">Логин</label>
            <input id="login" type="text" name="username" required autofocus>
            <label for="login_password">Пароль</label>
            <input id="login_password" type="password" name="password" required>
            <button id="login_button" type="submit">Войти</button>
           <!-- <input type="hidden" name="{_csrf.parameterName}" value="{$_csrf.token}" /> -->
        </fieldset>
    </form>
</div>

</body>
</html>