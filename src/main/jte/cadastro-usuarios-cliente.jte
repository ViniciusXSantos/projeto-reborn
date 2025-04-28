@import com.example.agencia_viagens.dto.Page
@import com.example.agencia_viagens.dto.ClienteDTO

@param ClienteDTO cli = new ClienteDTO()

@template.layout.main(
page = new Page("Cadastro de Cliente"),
content = @`
    <link rel="stylesheet" href="/css/cadastro-usuarios-cliente.css">

    <!-- Formulário -->
    <section class="formulario-conteiner">

        !{var formAction = cli.getId() != null ? "/clientes/edit/" + cli.getId() : "/clientes/novo";}
        <form action="${formAction}" method="post">
            <div class="campos-formulario">
                <fieldset>
                    <legend>Dados Pessoais</legend>
                    <input type="hidden" name="id" value="${cli.getId()}">
                    <div class="caixa lado-a-lado">
                        <div class="caixa-input">
                            <input type="text" name="nome" placeholder="Nome *" class="input-sem-ponta" value="${cli.getNome()}" required>
                        </div>
                        <div class="caixa-input">
                            <input type="email" name="email" placeholder="E-mail *" class="input-sem-ponta" value="${cli.getEmail()}" required>
                        </div>
                    </div>

                    <div class="caixa lado-a-lado">
                        <div class="caixa-input">
                            <div class="lado-mesclado">
                                <input type="tel" name="telefone1" placeholder="Telefone *" class="telefone" value="${cli.getTelefone1()}" required>
                                <select name="tipoTelefone1" class="telefone-selecao" required>
                                    <option value="" disabled selected>Selecione...</option>
                                    <option value="Phone">Phone</option>
                                    <option value="Telegram">Telegram</option>
                                    <option value="WhatsApp">WhatsApp</option>
                                </select>
                            </div>
                        </div>

                        <div class="caixa-input">
                            <div class="lado-mesclado">
                                <input type="tel" name="telefone2" placeholder="Telefone" class="telefone" value="${cli.getTelefone2()}">
                                <select name="tipoTelefone2" class="telefone-selecao">
                                    <option value="" disabled selected>Selecione...</option>
                                    <option value="Phone">Phone</option>
                                    <option value="Telegram">Telegram</option>
                                    <option value="WhatsApp">WhatsApp</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </fieldset>

                <fieldset>
                    <legend>Endereço</legend>
                    <div class="caixa lado-a-lado">
                        <div class="caixa-input"><input type="text" name="cep" placeholder="CEP" class="input-sem-ponta" value="${cli.getCep()}"></div>
                        <div class="caixa-input"><input type="text" name="estado" placeholder="Estado" class="input-sem-ponta" value="${cli.getEstado()}"></div>
                        <div class="caixa-input"><input type="text" name="cidade" placeholder="Cidade" class="input-sem-ponta" value="${cli.getCidade()}"></div>
                    </div>
                    <div class="caixa lado-a-lado">
                        <div class="caixa-input"><input type="text" name="bairro" placeholder="Bairro" class="input-sem-ponta" value="${cli.getBairro()}"></div>
                        <div class="caixa-input"><input type="text" name="logradouro" placeholder="Logradouro" class="input-sem-ponta" value="${cli.getLogradouro()}"></div>
                        <div class="caixa-input"><input type="text" name="numero" placeholder="Número" class="input-sem-ponta" value="${cli.getNumero()}"></div>
                    </div>
                    <div class="caixa">
                        <div class="caixa-input"><input type="text" name="complemento" placeholder="Complemento" class="input-sem-ponta" value="${cli.getComplemento()}"></div>
                    </div>
                </fieldset>
            </div>

            <button type="submit" class="btn-salvar">
                <img src="/assets/icons/icone-botao-de-salvar.svg" class="icone">Salvar
            </button>
        </form>
    </section>

    <script>
        document.getElementById("alterar-menu").addEventListener("click", function () {
            document.getElementById("barra-lateral").classList.toggle("active");
        });
    </script>
`)