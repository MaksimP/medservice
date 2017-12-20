<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="webjars/bootstrap/3.0.0/css/bootstrap.min.css" media="screen">
    <link rel="stylesheet" href="webjars/jQuery-contextMenu/2.6.2/dist/jquery.contextMenu.min.css">
    <link rel="stylesheet" href="webjars/lightbox/2.9.0/dist/css/lightbox.min.css">
    <link rel="stylesheet" href="webjars/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css">
    <link rel="stylesheet" href="css/style.css">

    <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>
    <script type="text/javascript" src="webjars/jQuery-contextMenu/2.6.2/dist/jquery.contextMenu.min.js"></script>
    <script type="text/javascript" src="webjars/jQuery-contextMenu/2.6.2/dist/jquery.ui.position.min.js"></script>
    <script type="text/javascript" src="webjars/lightbox/2.9.0/dist/js/lightbox.min.js"></script>
    <script type="text/javascript" src="webjars/moment/2.19.4/min/moment.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap-filestyle/1.3.0/src/bootstrap-filestyle.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap-datepicker/1.7.1/locales/bootstrap-datepicker.ru.min.js"></script>

    <script type="text/javascript" src="js/getPatientInfo.js"></script>
    <script type="text/javascript" src="js/reSizeImage.js"></script>
    <script type="text/javascript" src="js/autoUpperCaseFirstLetter.js"></script>
    <script type="text/javascript" src="js/checkInputAreEmpty.js"></script>
    <script type="text/javascript" src="js/movingXRayImage.js"></script>
    <script type="text/javascript" src="js/managementXRayUpload.js"></script>

    <title>Таблица пациентов</title>
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
            <form class="form-inline" style="margin: 10px" role="button" action="/add_patient">
                <button type="submit" class="btn btn-primary">Добавить пациента</button>
            </form>
        </div>
        <div class="row">
            <table class="table table-bordered table-condensed table-patient">
                <thead>
                <th>№</th>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Отчество</th>
                <th>Диагноз</th>
                </thead>
            <#list patients as patient>
                <tr class="context-menu">
                    <input type="hidden" value="${(patient.id)!}">
                    <td>${patient?index + 1}</td>
                    <td>${(patient.lastName)!}</td>
                    <td>${(patient.name)!}</td>
                    <td>${(patient.patronymic)!}</td>
                    <td>${(patient.diagnosis)!}</td>
                </tr>
            </#list>
            </table>
        </div>
    </div>
    <div class="contextMenu1" id="updateMenu" style="display: none">
        <ul>
            <li class="context-menu-item" id="update">Изменить данные пациента</li>
        </ul>
    </div>
</div>
</body>
</html>

