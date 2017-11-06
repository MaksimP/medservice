<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" media="screen">
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="webjars/jquery/3.2.1/jquery.min.js"></script>
   <#-- <script type="text/javascript" src="/js/getPatientInfo.js"></script>-->
    <script>
        $(document).ready(function () {
            $("tr").dblclick(function () {
                if ($(this).children().eq(0).text().toString() != "№") {
                    var newUrl = "/patient_info/" + $(this).children().eq(0).val();
                    $.ajax({
                        url : newUrl,
                        data : ({
                            patientId : $(this).children().eq(0).val()
                        }),
                        success : function (ek) {
                            console.log(ek)
                            $(".container-content").replaceWith(ek);
                            history.pushState(newUrl, 'Пациент', newUrl);
                        },
                        error : function (e) {
                            //console.log(e);
                        }
                    });
                }
            });
        });
    </script>
    <title>Таблица пациентов</title>
</head>
<body>
<div class="container-fluid">
    <div class="row" style="background-color: darkgray">
        <form class="navbar-form navbar-right" style="margin-right: 20px" role="button" action="/logout">
            <button type="submit" class="btn btn-default">Выйти</button>
        </form>
    </div>
    <div class="container-content">
        <div class="row">
            <form class="form-inline" style="margin: 10px" role="button" action="/add_patient">
                <button type="submit" class="btn btn-default">Добавить пациента</button>
            </form>
        </div>
        <div class="row">
            <table class="table table-bordered table-condensed table-patient">
                <thead>
                <th>№</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Отчество</th>
                </thead>
            <#list patients as patient>
                <tr>
                    <input type="hidden" value="${patient.id}">
                    <td>${patient?index + 1}</td>
                    <td>${patient.name}</td>
                    <td>${patient.lastName}</td>
                    <td>${patient.patronymic}</td>
                </tr>
            </#list>
            </table>
        </div>
    </div>
</div>
</body>
</html>

