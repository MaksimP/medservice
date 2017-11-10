<div class="container" style="margin-top: 20px">
    <div class="row">
        <form action="/patients_table" class="form-inline">
            <button type="submit" class="btn btn-default">Таблица пациентов</button>
        </form>
    </div>
    <div class="row" style="margin-top: 15px">
        <p class="text-nowrap"><span class="patient-field">Имя пациента</span> ${(patient.name)!}</p>
    </div>
    <div class="row">
        <p class="text-nowrap"><span class="patient-field">Фамилия пациента</span> ${(patient.lastName)!}</p>
    </div>
    <div class="row">
        <p class="text-nowrap"><span class="patient-field">Отчество пациента</span> ${(patient.patronymic)!}</p>
    </div>
    <div class="row">
        <p class="text-nowrap"><span class="patient-field">История болезни</span> <br> ${(patient.history)!}</p>
    </div>
    </br>
    <img src="/roentgen/${(patient.fileName)!}" alt="" style="width: 100%; margin-top: 15px">

</div>


