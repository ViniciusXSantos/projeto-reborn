// Seleciona todos os links do menu lateral
const allSideMenu = document.querySelectorAll('#barra-lateral .barra-menu.top .li .a');

allSideMenu.forEach((item) => {
    const li = item.parentElement;

    item.addEventListener('click', function () {
        // Remove a classe 'active' de todos os itens
        allSideMenu.forEach(i => i.parentElement.classList.remove('active'));
        // Adiciona ou remove a classe 'active' no item clicado
        li.classList.toggle('active');
    });
});

// Toggle sidebar
const menuBar = document.querySelector('#content .nav .bx.bx-menu');
const sidebar = document.querySelector('#barra-lateral');

menuBar.addEventListener('click', function () {
    sidebar.classList.toggle('hide'); // Adiciona ou remove a classe 'hide'
});

// Ajusta o estado inicial com base na largura da janela
function adjustLayout() {
    if (window.innerWidth < 768) {
        sidebar.classList.add('hide'); // Oculta o sidebar se a largura for menor que 768px
    } else {
        sidebar.classList.remove('hide'); // Mostra o sidebar se a largura for maior ou igual a 768px
    }

}

// Chama a função ao carregar a página
adjustLayout();

// Adiciona um evento para ajustar o layout ao redimensionar a janela
window.addEventListener('resize', adjustLayout);
