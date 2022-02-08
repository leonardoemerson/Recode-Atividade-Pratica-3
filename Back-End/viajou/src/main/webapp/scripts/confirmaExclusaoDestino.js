/**
 * Confirmação de exclusao de um Destino
 * @author Leonardo Emerson
 * @param idDestino
 */

function confirmarExclusaoDestino(idDestino) {
	let resposta = confirm("Confirma a exclusão deste destino ?");
	if(resposta === true){
		window.location.href = "deleteDestino?idDestino=" + idDestino
	}

}