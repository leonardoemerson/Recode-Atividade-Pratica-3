import React from "react";
import './style.css';
import Introducao from "./components/Introducao";
import Contatos from "./components/Contatos";
import Header from "../../components/Header";
import Footer from "../../components/Footer";

function Contato(){
    return(
        <div>
            <Header />
            <Introducao />
            <Contatos />
            <Footer />
        </div>
    );
}

export default Contato;