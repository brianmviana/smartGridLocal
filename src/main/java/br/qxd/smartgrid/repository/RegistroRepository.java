package br.qxd.smartgrid.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.qxd.smartgrid.model.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Long>{
	
	@Query("SELECT r FROM Registro r WHERE r.data BETWEEN :startDate AND :endDate")
	public List<Registro> findByDataBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate) ;
	
}
