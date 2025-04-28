function confirmarDelecao(id) {
    if (confirm('Tem certeza que deseja deletar este cliente?')) {
        window.location.href = '/clientes/delete/' + id;
    }
}