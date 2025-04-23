@import com.example.agencia_viagens.dto.Page

@template.layout.main(
    page = new Page("Cadastro de Cliente"),
    content = @`

    <link rel="stylesheet" href="/css/cadastro-usuarios-cliente.css">

            <!-- Formulário -->
            <section class="formulario-conteiner">
                <!-- Área para Foto Expandida -->
                <div class="envio-de-foto">
                    <input type="file" id="file-upload" class="input-file">
                    <label for="file-upload" class="file-label">
                        <span>+</span>
                        <p>Clique aqui para adicionar uma Foto</p>
                    </label>
                </div>

                <!-- Campos do Formulário -->
                <form action="/clientes/novo" method="post">

                    <div class="campos-formulario">
                        <fieldset>
                            <legend>Dados Pessoais</legend>
                            <div class="caixa lado-a-lado">
                                <div class="caixa-input"><input type="text" placeholder="Nome" class="input-sem-ponta"
                                        required></div>
                                <div class="caixa-input"><input type="email" placeholder="E-mail" class="input-sem-ponta"
                                        required></div>
                            </div>

                            <div class="caixa lado-a-lado">
                                <div class="caixa-input">
                                    <div class="lado-mesclado">
                                        <input type="tel" placeholder="Telefone" class="telefone" required>
                                        <select name="" id="" class="telefone-selecao" required>
                                            <option value="" disabled selected>Selecione...</option>
                                            <option value="">Phone</option>
                                            <option value="">Telegram</option>
                                            <option value="">WhatsApp</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="caixa-input">
                                    <div class="lado-mesclado">
                                        <input type="tel" placeholder="Telefone" class="telefone">
                                        <select name="" id="" class="telefone-selecao">
                                            <option value="" disabled selected>Selecione...</option>
                                            <option value="">Phone</option>
                                            <option value="">Telegram</option>
                                            <option value="">WhatsApp</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </fieldset>

                        <fieldset>
                            <legend>Endereço</legend>
                            <div class="caixa lado-a-lado">
                                <div class="caixa-input"><input type="text" placeholder="CEP" class="input-sem-ponta"></div>
                                <div class="caixa-input"><input type="text" placeholder="Estado" class="input-sem-ponta">
                                </div>
                                <div class="caixa-input"><input type="text" placeholder="Cidade" class="input-sem-ponta">
                                </div>
                            </div>
                            <div class="caixa lado-a-lado">
                                <div class="caixa-input"><input type="text" placeholder="Bairro" class="input-sem-ponta">
                                </div>
                                <div class="caixa-input"><input type="text" placeholder="Logradouro"
                                        class="input-sem-ponta"></div>
                                <div class="caixa-input"><input type="text" placeholder="Número" class="input-sem-ponta">
                                </div>
                            </div>
                            <div class="caixa">
                                <div class="caixa-input"><input type="text" placeholder="Complemento"
                                        class="input-sem-ponta"></div>
                            </div>
                        </fieldset>
                    </div>

                    <!-- Botão de Salvar -->
                    <button class="btn-salvar">
                        <img src="/assets/icons/icone-botao-de-salvar.svg"class="icone">Salvar
                    </button>
                </form>
            </section>
        </main>
    </div>


    </main>
    </div>

    <!-- Script para ativar/desativar o menu -->
    <script>
        document.getElementById("alterar-menu").addEventListener("click", function () {
            document.getElementById("barra-lateral").classList.toggle("active");
        });
    </script>
`) 