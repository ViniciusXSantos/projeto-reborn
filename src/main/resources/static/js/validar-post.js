document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('form');
    const button = document.querySelector('button[type="submit"]');

    if (form && button) {
        // Quando clicar no botão
        button.addEventListener('click', function(event) {
            console.log('[DIAGNÓSTICO] Botão de submit clicado.');
        });

        // Quando tentar enviar o form
        form.addEventListener('submit', function(event) {
            console.log('[DIAGNÓSTICO] Formulário tentou enviar.');

            // Opcional: Se quiser ver o que seria enviado
            const formData = new FormData(form);
            for (const [name, value] of formData.entries()) {
                console.log(`[DIAGNÓSTICO] Campo: ${name} = ${value}`);
            }
        });
    } else {
        console.error('[DIAGNÓSTICO] Formulário ou botão não encontrado.');
    }
});