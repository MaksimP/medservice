<div class="container">
    <div class="row" style="margin-top: 20px">
        <form class="form-horizontal" enctype="multipart/form-data" action="/add_patient" method="post">
            <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
            <div class="form-group">
                <label for="namePatient" class="col-md-2 control-label">Имя пациента</label>
                <div class="col-md-3">
                    <input type="text" class="form-control" id="namePatient" name="name" value="${(patient.name)!}">
                </div>
            </div>
            <div class="form-group">
                <label for="lastNamePatient" class="col-md-2 control-label">Фамилия пациента</label>
                <div class="col-md-3">
                    <input type="text" class="form-control" id="lastNamePatient" name="lastName"
                           value="${(patient.lastName)!}">
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
                <label for="historyPatient" class="col-md-2 control-label">История болезни</label></br>
                <div align="center">
                    <textarea name="history" id="inputHistory" rows="14" placeholder="${(patient.history)!}"></textarea>
                </div>
            </div>
            <div class="form-group">
                <label for="imageRoentgen" class="col-md-2 control-label">Изменить снимок</label>
                <input type="file" id="imageRoentgen" name="file"/>
                <img src="/roentgen/${(patient.fileName)!}" alt="" style="width: 100%; margin-top: 15px">
            </div>
            <div class="form-group">
                <div class="col-md-offset-1 col-md-10">
                    <button type="button" class="btn btn-default"
                            onclick="window.history.back(); location.reload();">Отмена</button>
                    <button type="submit" class="btn btn-default">Изменить</button>
                </div>
            </div>
        </form>
    </div>
</div>