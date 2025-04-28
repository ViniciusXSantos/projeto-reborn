@import com.example.agencia_viagens.dto.Page
@import com.example.agencia_viagens.model.Hospedagem
@param Hospedagem hospedagem

@template.layout.main(
page = new Page("Editar Hospedagem"),
content = @`



    <section class="formulario-conteiner">
        <form action="/hospedagens/editar/${hospedagem.getId()}" method="post" class="formulario">
            <fieldset>
                <legend>Dados da Hospedagem</legend>
                <div class="grid">
                    <div class="campo">
                        <label for="nome">Nome *</label>
                        <input type="text" id="nome" name="nome" value="${hospedagem.getNome()}" required>
                    </div>
                    <div class="campo">
                        <label for="telefone1">Telefone 1 *</label>
                        <input type="text" id="telefone1" name="telefone1" value="${hospedagem.getTelefone1()}" required>
                    </div>
                </div>
                <div class="grid">
                    <div class="campo">
                        <label for="telefone2">Telefone 2 (opcional)</label>
                        <input type="text" id="telefone2" name="telefone2" value="${hospedagem.getTelefone2()}">
                    </div>
                </div>
            </fieldset>

            <fieldset>
                <legend>Endereço da Hospedagem</legend>
                <div class="grid">
                    <div class="campo">
                        <label for="logradouro">Logradouro *</label>
                        <input type="text" id="logradouro" name="logradouro" value="${hospedagem.getLogradouro()}" required>
                    </div>
                    <div class="campo">
                        <label for="numero">Número *</label>
                        <input type="text" id="numero" name="numero" value="${hospedagem.getNumero()}" required>
                    </div>
                </div>
                <div class="grid">
                    <div class="campo">
                        <label for="cidade">Cidade *</label>
                        <input type="text" id="cidade" name="cidade" value="${hospedagem.getCidade()}" required>
                    </div>
                </div>
            </fieldset>

            <button type="submit" class="btn-salvar"><i class='bx bxs-save'></i> Salvar Alterações</button>
        </form>
    </section>
`)