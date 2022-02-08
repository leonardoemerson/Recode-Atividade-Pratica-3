/**
 * Confirmação de exclusao de uma Agencia
 * @author Leonardo Emerson
 * @param idAgencia
 */

function confirmarExclusaoAgencia(idAgencia) {
	let resposta = confirm("Confirma a exclusão desta agência ?");
	if(resposta === true){
		window.location.href = "deleteAgencia?idAgencia=" + idAgencia
	}

}