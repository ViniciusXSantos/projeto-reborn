@template.layout.main(content = @`
    
    <div class="formulario-container">
        <section class="secao-pesquisa">
            <form action="#" method="get" class="formulario-pesquisa">
                <div class="entrada-pesquisa">
                    <img src="../assets/icons/botao-de-pesquisar.svg" alt="Ícone de Pesquisa" class="icone-pesquisa">
                    <input type="text" placeholder="Pesquise" name="search" onkeydown="if(event.key === 'Enter'){ this.form.submit(); }">
                </div>
            </form>
            <button class="add-butao">+</button>
        </section>

        <section class="cartoes-usuario">
            <div class="cartao">
                <div class="foto"><img src="../assets/backgrounds/perfil-equipe.png" alt="Foto do usuário"></div>

                <div class="cartao-corpo">
                    <div class="descricao">
                        <h2>Aline</h2>
                        <p>Admistradora</p>
                    </div>

                    <button class="edita">Editar</button>
                    <button class="deleta">Deletar</button>
                    <button class="ativo">Ativar</button>
                </div>
            </div>
            <div class="cartao">
                <div class="foto"><img src="../assets/backgrounds/perfil-equipe.png" alt="Foto do usuário"></div>

                <div class="cartao-corpo">
                    <div class="descricao">
                        <h2>Bia</h2>
                        <p>Usuário</p>
                    </div>

                    <button class="edita">Editar</button>
                    <button class="deleta">Deletar</button>
                    <button class="ativo">Ativar</button>
                </div>
            </div>
            <div class="cartao">
                <div class="foto"><img src="../assets/backgrounds/perfil-equipe.png" alt="Foto do usuário"></div>

                <div class="cartao-corpo">
                    <div class="descricao">
                        <h2>Carlos</h2>
                        <p>Usuário</p>
                    </div>

                    <button class="edita">Editar</button>
                    <button class="deleta">Deletar</button>
                    <button class="ativo">Ativar</button>
                </div>
            </div>
            <div class="cartao">
                <div class="foto"><img src="../assets/backgrounds/perfil-equipe.png" alt="Foto do usuário"></div>

                <div class="cartao-corpo">
                    <div class="descricao">
                        <h2>Dene</h2>
                        <p>Usuário</p>
                    </div>

                    <button class="edita">Editar</button>
                    <button class="deleta">Deletar</button>
                    <button class="ativo">Ativar</button>
                </div>
            </div>
        </section>
    </div>

`)   