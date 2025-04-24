@import com.example.agencia_viagens.dto.HospedagemDTO
@import com.example.agencia_viagens.dto.Page
@import java.util.List

@param List<HospedagemDTO> hospedagens
@template.layout.main(
page = new Page("Gerenciamento de Hospedagem"),
content = @`

    <link rel="stylesheet" href="/css/exibicao-hospedagem.css">

    <section class="secao-pesquisa">
        <form action="#" method="get" class="formulario-pesquisa">
            <div class="entrada-pesquisa">
                <img src="/assets/icons/botao-de-pesquisar.svg" alt="Ícone de Pesquisa" class="icone-pesquisa">
                <input type="text" placeholder="Pesquise" name="search"
                       onkeydown="if(event.key === 'Enter'){ this.form.submit(); }">
            </div>
        </form>
        <a class="add-butao ancora-add-butao" href="/hospedagens/cadastro"> + </a>
    </section>

    @if(hospedagens!=null)
        @for(HospedagemDTO dto:hospedagens)
    <div class="bloco-exibicao">
        <div class="upload-foto">
            <p>Upload de Foto</p>
        </div>

        <div class="info-hospedagem">
            <h2 class="nome-hospedagem">${dto.getNome()}</h2>
            <p> </p>
            <p class="descricao-hospedagem">${dto.getTelefone1()}</p>
            <p class="descricao-hospedagem">${dto.getTelefone2()}</p>
        </div>

        <div class="endereco-hospedagem">
            <p>Endereço: ${dto.getLogradouro()}, ${dto.getNumero()} - ${dto.getCidade()}</p>
        </div>

        <div class="acoes-hospedagem">
            <button class="btn-editar">Editar</button>
            <button class="btn-deletar">Deletar</button>
            <button class="btn-habilitar">Habilitar</button>
        </div>
    </div>
        @endfor

        @endif

    </main>
    </div>

    <!-- Script para ativar/desativar o menu -->
    <script>
        document.getElementById("alterar-menu").addEventListener("click", function () {
            document.getElementById("barra-lateral").classList.toggle("active");
        });
    </script>

`)