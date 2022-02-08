package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Destino;
import model.Agencia;
import model.DAO;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = { "/Controller", "/mainCliente", "/insertCliente", "/selectCliente", "/updateCliente",
		"/deleteCliente", "/reportCliente", "/mainDestino", "/insertDestino", "/selectDestino", "/updateDestino", 
		"/deleteDestino", "/reportDestino", "/mainAgencia", "/insertAgencia", "/selectAgencia", "/updateAgencia",
		"/deleteAgencia", "/reportAgencia", "/promocao", "/catalogo", "/home", "/contato"})
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
	
	/** The cliente. */
	Cliente cliente = new Cliente();
	
	/** The destino. */
	Destino destino = new Destino();
	
	/** The agencia. */
	Agencia agencia = new Agencia();

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		super();
	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/mainCliente")) {
			clientes(request, response);
		} else if (action.equals("/insertCliente")) {
			adicionarCliente(request, response);
		} else if (action.equals("/selectCliente")) {
			listarCliente(request, response);
		} else if (action.equals("/updateCliente")) {
			editarCliente(request, response);
		} else if (action.equals("/deleteCliente")) {
			removerCliente(request, response);
		} else if (action.equals("/reportCliente")) {
			gerarRelatorioCliente(request, response);
		} else if (action.equals("/mainDestino")) {
			destinos(request, response);
		} else if (action.equals("/insertDestino")) {
			adicionarDestino(request, response);
		}  else if (action.equals("/selectDestino")) {
			listarDestino(request, response);
		}  else if (action.equals("/updateDestino")) {
			editarDestino(request, response);
		} else if (action.equals("/deleteDestino")) {
			removerDestino(request, response);
		}else if (action.equals("/reportDestino")) {
			gerarRelatorioDestino(request, response);
		} else if (action.equals("/mainAgencia")) {
			agencias(request, response);
		} else if (action.equals("/insertAgencia")) {
			adicionarAgencia(request, response);
		}  else if (action.equals("/selectAgencia")) {
			listarAgencia(request, response);
		}  else if (action.equals("/updateAgencia")) {
			editarAgencia(request, response);
		} else if (action.equals("/deleteAgencia")) {
			removerAgencia(request, response);
		} else if (action.equals("/reportAgencia")) {
			gerarRelatorioAgencia(request, response);
		} else if (action.equals("/promocao")) {
			response.sendRedirect("promocao.html");
		}  else if (action.equals("/catalogo")) {
			response.sendRedirect("catalogo.html");
		} else if (action.equals("/home")) {
			response.sendRedirect("index.html");
		}else if (action.equals("/contato")) {
			response.sendRedirect("contato.html");
		} else {
			response.sendRedirect("index.html");
		}

	}

	/**
	 * Clientes.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Listar clientes
	protected void clientes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que irá receber os dados Cliente
		ArrayList<Cliente> lista = dao.listarClientes();
		// Encaminhar a lista ao documento cliente.jsp
		request.setAttribute("clientes", lista);
		RequestDispatcher rd = request.getRequestDispatcher("cliente.jsp");
		rd.forward(request, response);
	}

	/**
	 * Adicionar cliente.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void adicionarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setar as variáveis Cliente
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setRg(request.getParameter("rg"));
		cliente.setEndereco(request.getParameter("endereco"));
		// Invocar o método inserirCliente passando o objeto cliente
		dao.inserirCliente(cliente);
		// Redirecionar para o documento cliente.jsp
		response.sendRedirect("mainCliente");
	}

	/**
	 * Listar cliente.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Editar cliente
	protected void listarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento do id do cliente que será editado
		String IdCliente = request.getParameter("IdCliente");
		// Setar a variável Cliente
		cliente.setIdCliente(Integer.parseInt(IdCliente));
		// Executar o método selecionarCliente (DAO)
		dao.selecionarCliente(cliente);
		// Setar os atributos do formulário com o conteúdo Cliente
		request.setAttribute("idCliente", cliente.getIdCliente());
		request.setAttribute("nome", cliente.getNome());
		request.setAttribute("cpf", cliente.getCpf());
		request.setAttribute("rg", cliente.getRg());
		request.setAttribute("endereco", cliente.getEndereco());
		// Encaminhar ao documento editarCliente.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editarCliente.jsp");
		rd.forward(request, response);
	}

	/**
	 * Editar cliente.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setar as variáveis Cliente
		cliente.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setRg(request.getParameter("rg"));
		cliente.setEndereco(request.getParameter("endereco"));
		// Executar o método alterar cliente
		dao.alterarCliente(cliente);
		// Redirecionar para o documento cliente.jsp (Atualizando as alterações)
		response.sendRedirect("mainCliente");
	}

	/**
	 * Remover cliente.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Remover um cliente
	protected void removerCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento do id do cliente a ser excluído (validaCliente.js)
		String idCliente = request.getParameter("idCliente");
		// Setar a variável idCliente Cliente
		cliente.setIdCliente(Integer.parseInt(idCliente));
		// Executar o método deletarCliente (DAO) passando o objeto Cliente
		dao.deletarCliente(cliente);
		// Redirecionar para o documento cliente.jsp (Atualizando as alterações)
		response.sendRedirect("mainCliente");

	}

	/**
	 * Gerar relatorio cliente.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Gerar relatório em PDF
	protected void gerarRelatorioCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			// Tipo de conteúdo
			response.setContentType("application/pdf");
			// Nome do documento
			response.addHeader("Content-Disposition", "inline; filename=" + "clientes.pdf");
			// Criar o documento
			PdfWriter.getInstance(documento, response.getOutputStream());
			// Abrir o documento -> conteúdo
			documento.open();
			documento.add(new Paragraph("Lista de Clientes: "));
			documento.add(new Paragraph(" "));
			// Criar uma tabela
			PdfPTable tabela = new PdfPTable(4);
			// Cabeçalho
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("CPF"));
			PdfPCell col3 = new PdfPCell(new Paragraph("RG"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Endereço"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			// Popular a tabela com os clientes
			ArrayList<Cliente> lista = dao.listarClientes();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNome());
				tabela.addCell(lista.get(i).getCpf());
				tabela.addCell(lista.get(i).getRg());
				tabela.addCell(lista.get(i).getEndereco());
			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}

	}

	/**
	 * Destinos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Listar destinos
	protected void destinos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que irá receber os dados Destino
				ArrayList<Destino> lista = dao.listarDestinos();
				// Encaminhar a lista ao documento destino.jsp
				request.setAttribute("destinos", lista);
				RequestDispatcher rd = request.getRequestDispatcher("destino.jsp");
				rd.forward(request, response);
	}

	/**
	 * Adicionar destino.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Novo destino
	protected void adicionarDestino(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setar as variáveis Destino
		destino.setEndereco(request.getParameter("endereco"));
		destino.setNome(request.getParameter("nome"));
		destino.setPreco(Double.parseDouble(request.getParameter("preco")));
		destino.setQtdVagas(Integer.parseInt(request.getParameter("qtdVagas")));
		// Invocar o método inserirDestino passando o objeto destino
		dao.inserirDestino(destino);
		// Redirecionar para o documento destino.jsp
		response.sendRedirect("mainDestino");
	}
	
	/**
	 * Listar destino.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Listar destino
		protected void listarDestino(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Recebimento do id do destino que será editado
			String IdDestino = request.getParameter("IdDestino");
			// Setar a variável Destino
			destino.setIdDestino(Integer.parseInt(IdDestino));
			// Executar o método selecionarDestino (DAO)
			dao.selecionarDestino(destino);
			// Setar os atributos do formulário com o conteúdo Destino
			request.setAttribute("idDestino", destino.getIdDestino());
			request.setAttribute("endereco", destino.getEndereco());
			request.setAttribute("nome", destino.getNome());
			request.setAttribute("preco", destino.getPreco());
			request.setAttribute("qtdVagas", destino.getQtdVagas());
			// Encaminhar ao documento editarDestino.jsp
			RequestDispatcher rd = request.getRequestDispatcher("editarDestino.jsp");
			rd.forward(request, response);
		}

		/**
		 * Editar destino.
		 *
		 * @param request the request
		 * @param response the response
		 * @throws ServletException the servlet exception
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		protected void editarDestino(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Setar as variáveis Destino
			destino.setIdDestino(Integer.parseInt(request.getParameter("idDestino")));
			destino.setEndereco(request.getParameter("endereco"));
			destino.setNome(request.getParameter("nome"));
			destino.setPreco(Double.parseDouble(request.getParameter("preco")));
			destino.setQtdVagas(Integer.parseInt(request.getParameter("qtdVagas")));
			// Executar o método alterar destino
			dao.alterarDestino(destino);
			// Redirecionar para o documento destino.jsp (Atualizando as alterações)
			response.sendRedirect("mainDestino");
		}
		
		/**
		 * Remover destino.
		 *
		 * @param request the request
		 * @param response the response
		 * @throws ServletException the servlet exception
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		// Remover um destino
		protected void removerDestino(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Recebimento do id do destino a ser excluído (validaDestino.js)
			String idDestino = request.getParameter("idDestino");
			// Setar a variável idDestino Destino
			destino.setIdDestino(Integer.parseInt(idDestino));
			// Executar o método deletarDestino (DAO) passando o objeto Destino
			dao.deletarDestino(destino);
			// Redirecionar para o documento destino.jsp (Atualizando as alterações)
			response.sendRedirect("mainDestino");

		}
		
		/**
		 * Gerar relatorio destino.
		 *
		 * @param request the request
		 * @param response the response
		 * @throws ServletException the servlet exception
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		// Gerar relatório em PDF
		protected void gerarRelatorioDestino(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			Document documento = new Document();
			try {
				// Tipo de conteúdo
				response.setContentType("application/pdf");
				// Nome do documento
				response.addHeader("Content-Disposition", "inline; filename=" + "destinos.pdf");
				// Criar o documento
				PdfWriter.getInstance(documento, response.getOutputStream());
				// Abrir o documento -> conteúdo
				documento.open();
				documento.add(new Paragraph("Lista de Destinos: "));
				documento.add(new Paragraph(" "));
				// Criar uma tabela
				PdfPTable tabela = new PdfPTable(4);
				// Cabeçalho
				PdfPCell col1 = new PdfPCell(new Paragraph("Endereço"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Nome"));
				PdfPCell col3 = new PdfPCell(new Paragraph("Preço"));
				PdfPCell col4 = new PdfPCell(new Paragraph("Quantidade de Vagas"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				tabela.addCell(col4);
				// Popular a tabela com os destinos
				ArrayList<Destino> lista = dao.listarDestinos();
				for (int i = 0; i < lista.size(); i++) {
					tabela.addCell(lista.get(i).getEndereco());
					tabela.addCell(lista.get(i).getNome());
					tabela.addCell(String.valueOf(lista.get(i).getPreco()));
					tabela.addCell(String.valueOf(lista.get(i).getQtdVagas()));
				}
				documento.add(tabela);
				documento.close();
			} catch (Exception e) {
				System.out.println(e);
				documento.close();
			}

		}
		
		/**
		 * Agencias.
		 *
		 * @param request the request
		 * @param response the response
		 * @throws ServletException the servlet exception
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		// Listar agências
		protected void agencias(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Criando um objeto que irá receber os dados Agencia
			ArrayList<Agencia> lista = dao.listarAgencias();
			// Encaminhar a lista ao documento agencia.jsp
			request.setAttribute("agencias", lista);
			RequestDispatcher rd = request.getRequestDispatcher("agencia.jsp");
			rd.forward(request, response);
		}

		/**
		 * Adicionar agencia.
		 *
		 * @param request the request
		 * @param response the response
		 * @throws ServletException the servlet exception
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		protected void adicionarAgencia(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Setar as variáveis Agencia
			agencia.setCnpj(request.getParameter("cnpj"));
			agencia.setEndereco(request.getParameter("endereco"));
			agencia.setTelefone(request.getParameter("telefone"));
			agencia.setEmail(request.getParameter("email"));
			// Invocar o método inserirAgencia passando o objeto Agencia
			dao.inserirAgencia(agencia);
			// Redirecionar para o documento agencia.jsp
			response.sendRedirect("mainAgencia");
		}

		/**
		 * Listar agencia.
		 *
		 * @param request the request
		 * @param response the response
		 * @throws ServletException the servlet exception
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		// Editar agência
		protected void listarAgencia(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Recebimento do id da agência que será editada
			String IdAgencia = request.getParameter("IdAgencia");
			// Setar a variável Agencia
			agencia.setIdAgencia(Integer.parseInt(IdAgencia));
			// Executar o método selecionarAgencia (DAO)
			dao.selecionarAgencia(agencia);
			// Setar os atributos do formulário com o conteúdo Agência
			request.setAttribute("idAgencia", agencia.getIdAgencia());
			request.setAttribute("cnpj", agencia.getCnpj());
			request.setAttribute("endereco", agencia.getEndereco());
			request.setAttribute("telefone", agencia.getTelefone());
			request.setAttribute("email", agencia.getEmail());
			// Encaminhar ao documento editarAgencia.jsp
			RequestDispatcher rd = request.getRequestDispatcher("editarAgencia.jsp");
			rd.forward(request, response);
		}

		/**
		 * Editar agencia.
		 *
		 * @param request the request
		 * @param response the response
		 * @throws ServletException the servlet exception
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		protected void editarAgencia(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Setar as variáveis Agencia
			agencia.setIdAgencia(Integer.parseInt(request.getParameter("idAgencia")));
			agencia.setCnpj(request.getParameter("cnpj"));
			agencia.setEndereco(request.getParameter("endereco"));
			agencia.setTelefone(request.getParameter("telefone"));
			agencia.setEmail(request.getParameter("email"));
			// Executar o método alterar Agencia
			dao.alterarAgencia(agencia);
			// Redirecionar para o documento agencia.jsp (Atualizando as alterações)
			response.sendRedirect("mainAgencia");
		}

		/**
		 * Remover agencia.
		 *
		 * @param request the request
		 * @param response the response
		 * @throws ServletException the servlet exception
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		// Remover uma agencia
		protected void removerAgencia(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Recebimento do id da agência a ser excluída (validaAgencia.js)
			String idAgencia = request.getParameter("idAgencia");
			// Setar a variável idAgencia Agencia
			agencia.setIdAgencia(Integer.parseInt(idAgencia));
			// Executar o método deletarAgencia (DAO) passando o objeto Agencia
			dao.deletarAgencia(agencia);
			// Redirecionar para o documento agencia.jsp (Atualizando as alterações)
			response.sendRedirect("mainAgencia");

		}

		/**
		 * Gerar relatorio agencia.
		 *
		 * @param request the request
		 * @param response the response
		 * @throws ServletException the servlet exception
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		// Gerar relatório em PDF
		protected void gerarRelatorioAgencia(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			Document documento = new Document();
			try {
				// Tipo de conteúdo
				response.setContentType("application/pdf");
				// Nome do documento
				response.addHeader("Content-Disposition", "inline; filename=" + "agencias.pdf");
				// Criar o documento
				PdfWriter.getInstance(documento, response.getOutputStream());
				// Abrir o documento -> conteúdo
				documento.open();
				documento.add(new Paragraph("Lista de Agências: "));
				documento.add(new Paragraph(" "));
				// Criar uma tabela
				PdfPTable tabela = new PdfPTable(4);
				// Cabeçalho
				PdfPCell col1 = new PdfPCell(new Paragraph("CNPJ"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Endereço"));
				PdfPCell col3 = new PdfPCell(new Paragraph("Telefone"));
				PdfPCell col4 = new PdfPCell(new Paragraph("Email"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				tabela.addCell(col4);
				// Popular a tabela com as agências
				ArrayList<Agencia> lista = dao.listarAgencias();
				for (int i = 0; i < lista.size(); i++) {
					tabela.addCell(lista.get(i).getCnpj());
					tabela.addCell(lista.get(i).getEndereco());
					tabela.addCell(lista.get(i).getTelefone());
					tabela.addCell(lista.get(i).getEmail());
				}
				documento.add(tabela);
				documento.close();
			} catch (Exception e) {
				System.out.println(e);
				documento.close();
			}

		}

}
