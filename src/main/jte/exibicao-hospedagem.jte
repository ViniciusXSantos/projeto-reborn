@template.layout.main(content = @`
<section class="secao-pesquisa">
    <form action="#" method="get" class="formulario-pesquisa">
        <div class="entrada-pesquisa">
            <img src="../assets/icons/botao-de-pesquisar.svg" alt="Ícone de Pesquisa" class="icone-pesquisa">
            <input type="text" placeholder="Pesquise" name="search"
                onkeydown="if(event.key === 'Enter'){ this.form.submit(); }">
        </div>
    </form>
    <button class="add-butao">+</button>
</section>

<div class="bloco-exibicao">
    <div class="upload-foto">
        <p>Upload de Foto</p>
    </div>

    <div class="info-hospedagem">
        <h2 class="nome-hospedagem">Nome da Hospedagem</h2>
        <p class="descricao-hospedagem">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla
            convallis egestas.</p>
    </div>

    <div class="endereco-hospedagem">
        <p>Endereço: Rua Exemplo, 123 - Cidade, Estado</p>
    </div>

    <div class="acoes-hospedagem">
        <button class="btn-editar">Editar</button>
        <button class="btn-deletar">Deletar</button>
        <button class="btn-habilitar">Habilitar</button>
    </div>
</div>

</main>
</div>

<!-- Script para ativar/desativar o menu -->
<script>
    document.getElementById("alterar-menu").addEventListener("click", function () {
        document.getElementById("barra-lateral").classList.toggle("active");
    });
</script>

`)