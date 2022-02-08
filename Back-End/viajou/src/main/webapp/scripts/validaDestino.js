/**
 * Validação de formulario
 * @author Leonardo Emerson
 */

function validarDestino(){
	let endereco = frmDestino.endereco.value
	let nome = frmDestino.nome.value
	let preco = frmDestino.preco.value
	let qtdVagas = frmDestino.qtdVagas.value
	if(endereco === ""){
		alert("Preencha o campo endereço!")
		frmCliente.endereco.focus()
		return false
	} else if(nome=== ""){
		alert("Preencha o campo nome!")
		frmCliente.nome.focus()
		return false
	} else if(preco=== ""){
		alert("Preencha o campo preço!")
		frmCliente.preco.focus()
		return false
	} else if(qtdVagas=== ""){
		alert("Preencha o campo quantidade de vagas!")
		frmCliente.qtdVagas.focus()
		return false
	} else{
		document.forms["frmDestino"].submit()
	}

}