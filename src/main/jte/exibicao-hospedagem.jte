@import com.example.agencia_viagens.dto.HospedagemDTO
@import com.example.agencia_viagens.dto.Page
@import java.util.List

@param List<HospedagemDTO> hospedagens
@template.layout.main(
page = new Page("Gerenciamento de Hospedagem"),
content = @`

    <section class="secao-pesquisa">
        <a class="add-butao ancora-add-butao" href="/hospedagens/cadastro"> + </a>
    </section>

    @if(hospedagens!=null)
        @for(HospedagemDTO dto:hospedagens)
    <div class="bloco-exibicao">
        <div class="upload-foto">
            <p>Por assets aqui</p>
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
            <a href="/hospedagens/editar/${dto.getId()}" class="btn-editar">Editar</a>
            <a href="/hospedagens/deletar/${dto.getId()}" class="btn-deletar">Deletar</a>
        </div>
    </div>
        @endfor

        @endif

    </main>
    </div>

    <script>
        document.querySelectorAll('.btn-deletar').forEach(btn => {
            btn.addEventListener('click', (e) => {
                if (!confirm('Tem certeza que deseja deletar esta hospedagem?')) {
                    e.preventDefault(); // Cancela se o usuário clicar em "Não"
                }
            });
        });
    </script>
`)