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
    <link rel="stylesheet" href="/css/exibicao-hospedagem.css">
    <link rel="stylesheet" href="/css/cadastro-usuarios-cliente.css">
    <link rel="stylesheet" href="/css/cadastro-pacote.css">
    <link rel="stylesheet" href="/css/gerenciamento-pessoa.css">
    <link rel="stylesheet" href="/css/pesquisa.css">
    <script src="/js/telefone-formatacao.js" defer></script>
    <script src="/js/alternar-status.js" defer></script>
    <script defer>
        document.addEventListener("DOMContentLoaded", function () {
            const menuHamburger = document.getElementById("alterar-menu");
            const barraLateral = document.getElementById("barra-lateral");

            menuHamburger.addEventListener("click", function () {
                barraLateral.classList.toggle("active");
                if (barraLateral.classList.contains("active")) {
                    menuHamburger.classList.add("menu-active");
                } else {
                    menuHamburger.classList.remove("menu-active");
                }
            });

            // Opcional: Fechar a barra lateral ao clicar fora dela
            document.addEventListener("click", function (event) {
                if (!barraLateral.contains(event.target) && !menuHamburger.contains(event.target)) {
                    barraLateral.classList.remove("active");
                }
            });
        });
    </script>
    <title>${page == null ? "INNOVA TURISMO" : page.title()}</title>
</head>

<body>
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

        <header>
                @template.layout.header(page)
        </header>

        <!-- Conteúdo Principal -->
        <div class="fundo-conteudo">
        <main class="conteudo">
            <!-- Cabeçalho -->
            

            <!-- ESCREVA SEU CÓDIGO AQUI -->
            ${content}
        </main>
    </div>
</body>

</html>