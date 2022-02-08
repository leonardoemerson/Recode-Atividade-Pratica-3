/**
 * Validação de formulario
 * @author Leonardo Emerson
 */

function validarCliente(){
	let nome = frmCliente.nome.value
	let cpf = frmCliente.cpf.value
	let rg = frmCliente.rg.value
	let endereco = frmCliente.endereco.value
	if(nome === ""){
		alert("Preencha o campo nome!")
		frmCliente.nome.focus()
		return false
	} else if(cpf=== ""){
		alert("Preencha o campo cpf!")
		frmCliente.cpf.focus()
		return false
	} else if(rg=== ""){
		alert("Preencha o campo rg!")
		frmCliente.rg.focus()
		return false
	} else if(endereco=== ""){
		alert("Preencha o campo endereco!")
		frmCliente.endereco.focus()
		return false
	} else{
		document.forms["frmCliente"].submit()
	}
}