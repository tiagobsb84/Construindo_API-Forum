package br.com.tiago.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiago.forum.dtos.TopicoDTO;
import br.com.tiago.forum.models.Curso;
import br.com.tiago.forum.models.Topico;

@RestController
public class TopicoController {

	@RequestMapping("/topicos")
	public List<TopicoDTO> listaTopico(){
		Topico topico = new Topico("dúvida", "dúvida com Spring", new Curso("Spring Boot", "BackEnd"));
		return TopicoDTO.converter(Arrays.asList(topico, topico, topico));
	}
	
}
