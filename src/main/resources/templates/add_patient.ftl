<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="webjars/bootstrap/3.0.0/css/bootstrap.min.css" media="screen">
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/autoUpperCaseFirstLetter.js"></script>
    <script type="text/javascript" src="js/checkInputAreEmpty.js"></script>
    <title>Добавить нового пациента</title>
</head>
<body>
<div class="container-fluid">
    <div class="row" style="background-color: darkgray">
        <form class="navbar-form navbar-right" style="margin-right: 20px" role="button" action="/logout">
            <button type="submit" class="btn btn-default">Выйти</button>
        </form>
    </div>
    <div class="container">
        <div class="row" style="margin-top: 20px">
            <form class="form-horizontal" enctype="multipart/form-data" action="/add_patient" method="post">
                <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
                <div class="form-group">
                    <label for="lastNamePatient" class="col-md-2 control-label">Фамилия пациента</label>
                    <div class="col-md-3">
                        <input type="text" class="form-control" id="lastNamePatient" name="lastName">
                    </div>
                </div>
                <div class="form-group">
                    <label for="namePatient" class="col-md-2 control-label">Имя пациента</label>
                    <div class="col-md-3">
                        <input type="text" class="form-control" id="namePatient" name="name">
                    </div>
                </div>
                <div class="form-group">
                    <label for="patronymicPatient" class="col-md-2 control-label">Отчество пациента</label>
                    <div class="col-md-3">
                        <input type="text" class="form-control" id="patronymicPatient" name="patronymic">
                    </div>
                </div>
                <div class="form-group">
                    <label for="diagnosisPatient" class="col-md-2 control-label">Диагноз</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" id="diagnosisPatient" name="diagnosis">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputHistory" class="col-md-2 control-label">История болезни</label></br>
                    <div align="center">
                        <textarea  class="form-control" name="history" id="inputHistory" rows="14"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="imageRoentgen" class="col-md-2 control-label">Снимок</label>
                    <input type="file" id="imageRoentgen" name="file" accept="image/*" multiple/>
                </div>

                <div class="form-group">
                    <div class="col-md-offset-1 col-md-10">
                        <button type="submit" class="btn btn-default ok">Добавить</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>