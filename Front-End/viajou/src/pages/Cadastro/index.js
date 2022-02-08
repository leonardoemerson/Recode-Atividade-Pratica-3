import React from "react";
import "./style.css";
import Header from "../../../src/components/Header";
import Footer from "../../../src/components/Footer";

function Cadastro(){
    return(
        <div>
        <Header />
        <div class="flex-container">
        <div class="content-container">
          <div class="form-container">
            <form action="/action_page.php">
              <h1>
                Cadastro
              </h1>
              <br/>
              <br/>
              <span class="subtitle">Login:</span>
              <br/>
              <input type="text" name="username" value=""/>
              <br/>
              <span class="subtitle">Senha:</span>
              <br/>
              <input type="password" name="password" value=""/>
              <br/><br/>
              <input type="submit" value="Cadastrar" class="submit-btn"/>
            </form>
          </div>
        </div>
      </div>
      <Footer />
      </div>
    );
}

export default Cadastro;