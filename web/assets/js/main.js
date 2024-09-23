window.addEventListener('DOMContentLoaded',function () {
    if (window.location.pathname === '/alarmas.html' || window.location.pathname === '/crear-alarma.html') {
        var navbarHeight = document.getElementById('navbar').offsetHeight;
        var windowHeight = window.innerHeight;
        var contentHeight = windowHeight - navbarHeight;
        document.getElementById('content').style.height = contentHeight + 'px';
    }

    if (window.location.pathname === '/crear-alarma.html') {
        $('select').multipleSelect({
            displayDelimiter: ' | ',
            size: 'lg'
        })
    }
});