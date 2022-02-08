<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Edição de Agencia</title>
<link rel="icon" href="imagens/logo2.jpg">
<link rel="stylesheet" href="style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
		<header>
        <nav class="navbar navbar-expand-sm navbar-toggleable-sm border-bottom box-shadow mb-3" style="background-color: #3b7687">
            <div class="container">
                <a class="navbar-brand" href="home"><img src="./imagens/logo2.jpg" alt="logo" style="height: 60px !important; width: 60px !important;"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".navbar-collapse" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="navbar-collapse collapse d-sm-inline-flex justify-content-between">
                    <ul class="navbar-nav flex-grow-1">
                        <li class="nav-item">
                            <a class="nav-link text-white" href="home">Início</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="mainCliente">Clientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="mainDestino">Destinos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="mainAgencia">Agências</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="catalogo">Catálogo</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="promocao">Promoções</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="contato">Contato</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
	<div id="centerbar">
		<h1>Edite as informações sobre a agência abaixo</h1>
	</div>
	<div id="main1">
	<form name="frmAgencia" action="updateAgencia">
		<table>
			<tr>
				<td><input type="text" name="idAgencia" id="caixa3" readonly value="<%out.print(request.getAttribute("idAgencia")); %>"></td>
			</tr>
			<tr>
				<td><input type="text" name="cnpj" class="Caixa1" value="<%out.print(request.getAttribute("cnpj")); %>"></td>
			</tr>
			<tr>
				<td><input type="text" name="endereco" class="Caixa2" value="<%out.print(request.getAttribute("endereco")); %>"></td>
			</tr>
			<tr>
				<td><input type="text" name="telefone" class="Caixa2" value="<%out.print(request.getAttribute("telefone")); %>"></td>
			</tr>
			<tr>
				<td><input type="text" name="email" class="Caixa1" value="<%out.print(request.getAttribute("email")); %>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1"
			onclick="validarAgencia()">
	</form>
	</div>
	<footer class="border-top footer text-muted text-center text-white" style="background-color: #3b7687 !important; color: white !important;">
        <div class="container">
            &copy; 2021 - Viajou - <a href="contato" style="color:#F4F4F4;">Contato</a>
        </div>
    </footer>
	<script src="scripts/validaAgencia.js"></script>
</body>
</html>