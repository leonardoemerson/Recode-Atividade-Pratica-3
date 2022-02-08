package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Agencia.
 */
public class Agencia {
	
	/** The id agencia. */
	private int idAgencia;
    
    /** The cnpj. */
    private String cnpj;
    
    /** The endereco. */
    private String endereco;
    
    /** The telefone. */
    private String telefone;
    
    /** The email. */
    private String email;
    
	/**
	 * Instantiates a new agencia.
	 */
	public Agencia() {
		super();
	}
	
	/**
	 * Instantiates a new agencia.
	 *
	 * @param idAgencia the id agencia
	 * @param cnpj the cnpj
	 * @param endereco the endereco
	 * @param telefone the telefone
	 * @param email the email
	 */
	public Agencia(int idAgencia, String cnpj, String endereco, String telefone, String email) {
		super();
		this.idAgencia = idAgencia;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}

	/**
	 * Gets the id agencia.
	 *
	 * @return the id agencia
	 */
	public int getIdAgencia() {
		return idAgencia;
	}
	
	/**
	 * Sets the id agencia.
	 *
	 * @param idAgencia the new id agencia
	 */
	public void setIdAgencia(int idAgencia) {
		this.idAgencia = idAgencia;
	}
	
	/**
	 * Gets the cnpj.
	 *
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}
	
	/**
	 * Sets the cnpj.
	 *
	 * @param cnpj the new cnpj
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
	
	/**
	 * Gets the telefone.
	 *
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}
	
	/**
	 * Sets the telefone.
	 *
	 * @param telefone the new telefone
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
    
}
