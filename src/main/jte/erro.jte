@template.layout.main(content = @`

    .cartoes-usuario {
        text-align: center;
        display: flex;
        justify-content: center;
    }

    .mensagem-erro {
        padding: 5%;
        border-radius: 50px;
        width: 30%;
        background-color: var(--cor-quaternaria);
    }

    .texto-erro {
        font-size: 540%;
        color: var(--cor-terciaria);
    }

    <div class="cartoes-usuario">
        <div class="mensagem-erro">
            <p class="texto-erro">ERRO</p>
        </div>                    
    </div>

`)  