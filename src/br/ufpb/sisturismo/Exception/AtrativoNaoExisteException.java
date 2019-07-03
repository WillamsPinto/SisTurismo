package br.ufpb.sisturismo.Exception;

public class AtrativoNaoExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1832223249447220781L;

	public AtrativoNaoExisteException() {
		super();
	}

	public AtrativoNaoExisteException(String msgErro) {
		super(msgErro);
	}
}