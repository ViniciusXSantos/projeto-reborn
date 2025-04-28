@import com.example.agencia_viagens.dto.ClienteDTO
@import com.example.agencia_viagens.dto.Page
@import java.util.List

@param List<ClienteDTO> clientes

@template.layout.main(
page = new Page("Gerenciamento de Cliente"),
content = @`
   

    <div class="formulario-container">
        <!-- Barra de Pesquisa e Botão Adicionar -->
        <section class="secao-pesquisa">
            <a href="/clientes/novo" class="btn-cadastro">
                <i class='bx bx-plus'></i>
                <span class="texto">Cadastrar Novo</span>
            </a>
        </section>

        <!-- Cards dos Clientes -->
        <section class="cartoes-usuario">
            @if(clientes != null)
                @for(ClienteDTO dto : clientes)
                    <article class="cartao">
                        <div class="foto">
                            <i class='bx bxs-user-circle'></i>
                        </div>
                        <div class="cartao-corpo">
                            <div class="descricao">
                                <h2>Nome: ${dto.getNome()}</h2>
                                <p>Email: ${dto.getEmail()}</p>
                                <p>Telefone 1: ${dto.getTelefone1()} (${dto.getTipoTelefone1()})</p>
                                <p>Telefone 2: ${dto.getTelefone2()} (${dto.getTipoTelefone2()})</p>
                            </div>
                            <div class="botoes">
                                <a href="/clientes/edit/${dto.getId()}" class="botao-editar">
                                    <i class='bx bxs-edit-alt' ></i>
                                    Editar
                                </a>
                                <a href="/clientes/delete/${dto.getId()}" class="botao-deletar"> <!-- onclick="confirmarDelecao(${dto.getId()})" -->
                                    <i class='bx bx-x'></i>
                                    Deletar
                                </a>
                            </div>
                        </div>
                    </article>
                @endfor
            @endif
        </section>
    </div>
`)