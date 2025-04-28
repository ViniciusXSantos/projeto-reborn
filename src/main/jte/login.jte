@param String error
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/login.css">
    <link rel="stylesheet" href="/css/dashboard.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <title>Login</title>
</head>

<body>
<div class="conteiner">
    <!-- Formulário de Login -->
    <div class="caixa-de-formulario login">
        <form action="/login" method="post">
            <h1>Log-in</h1>
            <div class="caixa-de-input">
                <input type="text" name="username" placeholder="Email" required>
                <i class='bx bxs-user'></i>
            </div>
            <div class="caixa-de-input">
                <input type="password" name="password" placeholder="Senha" required>
                <i class='bx bxs-lock-alt'></i>
            </div>
            <button type="submit" class="btn">Login</button>
        </form>
        @if(error != null)
            <div class="error-message">Email ou senha incorretos</div>
        @endif
    </div>

    <!-- Painel de Alternância -->
    <div class="toggle-box">
        <div class="toggle-panel toggle-esquerdo">
            <h1>Olá, Bem-Vindo!</h1>
            <h2>InnovaTour</h2>
        </div>
    </div>
</div>

</body>

</html>