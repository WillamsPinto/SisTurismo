package br.ufpb.sisturismo.Exception;

public class AtrativoJaExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	

	public AtrativoJaExisteException() {
		super();
	}

	public AtrativoJaExisteException(String msgErro) {
		super(msgErro);
	}
}