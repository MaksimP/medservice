<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Авторизация</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.0.0/css/bootstrap.min.css" media="screen">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-3">
            <div class="panel panel-default" style="margin-top: 65px">
                <div class="panel-body">
                <#-- <#if logout>
                     <div class="alert alert-warning" role="alert">..</div>
                 </#if>-->
                <#if error>
                    <div class="alert alert-danger" role="alert">Неверный логин или пароль</div>
                </#if>
                    <form class="form-horizontal" method="post" action="/login">
                        <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
                        <div class="form-group">
                            <label for="username" class="col-sm-2 control-label">Логин</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="username" placeholder="Логин" name="username"
                                       autofocus>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="login_password" class="col-sm-2 control-label">Пароль</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="login_password" placeholder="Пароль"
                                       name="password">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">Войти</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>