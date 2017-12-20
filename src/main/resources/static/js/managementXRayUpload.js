$(document).on('change', ':file', function () {
    var listFiles = this.files;
    for (var i = 0; i < listFiles.length; i++) {
        var newDiv = '<div class = "row col-md-offset-1">' +
            '<div class="input-group col-md-3">' +
            '<span type="text" class="form-control">' + listFiles[i].name + '</span>' +
            '<span class="input-group-addon">' +
            '<i class="glyphicon glyphicon-trash"></i></span></div>' +
            '<div class="input-group date col-md-2">' +
            '<input type="text" class="form-control" name="dateXRay">' +
            '<span class="input-group-addon">' +
            '<i class="glyphicon glyphicon-calendar"></i></span></div>' +
            '<div class="form-group">' +
            '<label for="descriptionXRay' + i + '" class="col-md-1">Описание</label>' +
            '<div class="col-md-5">' +
            '<input type="text" class="form-control" id="descriptionXRay' + i + '" name="descriptionXRay">' +
            '</div></div></div>';
        $(this).parent().after(newDiv);
        $('.date').children('input').val(new Date().toLocaleDateString().replace(/[.]/g, '/'));
    }
    console.log($(this).parent());
    $('.date').datepicker({
        language : "ru",
        format : "dd/mm/yyyy",
        todayHighlight: true
    });
});

$(document).on('click', '.glyphicon-trash', function () {
    $(this).parent().parent().parent().remove();
});