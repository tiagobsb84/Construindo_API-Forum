package br.com.tiago.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.tiago.forum.models.Curso;
import br.com.tiago.forum.models.Topico;
import br.com.tiago.forum.repository.CursoRepository;

public class TopicoForm {

	@NotNull @NotEmpty @Length(min = 2)
	private String titulo;
	
	@NotNull @NotEmpty @Length(min = 3)
	private String mensagem;
	
	@NotNull @NotEmpty
	private String nomeCurso;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	public Topico converter(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(nomeCurso);
		return new Topico(titulo, mensagem, curso);
	}
}
