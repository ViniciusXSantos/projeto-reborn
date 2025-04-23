@import com.example.agencia_viagens.dto.Page

@template.layout.main(
    page = new Page("Gerenciamento de Cliente"),
    content = @`

    <link rel="stylesheet" href="/css/exibicao-cadastro-cliente.css">
    <link rel="stylesheet" href="/css/gerenciamento-pessoa.css">
    
<style>
    .botao-editar, .botao-deletar {
        text-align: center;
    }
    
</style>

<div class="formulario-container">
<!-- Barra de Pesquisa e Botão Adicionar -->
<section class="secao-pesquisa">
    <form action="#" method="get" class="formulario-pesquisa">
        <div class="entrada-pesquisa">
            <img src="/assets/icons/botao-de-pesquisar.svg" alt="Ícone de Pesquisa" class="icone-pesquisa">
            <input type="text" placeholder="Pesquise" name="search"
                onkeydown="if(event.key === 'Enter'){ this.form.submit(); }">
        </div>
    </form>
    <a class="ancora-add-butao" href="/clientes/novo"><button class="add-butao">+</button></a>
</section>

<!-- Cards dos Funcionários -->
<section class="cartoes-usuario">
    <article class="cartao">
        <div class="foto"><img src="/assets/backgrounds/perfil-equipe.png" alt="Foto do Funcionário"></div>
        
        <div class="cartao-corpo">
            <div class="descricao">
                <h2>Nome do Cliente</h2>
                <p>Descrição</p>
            </div>
            
            <button class="botao-editar">
                <img src="/assets/icons/botao-editar.svg" alt="Editar" class="icone-botao">
                Editar
            </button>
            <button class="botao-deletar">
                <img src="/assets/icons/botao-deletar.svg" alt="Deletar" class="icone-botao">
                Deletar
            </button>
        </div>
    </article>
    <!-- Repita a estrutura do card para outros clientes -->
</section>
</div>
<!-- Script para ativar/desativar o menu -->
<script>
    document.getElementById("alterar-menu").addEventListener("click", function () {
        document.getElementById("barra-lateral").classList.toggle("active");
    });
</script>
`)