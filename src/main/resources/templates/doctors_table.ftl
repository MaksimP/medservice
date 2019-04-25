<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Список докторов</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.0.0/css/bootstrap.css" media="screen">
</head>
<body>
<div class="container-fluid">
    <div class="row" style="background-color: darkgray">
        <form class="navbar-form navbar-right" style="margin-right: 20px" role="button" action="/logout">
            <button type="submit" class="btn btn-default">Выйти</button>
        </form>
    </div>
    <div class="container">
        <div class="row">
            <form class="form-inline" style="margin: 10px" role="button" action="/add_doctor">
                <button type="submit" class="btn btn-default">Добавить пользователя</button>
            </form>
        </div>
        <table class="table table-bordered table-condensed">
            <tr>
                <th>№</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Отчество</th>
                <th>Логин</th>
            </tr>
        <#list doctors as doctor>
            <tr>
                <td>${patient?index + 1}</td>
                <td>${doctor.name}</td>
                <td>${doctor.lastName}</td>
                <td>${doctor.patronymic}</td>
                <td>${doctor.userName}</td>
<<<<<<< HEAD
=======
                <td>${doctor.password}</td>
>>>>>>> bcc4d3b... add new field in the table of doctors
            </tr>
        </#list>
        </table>
    </div>
</div>

</body>
</html>