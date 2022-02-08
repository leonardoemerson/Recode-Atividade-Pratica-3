/**
 * Validação de formulario
 * @author Leonardo Emerson
 */

function validarAgencia(){
	let cnpj = frmAgencia.cnpj.value
	let endereco = frmAgencia.endereco.value
	let telefone = frmAgencia.telefone.value
	let email = frmAgencia.email.value
	if(cnpj === ""){
		alert("Preencha o campo CNPJ!")
		frmAgencia.cnpj.focus()
		return false
	} else if(endereco === ""){
		alert("Preencha o campo endereco!")
		frmAgencia.endereco.focus()
		return false
	} else if(telefone === ""){
		alert("Preencha o campo telefone!")
		frmAgencia.telefone.focus()
		return false
	} else if(email === ""){
		alert("Preencha o campo email!")
		frmAgencia.email.focus()
		return false
	} else{
		document.forms["frmAgencia"].submit()
	}

}