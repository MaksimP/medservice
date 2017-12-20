<div class="container" style="margin-top: 20px">
    <div class="row">
        <form action="/patients_table" class="form-inline col-md-2">
            <button type="submit" class="btn btn-primary">Таблица пациентов</button>
        </form>
        <form action="/update_patient/${(patient.id)!}" class="form-inline">
            <button type="submit" class="btn btn-primary">Редактировать пациента</button>
        </form>
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
            <div class="col-md-10">${(patient.diagnosis)!}</div>
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