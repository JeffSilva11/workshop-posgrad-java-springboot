package br.com.tarefas.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.model.Usuario;
import br.com.tarefas.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepositorio;

	public Usuario getUsuarioPorId(Integer id) {
		return usuarioRepositorio.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}
	
}
