document.addEventListener("DOMContentLoaded", function () {
    document.querySelectorAll("input.telefone").forEach(input => {
        input.addEventListener("input", formatarTelefone);
        input.addEventListener("focus", adicionarParenteses);
    });
});

function adicionarParenteses(event) {
    let input = event.target;
    if (!input.value.startsWith("(")) {
        input.value = "(";
    }
}

function formatarTelefone(event) {
    let input = event.target;
    let numeros = input.value.replace(/\D/g, ""); // Remove não numéricos
    
    if (numeros.length > 0 && !numeros.startsWith("(")) {
        numeros = "(" + numeros;
    }

    if (numeros.length >= 3) {
        numeros = "(" + numeros.substring(1, 3) + ") " + numeros.substring(3);
    }
    
    if (numeros.length >= 10) {
        if (numeros[5] === "9") {
            if (numeros.length > 14) { // Corrigido para aceitar no máximo 11 números
                numeros = numeros.substring(0, 14);
            }
        } else {
            if (numeros.length > 13) { // Corrigido para aceitar no máximo 10 números
                numeros = numeros.substring(0, 13);
            }
        }
    }
    
    input.value = numeros;
}