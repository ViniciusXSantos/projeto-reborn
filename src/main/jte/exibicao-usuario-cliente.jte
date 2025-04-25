@import com.example.agencia_viagens.dto.ClienteDTO
@import com.example.agencia_viagens.dto.Page
@import java.util.List

@param List<ClienteDTO> clientes
@template.layout.main(
    page = new Page("Gerenciamento de Cliente"),
    content = @`

    <link rel="stylesheet" href="/css/exibicao-cadastro-cliente.css">
    <link rel="stylesheet" href="/css/gerenciamento-pessoa.css">
    
<style>
    .botao-editar, .botao-deletar {
        text-align: center;
    }
    
</style>

<div class="formulario-container">
<!-- Barra de Pesquisa e Botão Adicionar -->
<section class="secao-pesquisa">
    <a class="ancora-add-butao" href="/clientes/novo"><button class="add-butao">+</button></a>
</section>

    @if(clientes!=null)
    @for(ClienteDTO dto:clientes)
<!-- Cards dos Funcionários -->
<section class="cartoes-usuario">
    <article class="cartao">
        <div class="foto"><img src="/assets/backgrounds/perfil-equipe.png" alt="Foto do Funcionário"></div>
        
        <div class="cartao-corpo">
            <div class="descricao">
                <h2>Nome: ${dto.getNome()}</h2>
                <p>Email: ${dto.getEmail()}</p>
                <p>Telefone 1: ${dto.getTelefone1()} (${dto.getTipoTelefone1()})</p>
                <p>Telefone 1: ${dto.getTelefone2()} (${dto.getTipoTelefone2()})</p>
            </div>
            
            <button class="botao-editar">
                <img src="/assets/icons/botao-editar.svg" alt="Editar" class="icone-botao">
                Editar
            </button>
            <button class="botao-deletar">
                <img src="/assets/icons/botao-deletar.svg" alt="Deletar" class="icone-botao">
                Deletar
            </button>
        </div>
    </article>
    <!-- Repita a estrutura do card para outros clientes -->
</section>

    @endfor

    @endif

</div>
<!-- Script para ativar/desativar o menu -->
<script>
    document.getElementById("alterar-menu").addEventListener("click", function () {
        document.getElementById("barra-lateral").classList.toggle("active");
    });
</script>
`)