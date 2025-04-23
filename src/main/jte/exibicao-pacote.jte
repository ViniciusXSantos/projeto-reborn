@import com.example.agencia_viagens.dto.Page

@template.layout.main(
    page = new Page("Gerenciamento de Pacote"),
    content = @`

<style>
    .img-viagem {
        height: 265px;
        width: 265px;
        align-content: center;
    }

    .botoes {
        display: block;
    }

    .botao-editar, .botao-deletar, .botao-ativo {
        text-align: center;
        align-content: center;
        justify-content: center;
    }
    
</style>

<!-- ESCREVA SEU CÓDIGO AQUI -->
<section class="secao-pesquisa">
    <form action="#" method="get" class="formulario-pesquisa">
        <div class="entrada-pesquisa">
            <img src="../assets/icons/botao-de-pesquisar.svg" alt="Ícone de Pesquisa" class="icone-pesquisa">
            <input type="text" placeholder="Pesquise" name="search"
                onkeydown="if(event.key === 'Enter'){ this.form.submit(); }">
        </div>
    </form>
    <a class="ancora-add-butao" href="/pacotes/novo"><button class="add-butao">+</button></a>
</section>
<!-- Cards das viagens -->
<section class="cards-section">
    <article class="card" style="width: 300px;">

        <div class="img-viagem">
            <img src="/assets/backgrounds/suica-2025.jpg" alt="Foto da Viagem">
        </div>
        
        <br>
        <div class="descricao">
            <h2>Viagem</h2>
            <p>Descrição</p>
        </div>

        <div class="dados-viagem">
            <h3>Data de ida:</h3>
            <h3>Data de volta:</h3>
            <br>
        </div>

        <div class="botoes"> <!--DIV para botões-->
            <button class="botao-editar">
                <img src="/assets/icons/botao-editar.svg" alt="Editar" class="icone-botao">
                Editar
            </button>
            <button class="botao-deletar">
                <img src="/assets/icons/botao-deletar.svg" alt="Deletar" class="icone-botao">
                Deletar
            </button>
            <button class="botao-ativo">
                <img src="/assets/icons/botao-ativo.svg" alt="Ativo" class="icone-botao">
                Habilitar
            </button>

        </div>
    </article>
    <!-- Repita a estrutura do card para outros clientes -->
</section>
`)