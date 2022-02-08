import React from "react";
import Home from "./pages/Home";
import Destino from "./pages/Destino";
import Promocao from "./pages/Promocao";
import Contato from "./pages/Contato";
import Cadastro from "./pages/Cadastro";
import Login from "./pages/Login";

function App() {
  const url = window.location.href;
  return (
    <div>
      {
        url=== "http://localhost:3000/Home"
        ?<Home />
        :url=== "http://localhost:3000/Destino"
        ?<Destino />
        :url=== "http://localhost:3000/Promocao"
        ?<Promocao />
        :url=== "http://localhost:3000/Contato"
        ?<Contato />
        :url=== "http://localhost:3000/Cadastro"
        ?<Cadastro />
        :url=== "http://localhost:3000/Login"
        ?<Login />
        :url=== "http://localhost:3000/"
        ?<Home />
        :"Erro"
      }
    </div>
  );
}

export default App;
