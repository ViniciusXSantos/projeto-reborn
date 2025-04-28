@template.layout.main(content = @`



<section class="formulario-conteiner">
    <!-- Mensagens de feedback -->

    <!-- Campos do Formulário -->
    <form action="/hospedagens/cadastro" method="post" class="formulario">
        <fieldset>
            <legend>Dados da Hospedagem</legend>
            <div class="grid">
                <div class="campo">
                    <label for="nome">Nome *</label>
                    <input type="text" id="nome" name="nome" placeholder="Nome" required>
                </div>
                <div class="campo">
                    <label for="email">E-mail *</label>
                    <input type="email" id="email" name="email" placeholder="E-mail" required>
                </div>
            </div>
            <div class="grid">
                <div class="campo">
                    <label for="telefone1">Telefone *</label>
                    <input type="tel" id="telefone1" name="telefone1" placeholder="Telefone" class="telefone" required>
                </div>
                <div class="campo">
                    <label for="tipoTelefone1">Tipo do Telefone *</label>
                    <select id="tipoTelefone1" name="tipoTelefone1" required>
                        <option value="" disabled selected>Selecione...</option>
                        <option value="Phone">Phone</option>
                        <option value="Telegram">Telegram</option>
                        <option value="WhatsApp">WhatsApp</option>
                    </select>
                </div>
            </div>
            <div class="grid">
                <div class="campo">
                    <label for="telefone2">Telefone Alternativo</label>
                    <input type="tel" id="telefone2" name="telefone2" placeholder="Telefone" class="telefone">
                </div>
                <div class="campo">
                    <label for="tipoTelefone2">Tipo do Telefone Alternativo</label>
                    <select id="tipoTelefone2" name="tipoTelefone2">
                        <option value="" disabled selected>Selecione...</option>
                        <option value="Phone">Phone</option>
                        <option value="Telegram">Telegram</option>
                        <option value="WhatsApp">WhatsApp</option>
                    </select>
                </div>
            </div>
        </fieldset>

        <fieldset>
            <legend>Endereço da Hospedagem</legend>
            <div class="grid">
                <div class="campo">
                    <label for="pais">País *</label>
                    <input type="text" id="pais" name="pais" placeholder="País" required>
                </div>
                <div class="campo">
                    <label for="estado">Estado *</label>
                    <input type="text" id="estado" name="estado" placeholder="Estado" required>
                </div>
            </div>
            <div class="grid">
                <div class="campo">
                    <label for="cidade">Cidade *</label>
                    <input type="text" id="cidade" name="cidade" placeholder="Cidade" required>
                </div>
                <div class="campo">
                    <label for="bairro">Bairro *</label>
                    <input type="text" id="bairro" name="bairro" placeholder="Bairro" required>
                </div>
            </div>
            <div class="grid">
                <div class="campo">
                    <label for="logradouro">Logradouro *</label>
                    <input type="text" id="logradouro" name="logradouro" placeholder="Logradouro" required>
                </div>
                <div class="campo">
                    <label for="numero">Número *</label>
                    <input type="text" id="numero" name="numero" placeholder="Número" required>
                </div>
                <div class="campo">
                    <label for="complemento">Complemento</label>
                    <input type="text" id="complemento" name="complemento" placeholder="Complemento">
                </div>
            </div>
        </fieldset>

        <button type="submit" class="btn-salvar"><i class='bx bxs-save'></i> Salvar</button>
    </form>
</section>
`)