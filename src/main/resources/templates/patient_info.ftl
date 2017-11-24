<div class="container" style="margin-top: 20px">
    <div class="row">
        <form action="/patients_table" class="form-inline">
            <button type="submit" class="btn btn-default">Таблица пациентов</button>
        </form>
    </div>
    <div class="row" style="margin-top: 15px">
        <p class="text-nowrap">
            <span class="patient-field col-md-2">Имя пациента</span> ${(patient.name)!}
        </p>
    </div>
    <div class="row">
        <p class="text-nowrap">
            <span class="patient-field col-md-2">Фамилия пациента</span> ${(patient.lastName)!}
        </p>
    </div>
    <div class="row">
        <p class="text-nowrap">
            <span class="patient-field col-md-2">Отчество пациента</span> ${(patient.patronymic)!}
        </p>
    </div>
    <div class="row">
        <p class="">
            <span class="patient-field col-md-2">История болезни</span> <br> ${(patient.history)!}
        </p>
    </div>
    </br>
    <a href="/roentgen/${(patient.fileName)!}" data-lightbox="1">
        <img src="/roentgen/${(patient.fileName)!}" alt="test" style="width: 50%; margin-top: 15px">
    </a>
</div>