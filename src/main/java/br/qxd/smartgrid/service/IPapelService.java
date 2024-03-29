package br.qxd.smartgrid.service;

import java.util.List;

import br.qxd.smartgrid.model.Usuario_papel;

public interface IPapelService {
	
	public Usuario_papel save(Usuario_papel usuario_papel);

	public List<Usuario_papel> findAll();

	public Usuario_papel findOne(long id);

	public Usuario_papel update(Usuario_papel usuario_papel);

	public void delete(long id);
}
