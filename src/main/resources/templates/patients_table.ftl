<!DOCTYPE html>
<html lang="en">
<head>
    <#import "header.ftl" as head>
    <@head.header/>
    <title>Таблица пациентов</title>
</head>

<body>
    <#import "navbar.ftl" as nav>
    <@nav.navbar/>
    <div class="container container-margin">
        <div class="row">
            <a href="/add_patient" class="btn btn-primary inline-btn" style="float: left">Добавить пациента</a>
            <#--<form action="/patients/last_names" class="form-horizontal search-form">
                <div class="form-group">
                    <label for="search-lastname" class="control-label col-md-4">Найти пациентов по фамилии</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="search-lastname" name="search-lastname">
                    </div>
                </div>
            </form>-->
            <form action="/patients/diagnosis" class="form-horizontal search-form">
                <div class="form-group">
                    <label for="diagnosis" class="control-label col-md-4">Найти пациентов по диагнозу</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="diagnosis" name="diagnos">
                    </div>
                    <button class="btn btn-primary" name="search" type="submit">Поиск</button>
                </div>
            </form>
        </div>
        <div class="row">
            <table class="table table-condensed table-patient">
                <thead style="background-color: gainsboro">
                <th>№</th>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Отчество</th>
                <th class="col-md-5">Диагноз</th>
                <th>Действия</th>
                </thead>
            <#list patients as patient>
                <tr class="context-menu">
                    <input type="hidden" value="${(patient.id)!}">
                    <td>${patient?index + 1}</td>
                    <td>${(patient.lastName)!}</td>
                    <td>${(patient.name)!}</td>
                    <td>${(patient.patronymic)!}</td>
                    <td>${(patient.diagnosis)!}</td>
                    <td><a href="/patient_info/${patient.id}" class="btn btn-primary btn-xs">Просмотр</a>
                        <a href="/update_patient/${patient.id}" class="btn btn-primary btn-xs">Редактировать</a>
                    </td>
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
</body>
</html>

