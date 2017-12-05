$(function () {
    $("input:text").blur(function () {
        if ($(this) != null || $(this) != '') {
            $(this).val(function (index, text) {
                return text.charAt(0).toLocaleUpperCase() + text.substr(1).toLocaleLowerCase();
            });
        }
    });
});