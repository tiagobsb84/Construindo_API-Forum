package br.com.tiago.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tiago.forum.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nome);

}
