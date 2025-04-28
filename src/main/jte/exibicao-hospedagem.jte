@import com.example.agencia_viagens.dto.HospedagemDTO
@import com.example.agencia_viagens.dto.Page
@import java.util.List

@param List<HospedagemDTO> hospedagens

@template.layout.main(
page = new Page("Gerenciamento de Hospedagem"),
content = @`
    

    <section class="secao-pesquisa">
        <a href="/hospedagens/cadastro" class="btn-cadastro">
            <i class='bx bx-plus'></i>
            <span class="texto">Cadastrar Novo</span>
        </a>
    </section>

    <section class="cartoes-hospedagem">
        @if(hospedagens != null)
            @for(HospedagemDTO dto : hospedagens)
                <article class="cartao">
                    <div class="foto">
                        <i class='bx bxs-buildings'></i>
                    </div>
                    <div class="cartao-corpo">
                        <div class="descricao">
                            <h2>${dto.getNome()}</h2>
                            <p>Telefone 1: ${dto.getTelefone1()}</p>
                            <p>Telefone 2: ${dto.getTelefone2()}</p>
                            <p>Endereço: ${dto.getLogradouro()}, ${dto.getNumero()} - ${dto.getCidade()}</p>
                        </div>
                        <div class="botoes">
                            <a href="/hospedagens/editar/${dto.getId()}" class="btn-editar">
                                <i class='bx bxs-edit-alt'></i> Editar
                            </a>
                            <a href="/hospedagens/deletar/${dto.getId()}" class="btn-deletar">
                                <i class='bx bxs-trash'></i> Deletar
                            </a>
                        </div>
                    </div>
                </article>
            @endfor
        @endif
    </section>

`)