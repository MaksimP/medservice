$(function () {
    var btn = $('.ok');
    var form = $(this);

    function checkInput() {
        $('input:text').each(function () {
            var currentContext = $(this);
            if (currentContext.val() == null || currentContext.val() == "") {
                currentContext.addClass('empty_field');
            } else {
                currentContext.removeClass('empty_field');
            }
        });
    }
    
    function lightEmpty() {
        $('.empty_field').css({
            'border-color' : '#d8517d'
        });
    }

    btn.click(function () {
        checkInput();
        if ($('.empty_field').size() > 0) {
            lightEmpty();
            return false;
        } else {
            form.submit();
        }
    });
});