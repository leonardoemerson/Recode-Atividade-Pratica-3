import React from "react";
import './style.css';
import Header from "../../components/Header";
import Footer from "../../components/Footer";
import Introducao from "./components/Introducao";
import Destinos from "./components/Destinos";

function Destino(){
    return(
        <div>
            <Header />
            <Introducao />
            <Destinos />
            <Footer />
        </div>
        
    );
}

export default Destino;