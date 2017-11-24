$(function () {
    lightbox.option({
        'fitImagesInViewport' : false
    });
});

$(function () {
    var lightB = $('#lightbox');
    lightB.find('.lb-outerContainer').on('click', function () {
        lightB.hide();
        $('#lightboxOverlay').hide();
        return false;
    })
});