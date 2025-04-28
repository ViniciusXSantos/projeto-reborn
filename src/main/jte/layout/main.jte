@param gg.jte.Content content
@param com.example.agencia_viagens.dto.Page page = null

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Outfit:wght@400;500;600&display=swap">
    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/styles.css">
    <link rel="stylesheet" href="/css/cadastro.css">
    <!--<link rel="stylesheet" href="/css/cadastro-hospedagem.css">
    <link rel="stylesheet" href="/css/cadastro-usuarios-cliente.css">
    <link rel="stylesheet" href="/css/cadastro-pacote.css">
    <link rel="stylesheet" href="/css/gerenciamento-pessoa.css">-->
    <link rel="stylesheet" href="/css/pesquisa.css">
    <!--        <link rel="stylesheet" href="/css/cadastro-hospedagem.css"> 
    <link rel="stylesheet" href="/css/exibicao-cadastro-cliente.css">
    <link rel="stylesheet" href="/css/exibicao-hospedagem.css">
    <link rel="stylesheet" href="/css/exibicao-pacote.css">-->
    <script src="/js/telefone-formatacao.js" defer ></script>
    <script src="/js/alternar-status.js" defer></script>
    <title>${page == null ? "INNOVA TURISMO" : page.title()}</title>
    <style>
        @media (max-width: 540px) {
            .menu-hamburger {
                display: flex;
                width: 3.5rem;
                height: 3.5rem;
            }
        }
    </style>
</head>

<body>

    <div class="fundo-conteudo">
        <!-- Menu Hambúrguer -->
        <div class="menu-hamburger" id="alterar-menu">
            <svg xmlns="http://www.w3.org/2000/svg" width="96" height="96" viewBox="0 0 24 24">
                <path fill="currentColor"
                    d="M12 2A10 10 0 0 0 2 12a10 10 0 0 0 10 10a10 10 0 0 0 10-10A10 10 0 0 0 12 2M6 7h12v2H6zm0 4h12v2H6zm0 4h12v2H6z" />
            </svg>
        </div>

        <!-- Barra Lateral -->
        <aside class="barra-lateral" id="barra-lateral">
            @template.layout.aside()
        </aside>

        <!-- Conteúdo Principal -->
        <main class="conteudo">
            <!-- Cabeçalho -->
            <header>
                @template.layout.header(page)
            </header>

            <!-- ESCREVA SEU CÓDIGO AQUI -->
            ${content}
        </main>
    </div>
3
</body>

</html>