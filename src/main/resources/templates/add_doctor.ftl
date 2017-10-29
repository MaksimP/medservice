<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Редактирование базы докторов</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <form action="/">
            <div class="text_field">
                <label for="username_doctor">Логин</label>
                <input id="username_doctor" type="text" name="username"/></br>
            </div>

            <div class="text_field">
                <label for="password_doctor">Пароль</label>
                <input id="password_doctor" type="text" name="password"/></br>
            </div>

            <div class="text_field">
                <label for="name_doctor">Имя</label>
                <input id="name_doctor" type="text" name="name_doctor"/></br>
            </div>
            <div class="text_field">
                <label for="last_name_doctor">Фамилия</label>
                <input id="last_name_doctor" type="text" name="last_name"/></br>
            </div>
            <div class="text_field">
                <label for="patronymic_doctor">Отчество</label>
                <input id="patronymic_doctor" type="text" name="patronymic"/></br>
            </div>
            <div class="change_data_button">
                <button id="change_data" type="submit" name="change_data">Изменить данные</button>
            </div>
        </form>
    </div>

</body>
</html>