/**
 * Confirmação de exclusao de um Cliente
 * @author Leonardo Emerson
 * @param idCliente
 */

function confirmarExclusaoCliente(idCliente) {
	let resposta = confirm("Confirma a exclusão deste cliente ?");
	if(resposta === true){
		window.location.href = "deleteCliente?idCliente=" + idCliente
	}

}