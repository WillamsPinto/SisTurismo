package br.ufpb.sisturismo.Exception;

public class MunicipiosNaoExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1832223249447220781L;

	public MunicipiosNaoExisteException() {
		super();
	}

	public MunicipiosNaoExisteException(String msgErro) {
		super(msgErro);
	}
}
