
document.addEventListener("DOMContentLoaded", function () {
    const dateInputs = document.querySelectorAll('input[type="text"][data-type="date"]');

    dateInputs.forEach(input => {
        input.addEventListener("focus", function () {
            this.type = "date";
        });

        input.addEventListener("blur", function () {
            if (!this.value) {
                this.type = "text";
            }
        });
    });
});
