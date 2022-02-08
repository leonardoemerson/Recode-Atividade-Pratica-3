package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Cliente.
 */
public class Cliente {
    
    /** The id cliente. */
    private int idCliente;
    
    /** The nome. */
    private String nome;
    
    /** The cpf. */
    private String cpf;
    
    /** The rg. */
    private String rg;
    
    /** The endereco. */
    private String endereco;
    
	/**
	 * Instantiates a new cliente.
	 */
	public Cliente() {
		super();
	}
	
	/**
	 * Instantiates a new cliente.
	 *
	 * @param idCliente the id cliente
	 * @param nome the nome
	 * @param cpf the cpf
	 * @param rg the rg
	 * @param endereco the endereco
	 */
	public Cliente(int idCliente, String nome, String cpf, String rg, String endereco) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
	}

	/**
	 * Gets the id cliente.
	 *
	 * @return the id cliente
	 */
	public int getIdCliente() {
		return idCliente;
	}
	
	/**
	 * Sets the id cliente.
	 *
	 * @param idCliente the new id cliente
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Gets the cpf.
	 *
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	
	/**
	 * Sets the cpf.
	 *
	 * @param cpf the new cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	/**
	 * Gets the rg.
	 *
	 * @return the rg
	 */
	public String getRg() {
		return rg;
	}
	
	/**
	 * Sets the rg.
	 *
	 * @param rg the new rg
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	/**
	 * Gets the endereco.
	 *
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}
	
	/**
	 * Sets the endereco.
	 *
	 * @param endereco the new endereco
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
    
}
