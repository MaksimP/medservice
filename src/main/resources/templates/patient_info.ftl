<!DOCTYPE html>
<html>
<head>
    <#import "header.ftl" as head>
    <@head.header/>
    <title>Карточка пациента</title>
</head>

<body>
    <#import "navbar.ftl" as nav>
    <@nav.navbar/>
    <div class="container" style="margin-top: 50px">
        <div class="row">
            <a href="/patients_table" class="btn btn-primary inline-btn">Таблица пациентов</a>
            <a href="/update_patient/${(patient.id)!}" class="btn btn-primary inline-btn">Редактировать пациента</a>
            <br>
        </div>
        <div class="container-info">
            <div class="row row-info">
                <div class="col-md-2">Фамилия пациента</div>
                <div class="col-md-10">${(patient.lastName)!}</div>
            </div>
            <div class="row row-info">
                <div class="col-md-2">Имя пациента</div>
                <div class="col-md-10">${(patient.name)!}</div>
            </div>
            <div class="row row-info">
                <div class="col-md-2">Отчество пациента</div>
                <div class="col-md-10">${(patient.patronymic)!}</div>
            </div>
            <div class="row row-info">
                <div class="col-md-2">Диагноз пациента</div>
                <div class="col-md-10" style="max-height: 100%">${(patient.diagnosis)!}</div>
            </div>
            <div class="row row-info">
                <div class="col-md-12">История болезни пациента</div>
                <div class="col-md-12" style="padding-left: 15px">${(patient.history)!}</div>
            </div>
        </div>
        </br>
        <#list (patient.arrayBlobFileXRay)! as blobXRay>
            <figure>
                <a href="/roentgen/${patient.id}/${(blobXRay?index)!}" id="imageXRayLB${(blobXRay?index)!}" data-lightbox="1">
                    <img src="/roentgen/${patient.id}/${(blobXRay?index)!}" alt="" style="">
                </a>
                <figcaption class="figure-caption">
                    <p>${(blobXRay.dateXRay)!}</p>
                    <p>${(blobXRay.descriptionXRay)!}</p>
                </figcaption>
            </figure>
        </#list>
    </div>
</body>
</html>
