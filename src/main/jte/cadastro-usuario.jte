@template.layout.main(content = @`
<!--<style>
            .caixa-conteudo {
                display: flex;
                width: 80%;
                /*flex-wrap: wrap;*/
                gap: 2em;
            }

            .lado-a-lado {
                flex-grow: 1;
            }

            .upload-de-foto {
                margin: 0;
                height: auto;
                flex-basis: 300px;
                justify-content: center;
            }

            .campos-formulario {
                margin: 0;
            }

            @media (max-width: 540px) {
                .caixa-cabecalho {
                    justify-content: flex-end;
                    gap: 5%;
                }

                .caixa-cabecalho h1 {
                    font-size: 1.8rem;
                }

                .caixa-conteudo {
                    margin-top: 20%;
                    display: grid;
                }

                .menu-hamburger {
                    display: flex;
                    width: 3.5rem;
                    height: 3.5rem;
                }

                .upload-de-foto {
                    width: auto;
                    height: 250px;
                }
            }
        </style>
        <script>

            fetch('http://127.0.0.1:5501')   // Realiza a requisição
            .then(produtos => produtos.json())      // Converte o valor recebido em JSON
            .then(retorno => console.log(retorno))  // Exibindo os produtos
  
        </script>
    </head>-->

<section class="formulario-container">
    <!-- Área para Foto Expandida -->
    <div class="caixa-conteudo">
        <div class="upload-de-foto lado-a-lado">
            <span>+</span>
        </div>

        <form action="" method="post" id="usuario-formulario" class="campos-formulario lado-a-lado">

            <fieldset>
                <legend>Dados Pessoais</legend>

                <div class="caixa lado-a-lado">
                    <div class="caixa-input"><input type="text" placeholder="Nome *" id="nome" class="input-sem-ponta"
                            required></div>
                    <div class="caixa-input"><input type="email" placeholder="E-mail *" id="email"
                            class="input-sem-ponta" required></div>
                </div>

                <div class="caixa lado-a-lado">
                    <div class="caixa-input">
                        <div class="lado-mesclado">
                            <input type="tel" placeholder="Telefone *" id="telefone1" class="telefone" required>
                            <select name="tipo_contato1" id="telefone-selecao1" class="telefone-selecao" required>
                                <option value="" disabled selected>Selecione...</option>
                                <option value="telefone">Phone</option>
                                <option value="telegram">Telegram</option>
                                <option value="whatsapp">WhatsApp</option>
                            </select>
                        </div>
                    </div>

                    <div class="caixa-input">
                        <div class="lado-mesclado">
                            <input type="tel" placeholder="Telefone" id="telefone2" class="telefone">
                            <select name="tipo_contato2" id="telefone-selecao2" class="telefone-selecao">
                                <option value="" disabled selected>Selecione...</option>
                                <option value="telefone">Phone</option>
                                <option value="telegram">Telegram</option>
                                <option value="whatsapp">WhatsApp</option>
                            </select>
                        </div>
                    </div>
                </div>

            </fieldset>

            <button type="submit" class="btn-salvar">
                <img src="../assets/icons/icone-botao-de-salvar.svg" class="icone">Salvar
            </button>
        </form>
    </div>
</section>
</main>
</div>
<!-- Script para ativar/desativar o menu -->
<script>
    document.getElementById("alterar-menu").addEventListener("click", function () {
        document.getElementById("barra-lateral").classList.toggle("active");
    });
</script>

<script src="../js/form/cadastro-usuario.js"></script>
`)