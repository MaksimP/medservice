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
    <div class="container" style="margin-top:50px">
        <div class="row">
            <a href="/add_patient" class="btn btn-primary inline-btn">Добавить пациента</a>
        </div>
        <div class="row">
            <table class="table table-bordered table-condensed table-patient">
                <thead>
                <th>№</th>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Отчество</th>
                <th class="col-md-5">Диагноз</th>
                <th>Просмотр</th>
                <th>Редактировать</th>
                </thead>
            <#list patients as patient>
                <tr class="context-menu">
                    <input type="hidden" value="${(patient.id)!}">
                    <td>${patient?index + 1}</td>
                    <td>${(patient.lastName)!}</td>
                    <td>${(patient.name)!}</td>
                    <td>${(patient.patronymic)!}</td>
                    <td>${(patient.diagnosis)!}</td>
                    <td><a href="/patient_info/${patient.id}" class="btn btn-primary btn-xs">Просмотр</a></td>
                    <td><a href="/update_patient/${patient.id}" class="btn btn-primary btn-xs">Редактировать</a></td>
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

