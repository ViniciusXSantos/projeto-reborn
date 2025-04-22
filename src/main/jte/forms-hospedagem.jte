@template.layout.main(content = @`

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
        <form action="" method="post" class="campos-formulario">
            <fieldset>
                <legend>Dados da Hospedagem</legend>
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
                <legend>Endereço da Hospedagem</legend>
                <div class="caixa lado-a-lado">
                    <div class="caixa-input"><input type="text" placeholder="País" class="input-sem-ponta"></div>
                    <div class="caixa-input"><input type="text" placeholder="Estado" class="input-sem-ponta">
                    </div>
                    <div class="caixa-input"><input type="text" placeholder="Cidade" class="input-sem-ponta"></div>
                    <div class="caixa-input"><input type="text" placeholder="Bairro" class="input-sem-ponta">
                    </div>
                </div>
                <div class="caixa lado-a-lado">
                    <div class="caixa-input"><input type="text" placeholder="Logradouro" class="input-sem-ponta">
                    </div>
                    <div class="caixa-input"><input type="text" placeholder="Número"
                                                    class="input-sem-ponta"></div>
                    <div class="caixa-input"><input type="text" placeholder="Complemento" class="input-sem-ponta">
                    </div>
                </div>
            </fieldset>
        </form>

        <!-- Botão de Salvar -->
        <button class="btn-salvar"><img src="../assets/icons/icone-botao-de-salvar.svg"
                                        class="icone">Salvar</button>
    </section>
`)   