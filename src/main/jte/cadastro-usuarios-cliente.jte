@import com.example.agencia_viagens.dto.Page
@import com.example.agencia_viagens.dto.ClienteDTO

@param ClienteDTO cli = new ClienteDTO()

@template.layout.main(
page = new Page("Cadastro de Cliente"),
content = @`
    

    <!-- Formulário -->
    <section class="formulario-conteiner">
        !{var formAction = cli.getId() != null ? "/clientes/edit/" + cli.getId() : "/clientes/novo";}
        <form action="${formAction}" method="post" class="formulario">
            <fieldset>
                <legend>Dados Pessoais</legend>
                <input type="hidden" name="id" value="${cli.getId()}">
                <div class="grid">
                    <div class="campo">
                        <label for="nome">Nome *</label>
                        <input type="text" id="nome" name="nome" placeholder="Nome" value="${cli.getNome()}" required>
                    </div>
                    <div class="campo">
                        <label for="email">E-mail *</label>
                        <input type="email" id="email" name="email" placeholder="E-mail" value="${cli.getEmail()}" required>
                    </div>
                </div>
                <div class="grid">
                    <div class="campo">
                        <label for="telefone1">Telefone Principal *</label>
                        <input type="tel" id="telefone1" name="telefone1" placeholder="Telefone" value="${cli.getTelefone1()}" required>
                    </div>
                    <div class="campo">
                        <label for="tipoTelefone1">Tipo do Telefone Principal</label>
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
                        <input type="tel" id="telefone2" name="telefone2" placeholder="Telefone" value="${cli.getTelefone2()}">
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
                <legend>Endereço</legend>
                <div class="grid">
                    <div class="campo">
                        <label for="cep">CEP</label>
                        <input type="text" id="cep" name="cep" placeholder="CEP" value="${cli.getCep()}">
                    </div>
                    <div class="campo">
                        <label for="estado">Estado</label>
                        <input type="text" id="estado" name="estado" placeholder="Estado" value="${cli.getEstado()}">
                    </div>
                </div>
                <div class="grid">
                    <div class="campo">
                        <label for="cidade">Cidade</label>
                        <input type="text" id="cidade" name="cidade" placeholder="Cidade" value="${cli.getCidade()}">
                    </div>
                    <div class="campo">
                        <label for="bairro">Bairro</label>
                        <input type="text" id="bairro" name="bairro" placeholder="Bairro" value="${cli.getBairro()}">
                    </div>
                </div>
                <div class="grid">
                    <div class="campo">
                        <label for="logradouro">Logradouro</label>
                        <input type="text" id="logradouro" name="logradouro" placeholder="Logradouro" value="${cli.getLogradouro()}">
                    </div>
                    <div class="campo">
                        <label for="numero">Número</label>
                        <input type="text" id="numero" name="numero" placeholder="Número" value="${cli.getNumero()}">
                    </div>
                </div>
            </fieldset>

            <button type="submit" class="btn-salvar"><i class='bx bxs-save'></i> Salvar</button>
        </form>
    </section>
`)