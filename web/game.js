// Não submete o formulário se o quadrado clicado já estiver marcado
$('.square').click(function (event) {
    if (this.innerText) {
        event.preventDefault();
    }
});

// Não submete o formulário se já houver um vencedor
$('form[data-locked="true"]').submit(function (event) {
    event.preventDefault();
});
