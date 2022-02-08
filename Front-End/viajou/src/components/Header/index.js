import React from "react";
import "./style.css";

function Header(){
    return(
        <div id="container-fluid">
        <nav class="navbar navbar-expand-md navbar-dark bg-dark" id="menu">
            <div class="navbar-collapse collapsedual-collapse2 me-auto">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="Home">Início</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Destino">Destinos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Promocao">Promoções</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Contato">Contatos</a>
                    </li>
                </ul>
            </div>
            <div class="navbar-collapse collapsedual-collapse2 mx-auto">
                <a class="navbar-brand " href="Home"><img src="./images/logo2.jpg" className="logoSizes" alt="Logo" /></a>
            </div>
            <div class="navbar-collapse collapsedual-collapse2">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="Login">Entrar</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Cadastro">Registre-se</a>
                    </li>
                </ul>
            </div>
        </nav>
        </div>
    );
}

export default Header;