<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" media="screen">
    <title>Добавить нового пациента</title>
</head>
<body>
<div class="container">
    <div class="row" style="background-color: darkgray">
        <form class="navbar-form navbar-right" style="margin-right: 20px" role="button" action="/logout">
            <button type="submit" class="btn btn-default">Выйти</button>
        </form>
    </div>
    <div class="row" style="margin-top: 20px">
        <form class="form-horizontal" action="">
            <div class="form-group">
                <label for="namePatient" class="col-md-2 control-label">Имя пациента</label>
                <div class="col-md-3">
                    <input type="text" class="form-control" id="namePatient" name="name">
                </div>
            </div>
            <div class="form-group">
                <label for="lastNamePatient" class="col-md-2 control-label">Фамилия пациента</label>
                <div class="col-md-3">
                    <input type="text" class="form-control" id="lastNamePatient" name="lastName">
                </div>
            </div>
            <div class="form-group">
                <label for="patronymicPatient" class="col-md-2 control-label">Отчество пациента</label>
                <div class="col-md-3">
                    <input type="text" class="form-control" id="patronymicPatient" name="patronymic">
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