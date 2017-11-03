<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Редактирование базы пользователей</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" media="screen">
</head>
<body>
    <div class="container">
        <div class="row" style="background-color: darkgray">
            <form class="navbar-form navbar-right" style="margin-right: 20px" role="button" action="/logout">
                <button type="submit" class="btn btn-default">Выйти</button>
            </form>
        </div>
        <div class="row" style="margin-top: 20px">
            <form class="form-horizontal" action="/add_doctor" method="post">
                <div class="form-group">
                    <label for="username" class="col-md-2 control-label">Логин</label>
                    <div class="col-md-3">
                        <input type="text" class="form-control" id="userName" name="userName">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-md-2 control-label">Пароль</label>
                    <div class="col-md-3">
                        <input type="password" class="form-control" id="password" name="password">
                    </div>
                </div>
                <div class="form-group">
                    <label for="nameDoctor" class="col-md-2 control-label">Имя</label>
                    <div class="col-md-3">
                        <input type="text" class="form-control" id="nameDoctor" name="name">
                    </div>
                </div>
                <div class="form-group">
                    <label for="lastNameDoctor" class="col-md-2 control-label">Фамилия</label>
                    <div class="col-md-3">
                        <input type="text" class="form-control" id="lastNameDoctor" name="lastName">
                    </div>
                </div>
                <div class="form-group">
                    <label for="patronymicDoctor" class="col-md-2 control-label">Отчество</label>
                    <div class="col-md-3">
                        <input type="text" class="form-control" id="patronymicDoctor" name="patronymic">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10">
                        <button type="submit" class="btn btn-default">Добавить</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

</body>
</html>