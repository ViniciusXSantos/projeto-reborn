@import com.example.agencia_viagens.dto.Page

@template.layout.main(
    page = new Page("Gerenciamento de Pacote"),
    content = @`
<!-- ESCREVA SEU CÓDIGO AQUI -->
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
<!-- Cards das viagens -->
<section class="cards-section">
    <article class="card">
        <img src="../assets/backgrounds/.png" alt="Foto da Viagem">
        <h2>Viagem</h2>
        <p>Descrição</p>

        <div class="img-viagem">

        </div>


        <div class="dados-viagem">
            <h2>Data de partida</h2>
            <h2>Data de chegada</h2>
        </div>


        <div class="botoes"> <!--DIV para botões-->
            <button class="botao-editar">
                <img src="../assets/icons/botao-editar.svg" alt="Editar" class="icone-botao">
                Editar
            </button>
            <button class="botao-deletar">
                <img src="../assets/icons/botao-deletar.svg" alt="Deletar" class="icone-botao">
                Deletar
            </button>
            <button class="botao-ativo">
                <img src="../assets/icons/botao-ativo.svg" alt="Ativo" class="icone-botao">
                Habilitar
            </button>

        </div>
    </article>
    <!-- Repita a estrutura do card para outros clientes -->
</section>
`)