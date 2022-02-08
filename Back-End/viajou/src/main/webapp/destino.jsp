<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "model.Destino" %>
<%@ page import = "java.util.ArrayList" %>
<%
	@SuppressWarnings("unchecked")
	ArrayList<Destino> lista = (ArrayList<Destino>) request.getAttribute("destinos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Cadastro de Destinos</title>
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
		<h1>Cadastro de destinos</h1>
	</div>
	<div id="main1">
	<a href="novodestino.html" class="Botao1">Cadastrar Destino</a>
	<a href="reportDestino" class="Botao2">Relatório</a>
		<table id="tabela">
		<thead>
			<tr>
				<th>ID</th>
				<th>Endereco</th>
				<th>Nome</th>
				<th>Preço</th>
				<th>Quantidade de Vagas</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i=0; i<lista.size(); i++) { %>
				<tr>
					<td><%=lista.get(i).getIdDestino() %></td>
					<td><%=lista.get(i).getEndereco() %></td>
					<td><%=lista.get(i).getNome() %></td>
					<td><%=lista.get(i).getPreco() %></td>
					<td><%=lista.get(i).getQtdVagas() %></td>
					<td><a href="selectDestino?IdDestino=<%=lista.get(i).getIdDestino() %>" class="Botao1">Editar</a>
					<a href="javascript: confirmarExclusaoDestino(<%=lista.get(i).getIdDestino() %>)" class="Botao2">Excluir</a>
				</tr>
			<%} %>
		</tbody>
	</table>
	</div>
	<footer class="border-top footer text-muted text-center text-white" style="background-color: #3b7687 !important; color: white !important;">
        <div class="container">
            &copy; 2021 - Viajou - <a href="contato" style="color:#F4F4F4;">Contato</a>
        </div>
    </footer>
	<script src="scripts/confirmaExclusaoDestino.js"></script>
</body>
</html>