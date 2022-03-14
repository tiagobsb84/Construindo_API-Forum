package br.com.tiago.forum.config.validacao;

public class ErroDeFormularioDTO {

	private String mensagem;
	private String erro;
	
	public ErroDeFormularioDTO(String mensagem, String erro) {
		this.mensagem = mensagem;
		this.erro = erro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getErro() {
		return erro;
	}
	
}
