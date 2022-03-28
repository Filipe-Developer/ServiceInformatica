package com.filipe.ServiceInfo.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.ServiceInfo.dominian.Cliente;
import com.filipe.ServiceInfo.dominian.OS;
import com.filipe.ServiceInfo.dominian.Produto;
import com.filipe.ServiceInfo.dominian.Vendas;
import com.filipe.ServiceInfo.dominian.enuns.Prioridade;
import com.filipe.ServiceInfo.dominian.enuns.Status;
import com.filipe.ServiceInfo.repositories.ClienteRepository;
import com.filipe.ServiceInfo.repositories.OSRespository;
import com.filipe.ServiceInfo.repositories.ProdutoRepository;
import com.filipe.ServiceInfo.repositories.VendasRepository;

@Service
public class DbService {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OSRespository osRespository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private VendasRepository vendasRepository;

	public void instanciaDB() {
		Cliente c1 = new Cliente(null, "Filipe Pereira da Silva", "Fazenda Trairinha", "(38) 99908-8972");
		OS os1 = new OS(null, Prioridade.ALTA, Status.ABERTO, "Conserto Celular Não liga", c1);
		Produto p1 = new Produto(null, "HD 500 GB", 300.00);
		Vendas v1 = new Vendas(null, p1, 50.50, "mané Cuanga");

		Cliente c2 = new Cliente(null, "Fulando de Tal", "Baxa da égua", "(00) 94563-8972");
		OS os2 = new OS(null, Prioridade.BAIXA, Status.PRONTO, "Ficou novo", c2);
		Produto p2 = new Produto(null, "Carregador Turbo power", 30.90);
		Vendas v2 = new Vendas(null, p2, 150.50, "Beltrano");

		c1.getList().add(os1);
		p1.getList().add(v1);
		
		c2.getList().add(os2);
		p2.getList().add(v2);

		clienteRepository.saveAll(Arrays.asList(c1));
		osRespository.saveAll(Arrays.asList(os1));
		produtoRepository.saveAll(Arrays.asList(p1));
		vendasRepository.saveAll(Arrays.asList(v1));

		clienteRepository.saveAll(Arrays.asList(c2));
		osRespository.saveAll(Arrays.asList(os2));
		produtoRepository.saveAll(Arrays.asList(p2));
		vendasRepository.saveAll(Arrays.asList(v2));
	}
}
