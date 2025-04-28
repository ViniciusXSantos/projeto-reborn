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
    </ul>
</div>
@endif

@template.layout.main(
page = new Page("Cadastro de Pacote"),
content = @`
    

    <section class="formulario-container">
        !{var formAction = pacotes.getIdPacote() != null ? "/pacotes/edit/" + pacotes.getIdPacote() : "/pacotes/save";}
        <form action="${formAction}" method="post">
            <div class="campos-formulario">
                <fieldset>
                    <legend>Informações do Pacote</legend>

                    <input type="hidden" name="idPacote" value="${pacotes.getIdPacote()}">
                    <div class="caixa lado-a-lado">
                        <div class="caixa-input">
                            <input type="text" placeholder="Título *" name="titulo" value="${pacotes.getTitulo()}" required>
                        </div>
                        <div class="caixa-input">
                            <input type="text" placeholder="Descrição *" name="descricao" value="${pacotes.getDescricao()}" required>
                        </div>
                        <div class="caixa-input">
                            <input type="text" data-type="date" placeholder="Data de Partida *" name="dataPartida" value="${pacotes.getDataPartida()}" required>
                        </div>
                        <div class="caixa-input">
                            <input type="text" data-type="date" placeholder="Data de Chegada *" name="dataChegada" value="${pacotes.getDataChegada()}" required>
                        </div>
                    </div>
                </fieldset>

                <fieldset>
                    <legend>Detalhes do Pacote</legend>
                    <div class="caixa lado-a-lado">
                        <div class="caixa-input">
                            <input type="text" placeholder="Estado" name="estado" value="${pacotes.getEstado()}">
                        </div>
                        <div class="caixa-input">
                            <input type="text" placeholder="Hospedagem" name="hospedagem" value="${pacotes.getHospedagem()}">
                        </div>
                        <div class="caixa-input">
                            <input type="text" placeholder="Passeios" name="passeios" value="${pacotes.getPasseios()}">
                        </div>
                        <div class="caixa-input">
                            <input type="text" placeholder="Translado" name="translado" value="${pacotes.getTranslado()}">
                        </div>
                        <div class="caixa-input">
                            <input type="text" placeholder="Valor" name="valor" value="${pacotes.getValor()}">
                        </div>
                    </div>
                </fieldset>
            </div>

            <button class="btn-salvar">
                <i class='bx bxs-save'></i> Salvar
            </button>
        </form>
    </section>

    
`)