package br.qxd.smartgrid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.qxd.smartgrid.model.Usuario;
import br.qxd.smartgrid.model.Usuario_papel;

@Repository
public interface PapelRepository extends JpaRepository<Usuario_papel, Long>{
	
}
