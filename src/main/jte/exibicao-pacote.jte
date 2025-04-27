@import com.example.agencia_viagens.dto.Page
@import com.example.agencia_viagens.dto.PacoteDTO
@import java.util.List

@param List<PacoteDTO> pacotes

@template.layout.main(
    page = new Page("Gerenciamento de Pacote"),
    content = @`
    
    <link rel="stylesheet" href="/css/exibicao-cadastro-cliente.css">
    <link rel="stylesheet" href="/css/exibicao-pacote.css">

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

    <!-- NÃO APAGAR: ÁREA DE PESQUISA
    <form action="#" method="get" class="formulario-pesquisa">
        <div class="entrada-pesquisa">
            <img src="/assets/icons/botao-de-pesquisar.svg" alt="Ícone de Pesquisa" class="icone-pesquisa">
            <input type="text" id="campoTexto" placeholder="Pesquise" name="search" onkeydown="if(event.key === 'Enter'){ this.form.submit(); }" value="${pacotes.isEmpty() ? "" : pacotes.get(0).getTitulo()}">
        </div>
    </form>
    -->
    
    <a class="ancora-add-butao" href="/pacotes/novo"><button class="add-butao">+</button></a>
</section>
<!-- Cards das viagens -->
<section class="cards-section">
    @if(pacotes!=null)

        @for(PacoteDTO dto:pacotes)

            <article class="card" style="width: 300px;">

                <div class="img-viagem">
                    <img src="/assets/backgrounds/suica-2025.jpg" alt="Foto da Viagem">
                </div>
                
                <br>
                <div class="descricao">
                    <h2>${dto.getTitulo()}</h2>
                    <p>${dto.getDescricao()}</p>
                </div>

                <div class="dados-viagem">
                    <h3>Data de ida: ${dto.getDataPartida()}</h3>
                    <h3>Data de volta: ${dto.getDataChegada()}</h3>
                    <br>
                </div>

                <div class="botoes"> <!--DIV para botões-->
                    <a class="ancora-add-butao" href="/pacotes/edit/${dto.getIdPacote()}">
                        <button class="botao-editar">
                            <img src="/assets/icons/botao-editar.svg" alt="Editar" class="icone-botao">
                            Editar
                        </button>
                    </a>
                    <a class="ancora-add-butao" href="/pacotes/remover/${dto.getIdPacote()}">
                        <button class="botao-deletar">
                            <img src="/assets/icons/botao-deletar.svg" alt="Deletar" class="icone-botao">
                            Deletar
                        </button>
                    </a>
                    <a class="ancora-add-butao" href="">
                        <button class="botao-ativo">
                            <img src="/assets/icons/botao-ativo.svg" alt="Ativo" class="icone-botao">
                            Habilitar
                        </button>
                    </a>

                </div>
            </article>
            <!-- Repita a estrutura do card para outros clientes -->

        @endfor

    @endif
</section>

    <!-- NÃO APAGAR: ISSO É PARA PESQUISAR PACOTE 
    <script>
        // Captura o campo de texto pelo ID
        const campoTexto = document.getElementById("campoTexto");

        // Adiciona um ouvinte de evento para o evento 'keydown'
        campoTexto.addEventListener("keydown", function(event) {
            // Captura a tecla pressionada
            console.log("Tecla pressionada: " + event.key);
        });
    </script>
    -->
`)