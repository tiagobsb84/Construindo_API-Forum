package br.com.tiago.forum.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.tiago.forum.controller.form.TopicoForm;
import br.com.tiago.forum.dtos.TopicoDTO;
import br.com.tiago.forum.models.Topico;
import br.com.tiago.forum.repository.CursoRepository;
import br.com.tiago.forum.repository.TopicoRepository;

@RestController
@RequestMapping(value = "/Topicos")
public class TopicoController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;

	@GetMapping
	public List<TopicoDTO> listaTopico(String nomeCurso){
		if(nomeCurso == null) {
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDTO.converter(topicos);						
		} else {
			List<Topico> topicos = topicoRepository.findByCurso_Nome(nomeCurso);
			return TopicoDTO.converter(topicos);
		}
	}
	
	@PostMapping
	public ResponseEntity<TopicoDTO> cadastrar(@RequestBody TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDTO(topico));
	}
	
	
	
}
