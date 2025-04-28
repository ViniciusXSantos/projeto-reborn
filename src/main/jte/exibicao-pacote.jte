@import com.example.agencia_viagens.dto.Page
@import com.example.agencia_viagens.dto.PacoteDTO
@import java.util.List

@param List<PacoteDTO> pacotes

@template.layout.main(
    page = new Page("Gerenciamento de Pacote"),
    content = @`

<section class="secao-pesquisa">
    <a href="/pacotes/novo" class="btn-cadastro">
                <i class='bx bx-plus'></i>
                <span class="texto">Cadastrar Novo</span>
            </a>
</section>

<section class="cards-section">
    @if(pacotes != null)
        @for(PacoteDTO dto : pacotes)
            <article class="card">
                <div class="img-viagem">
                    <i class='bx bxs-plane' ></i>
                </div>
                <div class="descricao">
                    <h2>${dto.getTitulo()}</h2>
                    <p>${dto.getDescricao()}</p>
                </div>
                <div class="dados-viagem">
                    <h3>Data de ida: ${dto.getDataPartida()}</h3>
                    <h3>Data de volta: ${dto.getDataChegada()}</h3>
                </div>
                <div class="botoes">
                    <a href="/pacotes/edit/${dto.getIdPacote()}">
                        <button class="botao-editar">
                            
                            <i class='bx bxs-edit-alt' style="color: var(--light);"></i>
                            Editar
                        </button>
                    </a>
                    <a href="/pacotes/remover/${dto.getIdPacote()}">
                        <button class="botao-deletar">
                           
                            <i class='bx bx-x' style="color: var(--light);"></i>
                            Deletar
                        </button>
                    </a>
                    <!--
                    <a href="#">
                        <button class="botao-ativo">
                            <img src="/assets/icons/botao-ativo.svg" alt="Ativo" class="icone-botao">
                            Habilitar
                        </button>
                    </a>
                    -->
                </div>
            </article>
        @endfor
    @endif
</section>
`)