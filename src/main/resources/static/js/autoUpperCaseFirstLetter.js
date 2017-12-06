$(function () {
    $("input:text").blur(function () {
        var currentContext = $(this);
        if (currentContext != null || currentContext != '') {
            currentContext.val(function (index, text) {
                return text.charAt(0).toLocaleUpperCase() + text.substr(1).toLocaleLowerCase();
            });
        }
    });
});