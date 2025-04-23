@param com.example.agencia_viagens.dto.Page page = null

<div class="caixa-cabecalho">
    <h1>${page == null ? "" : page.title()}</h1> <!-- Altere aqui para a sua respectiva tela -->
    <div class="info-usuario">
        <img src="/assets/icons/icone-avatar.svg" class="avatar" alt="Avatar">
        <div class="detalhes-usuario">
            <p>Lorem Ipsum Dolo</p>
            <small>Admin</small>
        </div>
    </div>
</div>