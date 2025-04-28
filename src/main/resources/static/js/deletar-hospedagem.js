document.querySelectorAll('.btn-deletar').forEach(btn => {
    btn.addEventListener('click', (e) => {
        if (!confirm('Tem certeza que deseja deletar esta hospedagem?')) {
            e.preventDefault();
        }
    });
});