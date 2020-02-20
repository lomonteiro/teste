package br.com.lomonteiro.teste.error;


public class RequestValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RequestValidationException(String info) {
        super(info);
    }

}
