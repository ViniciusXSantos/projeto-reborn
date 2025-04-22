document.addEventListener("DOMContentLoaded", function() {
    document.querySelectorAll(".ativo").forEach(button => {
        button.addEventListener("click", function() {
            if (this.textContent === "Ativar") {
                this.textContent = "Desativar";
                this.style.backgroundColor = "#e94e1b";
            } else {
                this.textContent = "Ativar";
                this.style.backgroundColor = ""; // Volta ao padrão
            }
        });
    });
});