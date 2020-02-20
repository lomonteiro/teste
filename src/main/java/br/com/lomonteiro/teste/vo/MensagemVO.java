package br.com.lomonteiro.teste.vo;

public class MensagemVO {
	
	private String msg;
	private Object retorno;
	
	public MensagemVO() {
		super();
	}
	
	public MensagemVO(String msg, Object retorno) {
		super();
		this.msg = msg;
		this.retorno = retorno;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String texto) {
		this.msg = texto;
	}

	public Object getRetorno() {
		return retorno;
	}

	public void setRetorno(Object retorno) {
		this.retorno = retorno;
	}
	
}
