package com.filipe.ServiceInfo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.filipe.ServiceInfo.dominian.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	
	
	@Query("SELECT obj FROM Cliente obj WHERE obj.fone =:fone")
	Cliente findByFone(@Param("fone") String fone);

}
