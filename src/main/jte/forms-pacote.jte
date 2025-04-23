@import com.example.agencia_viagens.dto.Page

@template.layout.main(
    page = new Page("Cadastro de Pacote"),
    content = @`
    <section class="formulario-container">

        <!-- Área para Foto Expandida -->
        <div class="caixa-conteudo">
            <div class="envio-de-foto">
                <input type="file" id="file-upload" class="input-file">
                <label for="file-upload" class="file-label">
                    <span>+</span>
                    <p>Clique aqui para adicionar uma Foto</p>
                </label>
            </div>


            <form action="" method="post" class="campos-formulario lado-a-lado">
                <fieldset>
                    <legend></legend>
                    <div class="caixa lado-a-lado">
                        <div class="caixa-input"><input type="text" placeholder="Insira um título"></div>
                        <div class="caixa-input"><input type="text" placeholder="Insira uma descrição"></div>
                        <div class="caixa-input"><input type="date" placeholder="Data de partida"></div> <!-- mudar-->
                        <div class="caixa-input"><input type="date" placeholder="Data de chegada"></div> <!-- mudar-->
                    </div>
                </fieldset>

                <fieldset>
                    <legend></legend>
                    <div class="caixa lado-a-lado">
                        <div class="caixa-input"><input type="text" placeholder="Estado"></div>
                        <div class="caixa-input"><input type="text" placeholder="Hospedagem"></div>
                        <div class="caixa-input"><input type="text" placeholder="Passeios"></div>
                        <div class="caixa-input"><input type="text" placeholder="Translado"></div>
                        <div class="caixa-input"><input type="text" placeholder="Valor" ></div>
                    </div>
                </fieldset>

            </form>
        </div>
        <button class="btn-salvar">
            <img src="/assets/icons/icone-botao-de-salvar.svg"class="icone">Salvar
        </button>
    </section>
`)