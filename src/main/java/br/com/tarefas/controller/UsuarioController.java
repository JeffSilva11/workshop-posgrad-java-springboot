package br.com.tarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tarefas.controller.assembler.UsuarioModelAssembler;
import br.com.tarefas.controller.response.UsuarioResponse;
import br.com.tarefas.model.Usuario;
import br.com.tarefas.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioModelAssembler assembler;
	
	@GetMapping("/{id}")
	public EntityModel<UsuarioResponse> umUsuario(@PathVariable Integer id) {
		Usuario usuario = usuarioService.getUsuarioPorId(id);
		EntityModel<UsuarioResponse> usuarioResponse = assembler.toModel(usuario);
		return usuarioResponse;
	}
	
}
