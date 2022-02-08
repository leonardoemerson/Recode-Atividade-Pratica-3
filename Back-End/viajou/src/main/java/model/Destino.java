package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Destino.
 */
public class Destino {
    
    /** The id destino. */
    private int idDestino;
    
    /** The endereco. */
    private String endereco;
    
    /** The nome. */
    private String nome;
    
    /** The preco. */
    private double preco;
    
    /** The qtd vagas. */
    private int qtdVagas;
    
	/**
	 * Instantiates a new destino.
	 */
	public Destino() {
		super();
	}
	
	/**
	 * Instantiates a new destino.
	 *
	 * @param idDestino the id destino
	 * @param endereco the endereco
	 * @param nome the nome
	 * @param preco the preco
	 * @param qtdVagas the qtd vagas
	 */
	public Destino(int idDestino, String endereco, String nome, double preco, int qtdVagas) {
		super();
		this.idDestino = idDestino;
		this.endereco = endereco;
		this.nome = nome;
		this.preco = preco;
		this.qtdVagas = qtdVagas;
	}

	/**
	 * Gets the id destino.
	 *
	 * @return the id destino
	 */
	public int getIdDestino() {
		return idDestino;
	}
	
	/**
	 * Sets the id destino.
	 *
	 * @param idDestino the new id destino
	 */
	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
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
	 * Gets the preco.
	 *
	 * @return the preco
	 */
	public double getPreco() {
		return preco;
	}
	
	/**
	 * Sets the preco.
	 *
	 * @param preco the new preco
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	/**
	 * Gets the qtd vagas.
	 *
	 * @return the qtd vagas
	 */
	public int getQtdVagas() {
		return qtdVagas;
	}
	
	/**
	 * Sets the qtd vagas.
	 *
	 * @param qtdVagas the new qtd vagas
	 */
	public void setQtdVagas(int qtdVagas) {
		this.qtdVagas = qtdVagas;
	}
    
}
