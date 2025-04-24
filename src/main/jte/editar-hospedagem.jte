@import com.example.agencia_viagens.dto.Page
@import com.example.agencia_viagens.model.Hospedagem
@param Hospedagem hospedagem

@template.layout.main(
page = new Page("Editar Hospedagem"),
content = @`

    <link rel="stylesheet" href="/css/editar-hospedagem.css">

    <form action="/hospedagens/editar/${hospedagem.getId()}" method="post">
        <!-- Campos existentes -->
        <div class="campo-form">
            <label>Nome:</label>
            <input type="text" name="nome" value="${hospedagem.getNome()}" required>
        </div>

        <div class="campo-form">
            <label>Telefone 1:</label>
            <input type="text" name="telefone1" value="${hospedagem.getTelefone1()}">
        </div>

        <!-- Novos campos editáveis -->
        <div class="campo-form">
            <label>Telefone 2 (opcional):</label>
            <input type="text" name="telefone2" value="${hospedagem.getTelefone2()}">
        </div>

        <div class="campo-form">
            <label>Logradouro:</label>
            <input type="text" name="logradouro" value="${hospedagem.getLogradouro()}">
        </div>

        <div class="campo-form">
            <label>Número:</label>
            <input type="text" name="numero" value="${hospedagem.getNumero()}">
        </div>

        <div class="campo-form">
            <label>Cidade:</label>
            <input type="text" name="cidade" value="${hospedagem.getCidade()}">
        </div>

        <button type="submit" class="btn-salvar">Salvar Alterações</button>
    </form>
`)