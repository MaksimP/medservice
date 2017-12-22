$(function () {
    lightbox.option({
        'fitImagesInViewport' : false
    });
});

$(function () {
    var lightB = $('#lightbox');
    lightB.find('.lb-outerContainer').contextmenu('click', function () {
        lightB.hide();
        $('#lightboxOverlay').hide();
        return false;
    });
});

$(function () {
   $('.lb-nav').remove();
});