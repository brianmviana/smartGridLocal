package br.qxd.smartgrid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.qxd.smartgrid.model.Registro;
import br.qxd.smartgrid.model.Usuario;
import br.qxd.smartgrid.repository.RegistroRepository;

@Service
public class RegistroService {
	
	@Autowired
	private RegistroRepository regRepo;

	public <S extends Registro> S save(S reg) {
		S result = regRepo.save(reg);
		return result;
	}

	public List<Registro> findAll() {
		List<Registro> result = regRepo.findAll();
		return result;
	}

	public void flush() {
		regRepo.flush();
	}

	public Registro getOne(Long arg0) {
		Registro usr = regRepo.getOne(arg0);
		return usr;
	}

	public <S extends Registro> List<S> save(Iterable<S> arg0) {
		List<S> result = regRepo.save(arg0);
		return result;
	}

	public <S extends Registro> S saveAndFlush(S arg0) {
		S result = regRepo.saveAndFlush(arg0);
		return result;
	}

	public long count() {
		return regRepo.count();
	}

	public void delete(Long arg0) {
		regRepo.delete(arg0);
	}

	public boolean exists(Long arg0) {
		return regRepo.exists(arg0);
	}

	public Registro findOne(Long arg0) {
		return regRepo.findOne(arg0);
	}


}
