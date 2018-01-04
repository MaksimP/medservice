$(function () {
    $(".checkFlagSave").change(function () {
        if (!this.checked) {
            $(this).next().remove();
        } else {
            var idString = this.id.toString();
            var newInput = "<input type='hidden' value='"
                + idString.substring(idString.indexOf('e') + 1)
                + "' name='flagSave'>";
            $(this).after(newInput);
        }
    });
});

$(function () {
    let dataEdit = $(".date-edit");
    let descriptionEdit = $(".description-edit");

    dataEdit.on('change', changeListener);
    descriptionEdit.on('change', changeListener);

    function changeListener() {
        let thisParent = this.parentNode;
        if (thisParent.children[0].classList.contains('flagChange')) {
            return false;
        } else {
            let idString = this.parentNode.id;
            let newInput = "<input type='hidden' value='"
                + idString.substring(idString.indexOf('t') + 1)
                + "'class='flagChange' name='flagChange'>";
            $(thisParent).prepend(newInput);
        }
    }
});

$(function () {
    $('.date').datepicker({
        language : "ru",
        format : "dd/mm/yyyy",
        todayHighlight: true
    });
});