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