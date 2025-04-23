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
        font-size: 240%;
        color: var(--cor-quaternaria);
    }

    <div class="cartoes-usuario" style="display: block;">
        <div><img src="../assets/backgrounds/erro-monstro.png" style="width: 50%;"></div>
        <div><p class="texto-erro">OPS! NÃO ENCONTRAMOS ESSA PÁGINA</p></div>
    </div>

`)  