<div class="container">
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
                    <textarea name="history" id="inputHistory" rows="14" >${(patient.history)!}</textarea>
                </div>
            </div>
            <div class="form-group">
                <label for="imageRoentgen" class="col-md-2 control-label">Добавить снимок</label>
                <input type="file" id="imageRoentgen" name="file" accept="image/*" multiple/>
                <br>
                <div class="update-image">
                <#list (patient.listFileNames)! as file>
                    <#assign indexFile = file?index>
                    <img src="/roentgen/${(file)!}" alt="" style="width:40%; margin-top: 15px" name="image"/>
                    <br>
                    <label for="flagSave${indexFile}">Удалить существующий снимок</label>
                    <input type="checkbox" id=flagSave${indexFile} class="checkFlagSave"/>
                    <br><br>
                    <#if  indexFile == 0>
                        <script type="text/javascript" src="js/checkFlagSave.js"></script>
                    </#if>
                </#list>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-offset-1 col-md-10">
                    <button type="button" class="btn btn-default"
                            onclick="window.history.back(); location.reload();">Отмена</button>
                    <button type="submit" class="btn btn-default ok">Изменить</button>
                </div>
            </div>
        </form>
    </div>
</div>