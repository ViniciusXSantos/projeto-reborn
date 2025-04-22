document.getElementById("usuario-formulario").addEventListener("submit", async function (event) {
    event.preventDefault();

    const nome = document.getElementById("nome").value.trim();
    const email = document.getElementById("email").value.trim();
    const telefone1 = document.getElementById("telefone1").value.trim();
    const telefoneSelecao1 = document.getElementById("telefone-selecao1").value;
    const telefone2 = document.getElementById("telefone2").value.trim();
    const telefoneSelecao2 = document.getElementById("telefone-selecao2").value;
    const ativo = false;

    // Criando lista de telefones dinamicamente
    let telefones = [];
    if (telefone1) {
        telefones.push({ numero: telefone1, tipo: telefoneSelecao1 });
    }
    if (telefone2) {
        telefones.push({ numero: telefone2, tipo: telefoneSelecao2 });
    }

    // Criando o objeto usuário
    const usuario = {
        nome: nome,
        email: email,
        ativo: ativo,
        telefones: telefones
    };

    //console.log("#1 Nome: ", nome, " \n E-mail: ", email, " \n Telefones: ", telefones);

    try {
        const response = await fetch("http://localhost:8080/usuarios", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(usuario)
        });

        if (response.ok) {
            alert("Usuário cadastrado com sucesso!");
            document.getElementById("usuario-formulario").reset();
        } else {
            alert("Erro ao cadastrar usuário.");
        }
    } catch (error) {
        console.error("Erro:", error);
        alert("Erro na conexão com o servidor.");
    }
});
