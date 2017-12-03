$(document).ready(function () {
    $("tr").dblclick(function () {
        if ($(this).children().eq(0).text().toString() != "№") {
            var newUrl = "/patient_info/" + $(this).children().eq(0).val();
            $.ajax({
                url : newUrl,
                data : ({
                    patientId : $(this).children().eq(0).val()
                }),
                success : function (ek) {
                    $(".container").replaceWith(ek);
                    history.pushState(newUrl, 'Пациент', newUrl);
                },
                error : function (e) {
                    //console.log(e);
                }
            });
        }
    });
});

$(function () {
    $.contextMenu({
        selector : 'tr',
        items : {
            update : {name : "Изменить данные пациента", icon : ' '}
        },
        callback : function (key, opt) {
            if ($(this).children().eq(0).text().toString() != "№") {
                var newUrl = "/update_patient/" + $(this).children().eq(0).val();
                $.ajax({
                    url : newUrl,
                    data : ({
                        patientId : $(this).children().eq(0).val()
                    }),
                    success : function (ek) {
                        $(".container").replaceWith(ek);
                        history.pushState(newUrl, 'Пациент', newUrl);
                    },
                    error : function (e) {
                        //console.log(e);
                    }
                });
            }
        }
    });

    $('tr').on('click', function (e) {
        console.log('clicked', this);
    });
});