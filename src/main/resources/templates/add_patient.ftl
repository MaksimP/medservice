<!DOCTYPE html>
<html lang="en">
<head>
    <#import "header.ftl" as head>
    <@head.header/>
    <title>Добавить нового пациента</title>
</head>

<body>
    <#import "navbar.ftl" as nav>
    <@nav.navbar/>
    <div class="container"  style="margin-top:50px">
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
                    <label for="imageXRay" class="col-md-3 control-label">Загрузить рентген-снимки</label>
                    <input type="file" class="filestyle" id="imageXRay" name="file" accept="image/*" data-input="false"
                           data-text="Выбрать" multiple/>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-1 col-md-10">
                        <button type="submit" class="btn btn-default ok">Добавить</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>