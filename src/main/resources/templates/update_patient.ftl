<!DOCTYPE html>
<html lang="en">
    <head>
    <#import "header.ftl" as head>
        <@head.header/>
        <title>Изменить данные пациента</title>
    </head>

<body>
    <#import "navbar.ftl" as nav>
    <@nav.navbar/>
    <div class="container"  style="margin-top:50px">
        <div class="row" style="margin-top: 20px">
            <form class="form-horizontal" enctype="multipart/form-data" action="/update_patient" method="post">
                <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
                <input type="hidden" name="id" value="${patient.id}">
                <div class="form-group">
                    <label for="lastNamePatient" class="col-md-2 control-label">Фамилия пациента</label>
                    <div class="col-md-3">
                        <input type="text" class="form-control" id="lastNamePatient" name="lastName"
                               value="${(patient.lastName)!}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="namePatient" class="col-md-2 control-label">Имя пациента</label>
                    <div class="col-md-3">
                        <input type="text" class="form-control" id="namePatient" name="name" value="${(patient.name)!}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="patronymicPatient" class="col-md-2 control-label">Отчество пациента</label>
                    <div class="col-md-3">
                        <input type="text" class="form-control" id="patronymicPatient" name="patronymic"
                               value="${(patient.patronymic)!}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="diagnosisPatient" class="col-md-2 control-label">Диагноз</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" id="diagnosisPatient" name="diagnosis"
                               value="${(patient.diagnosis)!}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputHistory" class="col-md-2 control-label">История болезни</label></br>
                    <div align="center">
                        <textarea name="history" class="form-control" id="inputHistory" rows="14" >${(patient.history)!}</textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="imageRoentgen" class="col-md-3 control-label">Добавить рентген-снимки</label>
                    <input type="file" class="filestyle" id="imageRoentgen" name="file" accept="image/*"  data-input="false"
                           data-text="Выбрать" multiple/>
                </div>
                <div class="update-image">
                <#list (patient.arrayBlobFileXRay)! as blobXRay>
                    <#assign indexFile = blobXRay?index>
                    <div class="block">
                        <img src="/roentgen/${patient.id}/${(blobXRay?index)!}" alt="">
                        <div id="edit${indexFile}" class="block-edit col-md-4">
                            <div class="description-edit">
                                <input type="text" class="form-control" name="descriptionXRayEdit"
                                       value="${(blobXRay.descriptionXRay)!}">
                            </div>

                            <div class="input-group date date-edit">
                                <input type="text" class="form-control" name="dateXRayEdit" value="${(blobXRay.dateXRay)!}">
                                <span class="input-group-addon">
                                    <i class="glyphicon glyphicon-calendar"></i>
                                </span>
                            </div>

                            <div style="text-align: center">
                                <label for="flagSave${indexFile}">Удалить существующий снимок</label>
                                <input type="checkbox" id=flagSave${indexFile} class="checkFlagSave"/>
                            </div>
                        </div>
                    </div>
                    <#if  indexFile == 0>
                        <script type="text/javascript" src="js/checkFlagSave.js"></script>
                    </#if>
                </#list>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-1 col-md-10">
                        <a href="/patients_table" class="btn btn-primary inline-btn">Отмена</a>
                        <button type="submit" class="btn btn-primary ok">Изменить</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
