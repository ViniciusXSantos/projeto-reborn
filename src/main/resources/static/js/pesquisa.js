// Captura o campo de texto pelo ID
const campoTexto = document.getElementById("campoTexto");

// Adiciona um ouvinte de evento para o evento 'keydown'
campoTexto.addEventListener("keydown", function(event) {
    // Captura a tecla pressionada
    console.log("Tecla pressionada: " + event.key);
});