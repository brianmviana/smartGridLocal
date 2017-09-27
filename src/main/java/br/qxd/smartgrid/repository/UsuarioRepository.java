package br.qxd.smartgrid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.qxd.smartgrid.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query("SELECT us FROM Usuario us WHERE us.login =:login")
	public Usuario findByLogin(@Param("login") String login);
	
}
