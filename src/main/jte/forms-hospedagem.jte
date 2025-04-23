@template.layout.main(content = @`

<link rel="stylesheet" href="/css/cadastro-hospedagem.css">

    <section class="formulario-conteiner">
        <!-- Mensagens de feedback -->

        <!-- Campos do Formulário -->
        <form action="/hospedagens/cadastro" method="post">
            <div class="campos-formulario">
                <fieldset>
                    <legend>Dados da Hospedagem</legend>
                    <div class="caixa lado-a-lado">
                        <div class="caixa-input">
                            <input type="text" name="nome" placeholder="Nome" class="input-sem-ponta" required>
                        </div>
                        <div class="caixa-input">
                            <input type="email" name="email" placeholder="E-mail" class="input-sem-ponta" required>
                        </div>
                    </div>
                    <div class="caixa lado-a-lado">
                        <div class="caixa-input">
                            <div class="lado-mesclado">
                                <input type="tel" name="telefone1" placeholder="Telefone" class="telefone" required>
                                <select name="tipoTelefone1" class="telefone-selecao" required>
                                    <option value="" disabled selected>Selecione...</option>
                                    <option value="Phone">Phone</option>
                                    <option value="Telegram">Telegram</option>
                                    <option value="WhatsApp">WhatsApp</option>
                                </select>
                            </div>
                        </div>
                        <div class="caixa-input">
                            <div class="lado-mesclado">
                                <input type="tel" name="telefone2" placeholder="Telefone" class="telefone">
                                <select name="tipoTelefone2" class="telefone-selecao">
                                    <option value="" disabled selected>Selecione...</option>
                                    <option value="Phone">Phone</option>
                                    <option value="Telegram">Telegram</option>
                                    <option value="WhatsApp">WhatsApp</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </fieldset>

                <fieldset>
                    <legend>Endereço da Hospedagem</legend>
                    <div class="caixa lado-a-lado">
                        <div class="caixa-input">
                            <input type="text" name="pais" placeholder="País" class="input-sem-ponta" required>
                        </div>
                        <div class="caixa-input">
                            <input type="text" name="estado" placeholder="Estado" class="input-sem-ponta" required>
                        </div>
                        <div class="caixa-input">
                            <input type="text" name="cidade" placeholder="Cidade" class="input-sem-ponta" required>
                        </div>
                        <div class="caixa-input">
                            <input type="text" name="bairro" placeholder="Bairro" class="input-sem-ponta" required>
                        </div>
                    </div>
                    <div class="caixa lado-a-lado">
                        <div class="caixa-input">
                            <input type="text" name="logradouro" placeholder="Logradouro" class="input-sem-ponta" required>
                        </div>
                        <div class="caixa-input">
                            <input type="text" name="numero" placeholder="Número" class="input-sem-ponta" required>
                        </div>
                        <div class="caixa-input">
                            <input type="text" name="complemento" placeholder="Complemento" class="input-sem-ponta">
                        </div>
                    </div>
                </fieldset>
            </div>

            <!-- Botão de Salvar -->
            <button type="submit" class="btn-salvar">
                <img src="../assets/icons/icone-botao-de-salvar.svg" class="icone">Salvar
            </button>
        </form>
    </section>
`)