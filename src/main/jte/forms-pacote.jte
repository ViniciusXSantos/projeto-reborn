@import com.example.agencia_viagens.dto.Page
@import com.example.agencia_viagens.dto.PacoteDTO
@import java.util.List

@param PacoteDTO pacotes = new PacoteDTO()

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
    page = new Page("Cadastro de Pacote"),
    content = @`

    <link rel="stylesheet" href="/css/cadastro-pacote.css">

    <!-- Área para Foto Expandida -->
    <!--<section class="caixa-conteudo">-->
    <section class="formulario-container">
        <div class="envio-de-foto">
            <input type="file" id="file-upload" class="input-file">
            <label for="file-upload" class="file-label">
                <span>+</span>
                <p>Clique aqui para adicionar uma Foto</p>
            </label>
        </div>
        
        !{var formAction = pacotes.getIdPacote() != null ? "/pacotes/edit/" + pacotes.getIdPacote() : "/pacotes/save";}
        <form action="${formAction}" method="post">
            <div class="campos-formulario">
                <fieldset>
                    <legend></legend>

                    <input type="hidden" name="idPacote" value="${pacotes.getIdPacote()}">
                    <div class="caixa lado-a-lado">
                        <div class="caixa-input"><input type="text" placeholder="Insira um título *" name="titulo" value="${pacotes.getTitulo()}" required></div>
                        <div class="caixa-input"><input type="text" placeholder="Insira uma descrição *" name="descricao" value="${pacotes.getDescricao()}" required></div>
                        <div class="caixa-input"><input type="date" placeholder="Data de partida *" name="dataPartida" value="${pacotes.getDataPartida()}" required></div> <!-- mudar-->
                        <div class="caixa-input"><input type="date" placeholder="Data de chegada *" name="dataChegada" value="${pacotes.getDataChegada()}" required></div> <!-- mudar-->
                    </div>
                </fieldset>

                <fieldset>
                    <legend></legend>
                    <div class="caixa lado-a-lado">
                        <div class="caixa-input"><input type="text" placeholder="Estado" name="estado" value="${pacotes.getEstado()}"></div>
                        <div class="caixa-input"><input type="text" placeholder="Hospedagem" name="hospedagem" value="${pacotes.getHospedagem()}"></div>
                        <div class="caixa-input"><input type="text" placeholder="Passeios" name="passeios" value="${pacotes.getPasseios()}"></div>
                        <div class="caixa-input"><input type="text" placeholder="Translado" name="translado" value="${pacotes.getTranslado()}"></div>
                        <div class="caixa-input"><input type="text" placeholder="Valor" name="valor" value="${pacotes.getValor()}"></div>
                    </div>
                </fieldset>
            </div>

            <button class="btn-salvar">
                <img src="/assets/icons/icone-botao-de-salvar.svg"class="icone">Salvar
            </button>
        </form>
    </section>
`)