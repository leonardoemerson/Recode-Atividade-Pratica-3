package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	/**  M�dulo de conex�o *. */
	// Par�metros de conex�o
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dbviajou?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "Coloque seu usuário aqui";
	
	/** The password. */
	private String password = "Coloque sua senha aqui";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	// M�todo de conex�o
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 *  CRUD CREATE *.
	 *
	 * @param cliente the cliente
	 */
	public void inserirCliente(Cliente cliente) {
		String create = "insert into Clientes (nome, cpf, rg, endereco) values (?,?,?,?)";
		try {
			// Fazer conex�o
			Connection con = conectar();
			// Preparar a query para execu��o no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os par�metros (?) pelo conte�do das vari�veis de Cliente
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getCpf());
			pst.setString(3, cliente.getRg());
			pst.setString(4, cliente.getEndereco());
			// Executar a query
			pst.executeUpdate();
			// Encerrar a conex�o com o banco
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Inserir destino.
	 *
	 * @param destino the destino
	 */
	public void inserirDestino(Destino destino) {
		String create = "insert into Destinos (endereco, nome, preco, qtdVagas) values (?,?,?,?)";
		try {
			// Fazer conex�o
			Connection con = conectar();
			// Preparar a query para execu��o no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os par�metros (?) pelo conte�do das vari�veis de Cliente
			pst.setString(1, destino.getEndereco());
			pst.setString(2, destino.getNome());
			pst.setString(3, String.valueOf(destino.getPreco()));
			pst.setString(4, String.valueOf(destino.getQtdVagas()));
			// Executar a query
			pst.executeUpdate();
			// Encerrar a conex�o com o banco
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Inserir agencia.
	 *
	 * @param agencia the agencia
	 */
	public void inserirAgencia(Agencia agencia) {
		String create = "insert into Agencias (cnpj, endereco, telefone, email) values (?,?,?,?)";
		try {
			// Fazer conex�o
			Connection con = conectar();
			// Preparar a query para execu��o no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os par�metros (?) pelo conte�do das vari�veis de Ag�ncia
			pst.setString(1, agencia.getCnpj());
			pst.setString(2, agencia.getEndereco());
			pst.setString(3, String.valueOf(agencia.getTelefone()));
			pst.setString(4, String.valueOf(agencia.getEmail()));
			// Executar a query
			pst.executeUpdate();
			// Encerrar a conex�o com o banco
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	

	/**
	 *  CRUD READ *.
	 *
	 * @return the array list
	 */
	public ArrayList<Cliente> listarClientes() {
		// Criando um objeto para acessar a classe Cliente
		ArrayList<Cliente> clientes = new ArrayList<>();
		String read = "select * from Clientes order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// O while abaixo ser� executado enquanto houver Clientes
			while (rs.next()) {
				// Vari�veis de apoio que recebem os dados do banco
				int idCliente = rs.getInt(1);
				String nome = rs.getString(2);
				String cpf = rs.getString(3);
				String rg = rs.getString(4);
				String endereco = rs.getString(5);
				// Populando o ArrayList
				clientes.add(new Cliente(idCliente, nome, cpf, rg, endereco));
			}
			con.close();
			return clientes;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * Listar destinos.
	 *
	 * @return the array list
	 */
	public ArrayList<Destino> listarDestinos() {
		// Criando um objeto para acessar a classe Destino
		ArrayList<Destino> destinos = new ArrayList<>();
		String read = "select * from Destinos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// O while abaixo ser� executado enquanto houver Destinos
			while (rs.next()) {
				// Vari�veis de apoio que recebem os dados do banco
				int idDestino = rs.getInt(1);
				String endereco = rs.getString(2);
				String nome = rs.getString(3);
				String preco = rs.getString(4);
				String qtdVagas = rs.getString(5);
				// Populando o ArrayList
				destinos.add(new Destino(idDestino, endereco, nome, Double.parseDouble(preco), Integer.parseInt(qtdVagas)));
			}
			con.close();
			return destinos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * Listar agencias.
	 *
	 * @return the array list
	 */
	public ArrayList<Agencia> listarAgencias() {
		// Criando um objeto para acessar a classe Ag�ncia
		ArrayList<Agencia> agencias = new ArrayList<>();
		String read = "select * from Agencias order by idAgencia";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// O while abaixo ser� executado enquanto houver Ag�ncias
			while (rs.next()) {
				// Vari�veis de apoio que recebem os dados do banco
				int idAgencia = rs.getInt(1);
				String cnpj = rs.getString(2);
				String endereco = rs.getString(3);
				String telefone = rs.getString(4);
				String email = rs.getString(5);
				// Populando o ArrayList
				agencias.add(new Agencia(idAgencia, cnpj, endereco, telefone, email));
			}
			con.close();
			return agencias;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 *  CRUD UPDATE  *.
	 *
	 * @param cliente the cliente
	 */
	
	//Selecionar o cliente
		public void selecionarCliente(Cliente cliente) {
			String read2 = "select * from Clientes where idCliente = ?";
			try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(read2);
				pst.setString(1, String.valueOf(cliente.getIdCliente()));
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					//Setar as vari�veis Cliente
					cliente.setIdCliente(Integer.parseInt(rs.getString(1)));
					cliente.setNome(rs.getString(2));
					cliente.setCpf(rs.getString(3));
					cliente.setRg(rs.getString(4));
					cliente.setEndereco(rs.getString(5));
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		/**
		 * Alterar cliente.
		 *
		 * @param cliente the cliente
		 */
		//Editar o Cliente
		public void alterarCliente(Cliente cliente) {
			String update = "update Clientes set nome=?, cpf=?, rg=?, endereco=? where idCliente=?";
			try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, cliente.getNome());
				pst.setString(2, cliente.getCpf());
				pst.setString(3, cliente.getRg());
				pst.setString(4, cliente.getEndereco());
				pst.setString(5, String.valueOf(cliente.getIdCliente()));
				pst.executeUpdate();
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	
	/**
	 * Selecionar destino.
	 *
	 * @param destino the destino
	 */
	//Selecionar o destino
		public void selecionarDestino(Destino destino) {
			String read2 = "select * from Destinos where idDestino = ?";
			try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(read2);
				pst.setString(1, String.valueOf(destino.getIdDestino()));
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					//Setar as vari�veis Destino
					destino.setIdDestino(Integer.parseInt(rs.getString(1)));
					destino.setEndereco(rs.getString(2));
					destino.setNome(rs.getString(3));
					destino.setPreco(Double.parseDouble(rs.getString(4)));
					destino.setQtdVagas(Integer.parseInt(rs.getString(5)));
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		/**
		 * Alterar destino.
		 *
		 * @param destino the destino
		 */
		//Editar o destino
		public void alterarDestino(Destino destino) {
			String update = "update Destinos set endereco=?, nome=?, preco=?, qtdVagas=? where idDestino=?";
			try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, destino.getEndereco());
				pst.setString(2, destino.getNome());
				pst.setString(3, String.valueOf(destino.getPreco()));
				pst.setString(4, String.valueOf(destino.getQtdVagas()));
				pst.setString(5, String.valueOf(destino.getIdDestino()));
				pst.executeUpdate();
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		/**
		 * Selecionar agencia.
		 *
		 * @param agencia the agencia
		 */
		//Selecionar a ag�ncia
		public void selecionarAgencia(Agencia agencia) {
			String read2 = "select * from Agencias where idAgencia = ?";
			try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(read2);
				pst.setString(1, String.valueOf(agencia.getIdAgencia()));
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					//Setar as vari�veis Agencia
					agencia.setIdAgencia(Integer.parseInt(rs.getString(1)));
					agencia.setCnpj(rs.getString(2));
					agencia.setEndereco(rs.getString(3));
					agencia.setTelefone(rs.getString(4));
					agencia.setEmail(rs.getString(5));
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		/**
		 * Alterar agencia.
		 *
		 * @param agencia the agencia
		 */
		//Editar a agencia
		public void alterarAgencia(Agencia agencia) {
			String update = "update Agencias set cnpj=?, endereco=?, telefone=?, email=? where idAgencia=?";
			try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, agencia.getCnpj());
				pst.setString(2, agencia.getEndereco());
				pst.setString(3, agencia.getTelefone());
				pst.setString(4, agencia.getEmail());
				pst.setString(5, String.valueOf(agencia.getIdAgencia()));
				pst.executeUpdate();
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	
	/**
	 *  CRUD DELETE *.
	 *
	 * @param cliente the cliente
	 */
	public void deletarCliente(Cliente cliente) {
		String delete = "delete from Clientes where idCliente=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, String.valueOf(cliente.getIdCliente()));
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Deletar destino.
	 *
	 * @param destino the destino
	 */
	public void deletarDestino(Destino destino) {
		String delete = "delete from Destinos where idDestino=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, String.valueOf(destino.getIdDestino()));
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Deletar agencia.
	 *
	 * @param agencia the agencia
	 */
	public void deletarAgencia(Agencia agencia) {
		String delete = "delete from Agencias where idAgencia=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, String.valueOf(agencia.getIdAgencia()));
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
