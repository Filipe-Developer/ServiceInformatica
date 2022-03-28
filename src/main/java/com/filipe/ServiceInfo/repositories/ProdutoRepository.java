package com.filipe.ServiceInfo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filipe.ServiceInfo.dominian.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
