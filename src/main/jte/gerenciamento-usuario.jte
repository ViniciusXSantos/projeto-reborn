@import com.example.agencia_viagens.dto.UsuarioDTO
@import java.util.List

@param List<UsuarioDTO> usuarios

@template.layout.main(content = @`
    
    <div class="formulario-container">
        <section class="secao-pesquisa">
            <form action="#" method="get" class="formulario-pesquisa">
                <div class="entrada-pesquisa">
                    <img src="../assets/icons/botao-de-pesquisar.svg" alt="Ícone de Pesquisa" class="icone-pesquisa">
                    <input type="text" placeholder="Pesquise" name="search" onkeydown="if(event.key === 'Enter'){ this.form.submit(); }">
                </div>
            </form>
            <a class="ancora-add-butao" href="/user/cadastro"><button class="add-butao">+</button></a>
        </section>

        <section class="cartoes-usuario">
        @if(usuarios!=null)

            @for(UsuarioDTO dto:usuarios)

                <div class="cartao">
                    <div class="foto"><img src="../assets/backgrounds/perfil-equipe.png" alt="Foto do usuário"></div>

                    <div class="cartao-corpo">
                        <div class="descricao">
                            <h2>${dto.getNome()}</h2>
                            <p>${dto.getEmail()}</p>
                        </div>

                        <a href="/user/edit/${dto.getId()}"><button class="edita">Editar</button></a>
                        <a href="/user/remover/${dto.getId()}"> <button class="deleta">Deletar</button></a>
                    </div>
                </div>

            @endfor

        @endif


        </section>
    </div>

`)   