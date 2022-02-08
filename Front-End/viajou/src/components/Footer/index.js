import React from "react";
import "./style.css";

function Footer(){
    return(
        <footer class="bg-dark text-center text-white" className="footerStyle">
            <div class="text-center p-3" className="divStyle">
            &copy;2021 Viajou &nbsp;<span class="separator">|</span>&nbsp; Desenvolvido por: Leonardo Emerson 
            </div>
        </footer>
    );
}

export default Footer;