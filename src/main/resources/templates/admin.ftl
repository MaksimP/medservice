<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head lang="en">
    <meta charset="UTF-8">
    <title>Панель администратора</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.0.0/css/bootstrap.min.css" media="screen">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <#import "navbar.ftl" as nav>
    <@nav.navbar/>
    <div class="container"  style="margin-top:50px">
        <div class="row">
            <h2 class="h2 title_admin_panel">Панель администратора</h2>
        </div>
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="change_data_doctor">
                        <h3 class="h3">Редактирование базы пользователей</h3>
                        <a class="href_admin" href="/add_doctor">Добавить пользователя</a></br>
                        <a class="href_admin" href="/doctors_table">Редактировать существующего</a><br>
                        <a class="href_admin" href="/doctors_table">Посмотреть весь список</a></br><br>
                        <a class="href_admin" href="/patients_table">Редактирование базы пациентов</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>