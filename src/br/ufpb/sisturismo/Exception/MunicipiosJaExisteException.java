package br.ufpb.sisturismo.Exception;

public class MunicipiosJaExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MunicipiosJaExisteException() {
		super();
	}

	public MunicipiosJaExisteException(String msgErro) {
		super(msgErro);
	}
}
