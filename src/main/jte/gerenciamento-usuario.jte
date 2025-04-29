@import com.example.agencia_viagens.dto.UsuarioDTO
@import com.example.agencia_viagens.dto.Page
@import java.util.List

@param List<UsuarioDTO> usuarios

@template.layout.main(
    page = new Page("Gerenciamento de Funcionário"),
    content = @`
    

    <div class="formulario-container">
        <!-- Barra de Pesquisa e Botão Adicionar -->
        <section class="secao-pesquisa">
            <a href="/user/cadastro" class="btn-cadastro">
                <i class='bx bx-plus'></i>
                <span class="texto">Cadastrar Novo</span>
            </a>
        </section>

        <!-- Cards dos Usuários -->
        <section class="cartoes-usuario">
            @if(usuarios != null)
                @for(UsuarioDTO dto : usuarios)
                    <article class="cartao">
                        <div class="foto">
                            <i class='bx bxs-user-badge'></i>
                        </div>
                        <div class="cartao-corpo">
                            <div class="descricao">
                                <h2>${dto.getNome()}</h2>
                                <p>${dto.getEmail()}</p>
                            </div>
                            <div class="botoes">
                                <a href="/user/edit/${dto.getId()}" class="btn-editar">
                                    <i class='bx bxs-edit-alt'></i> Editar
                                </a>
                                <a href="/user/remover/${dto.getId()}" class="btn-deletar">
                                    <i class='bx bxs-trash'></i> Deletar
                                </a>
                            </div>
                        </div>
                    </article>
                @endfor
            @endif
        </section>
    </div>
`)