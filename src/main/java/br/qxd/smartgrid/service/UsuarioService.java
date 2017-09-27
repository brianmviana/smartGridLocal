package br.qxd.smartgrid.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.qxd.smartgrid.model.Usuario;
import br.qxd.smartgrid.repository.UsuarioRepository;

@Transactional
@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public Usuario findByLogin(String login) {
		return repository.findByLogin(login);
	}

	@Override
	public List<Usuario> findAll() {
		return repository.findAll();
	}

	@Override
	public Usuario findOne(long id) {
		return repository.findOne(id);
	}

	@Override
	public Usuario update(Usuario usuario) {
		return repository.save(usuario);
	}

	@Override
	public void delete(long id) {
		repository.delete(id);;
	}

	@Override
	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}
	
}
