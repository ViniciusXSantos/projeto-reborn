@import com.example.agencia_viagens.dto.UsuarioDTO
@import com.example.agencia_viagens.dto.Page
@import java.util.List

@param UsuarioDTO user = new UsuarioDTO()
@param List<String> errors

@if (errors != null && !errors.isEmpty())
<div style="background-color: red">
    <ul>
        @for (var error : errors)
        <li>${error}</li>
        @endfor
    </ul>
</div>
@endif

@template.layout.main(
page = new Page("Cadastro de Funcionário"),
content = @`
    <section class="formulario-container">
        !{var formAction = user.getId() != null ? "/user/edit/" + user.getId() : "/user/save";}
        <form action="${formAction}" method="post" id="usuario-formulario">

            <div class="campos-formulario">
                <fieldset>
                    <legend>Dados Pessoais</legend>

                    <input type="hidden" name="id" value="${user.getId()}">
                    <div class="caixa lado-a-lado">
                        <div class="caixa-input">
                            <input type="text" placeholder="Nome *" id="nome" name="nome" class="input-sem-ponta" value="${user.getNome()}" required>
                        </div>

                        <div class="caixa-input">
                            <input type="email" placeholder="E-mail *" id="email" name="email" value="${user.getEmail()}" class="input-sem-ponta" required>
                        </div>

                        <div class="caixa-input">
                            <input type="password" placeholder="Senha *" id="senha" name="senha" value="${user.getSenha()}" class="input-sem-ponta" required>
                        </div>
                    </div>
                </fieldset>
            </div>

            <button type="submit" class="btn-salvar">
                <i class='bx bxs-save'></i> Salvar
            </button>
        </form>
    </section>
`)