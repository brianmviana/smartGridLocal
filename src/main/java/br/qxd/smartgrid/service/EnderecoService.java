package br.qxd.smartgrid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.qxd.smartgrid.model.Endereco_usuario;
import br.qxd.smartgrid.model.Usuario;
import br.qxd.smartgrid.repository.Endereco_usuarioRepository;

@Service
public class EnderecoService {
	@Autowired
	private Endereco_usuarioRepository endRepo;

	public <S extends Endereco_usuario> S save(S end) {
		S result = endRepo.save(end);
		return result;
	}

	public List<Endereco_usuario> findAll() {
		List<Endereco_usuario> result = endRepo.findAll();
		return result;
	}

	public void flush() {
		endRepo.flush();
	}

	public Endereco_usuario getOne(Long arg0) {
		Endereco_usuario usr = endRepo.getOne(arg0);
		return usr;
	}

	public <S extends Endereco_usuario> List<S> save(Iterable<S> arg0) {
		List<S> result = endRepo.save(arg0);
		return result;
	}

	public <S extends Endereco_usuario> S saveAndFlush(S arg0) {
		S result = endRepo.saveAndFlush(arg0);
		return result;
	}

	public long count() {
		return endRepo.count();
	}

	public void delete(Long arg0) {
		endRepo.delete(arg0);
	}

	public boolean exists(Long arg0) {
		return endRepo.exists(arg0);
	}

	public Endereco_usuario findOne(Long arg0) {
		return endRepo.findOne(arg0);
	}
}
