<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" media="screen">
    <title>Таблица пациентов</title>
</head>
<body>
<div class="container-fluid">
    <div class="row" style="background-color: darkgray">
        <form class="navbar-form navbar-right" style="margin-right: 20px" role="button" action="/logout">
            <button type="submit" class="btn btn-default">Выйти</button>
        </form>
    </div>
    <div class="row">
        <form class="form-inline" style="margin: 10px" role="button" action="/add_patient">
            <button type="submit" class="btn btn-default">Добавить пациента</button>
        </form>
    </div>
    <table class="table table-bordered table-condensed">
        <tr>
            <th>№</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Отчество</th>
        </tr>
        <#list patients as patient>
            <tr>
                <td>${patient.id}</td>
                <td>${patient.name}</td>
                <td>${patient.lastName}</td>
                <td>${patient.patronymic}</td>
            </tr>
        </#list>
    </table>
    <div class="row">

    </div>
</div>
</body>
</html>

