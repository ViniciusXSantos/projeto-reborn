@import com.example.agencia_viagens.dto.UsuarioDTO
@import com.example.agencia_viagens.dto.Page
@import java.util.List

@param UsuarioDTO user =  new UsuarioDTO()

@param List<String> errors

@if (errors != null && !errors.isEmpty())
    <div style="background-color: red">
        <ul>
            @for (var error : errors)
                <li>${error}</li>
            @endfor
            <li></li>
        </ul>
    </div>
@endif

@template.layout.main(
    page = new Page("Cadastro de Funcionário"),
    content = @`
<style>
            .caixa-conteudo {
                display: flex;
                width: 80%;
                /*flex-wrap: wrap;*/
                gap: 2em;
            }

            .lado-a-lado {
                flex-grow: 1;
            }

            .upload-de-foto {
                margin: 0;
                height: auto;
                flex-basis: 300px;
                justify-content: center;
            }

            .campos-formulario {
                margin: 0;
            }

            @media (max-width: 540px) {
                .caixa-cabecalho {
                    justify-content: flex-end;
                    gap: 5%;
                }

                .caixa-cabecalho h1 {
                    font-size: 1.8rem;
                }

                .caixa-conteudo {
                    margin-top: 20%;
                    display: grid;
                }

                .menu-hamburger {
                    display: flex;
                    width: 3.5rem;
                    height: 3.5rem;
                }

                .upload-de-foto {
                    width: auto;
                    height: 250px;
                }
            }
        </style>
        <script>

            fetch('http://127.0.0.1:5501')   // Realiza a requisição
            .then(produtos => produtos.json())      // Converte o valor recebido em JSON
            .then(retorno => console.log(retorno))  // Exibindo os produtos
  
        </script>
    </head>

<section class="formulario-container">
    <!-- Área para Foto Expandida -->
    <div class="caixa-conteudo">
        <div class="upload-de-foto lado-a-lado">
            <span>+</span>
        </div>

        <!--@if (${user.getId() != null})
            <form action="/user/save" method="post" id="usuario-formulario">
        @else
            <form action="/user/edit/${user.getId()}" method="post" id="usuario-formulario">
        @endif-->

        <!--<form action="${user.getId() != null ? "/user/save" : "/user/edit/${user.getId()"}" method="post" id="usuario-formulario">-->

        <!--@var formAction = user.getId() != null ? "/user/edit/user.getId()" + user.getId() : "/user/save"
        <form action="${formAction}" method="post" id="usuario-formulario">-->

        !{var formAction = user.getId() != null ? "/user/edit/user.getId()" + user.getId() : "/user/save";}
        <form action="${formAction}" method="post" id="usuario-formulario">

            <div class="campos-formulario">
                <fieldset>
                    <legend>Dados Pessoais</legend>

                    <input type="hidden" name="id" value="${user.getId()}">
                    <div class="caixa lado-a-lado">
                        <div class="caixa-input"><input type="text" placeholder="Nome *" id="nome" name="nome" class="input-sem-ponta"
                            value="${user.getNome()}" required>
                        </div>
                        
                        <div class="caixa-input"><input type="email" placeholder="E-mail *" id="email" name="email"
                            value="${user.getEmail()}" class="input-sem-ponta" required>
                        </div>

                        <div class="caixa-input"><input type="password" placeholder="Senha *" id="senha" name="senha"
                            value="${user.getSenha()}" class="input-sem-ponta" required>
                        </div>
                    </div>

                </fieldset>
            </div>

            <button type="submit" class="btn-salvar">
                <img src="/assets/icons/icone-botao-de-salvar.svg" class="icone">Salvar
            </button>
        </form>
    </div>
</section>
</main>
</div>
<!-- Script para ativar/desativar o menu -->
<script>
    document.getElementById("alterar-menu").addEventListener("click", function () {
        document.getElementById("barra-lateral").classList.toggle("active");
    });
</script>

`)