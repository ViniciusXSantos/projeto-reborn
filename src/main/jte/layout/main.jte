@param gg.jte.Content content
@param com.example.agencia_viagens.dto.Page page = null

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/dashboard.css">
    <link rel="stylesheet" href="/css/cadastro-usuarios-cliente.css">
    <link rel="stylesheet" href="/css/exibicao-cadastro-cliente.css">
    <link rel="stylesheet" href="/css/cadastro-hospedagem.css">
    <link rel="stylesheet" href="/css/editar-hospedagem.css">
    <link rel="stylesheet" href="/css/exibicao-cadastro-cliente.css">
    <link rel="stylesheet" href="/css/cadastro-usuario.css">
    <link rel="stylesheet" href="/css/cadastro-pacote.css">
    <link rel="stylesheet" href="/css/exibicao-hospedagem.css">
    <link rel="stylesheet" href="/css/home.css">
    <link rel="stylesheet" href="/css/gerenciamento-usuario.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <script src="/js/dashboard.js" defer></script>
    <script src="/js/telefone-formatacao.js" defer></script>
    <script src="/js/deletar-cliente.js" defer></script>
    <script src="/js/deletar-hospedagem.js" defer></script>
    <script src="/js/validar-post.js" defer></script>
    <script src="/js/placeholder.js" defer></script>
    <script src="/js/pesquisa.js" defer></script>
    <title>${page == null ? "INNOVA TURISMO" : page.title()}</title>
</head>

<body>
    <section class="section" id="barra-lateral">
        @template.layout.barra-lateral()
    </section>
    
    <!-- Main Content -->
    <section id="content">
    <nav class="nav">
            @template.layout.nav(page)
        </nav>
    <main class="main">
        
        

            ${content}
        
    </main>
    </section>
    <!-- Main Content -->

</body>
</html>