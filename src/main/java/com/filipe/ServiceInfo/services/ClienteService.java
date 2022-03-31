package com.filipe.ServiceInfo.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.ServiceInfo.controllers.exceptions.ViolationException;
import com.filipe.ServiceInfo.dominian.Cliente;
import com.filipe.ServiceInfo.dtos.ClienteDTO;
import com.filipe.ServiceInfo.repositories.ClienteRepository;
import com.filipe.ServiceInfo.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	// Metodo para tratamento de cliente não encontrado
	public Cliente findById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto Não Encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	// Metodo para tratamento de duplicação de telefone
	public Cliente create(ClienteDTO objDTO) {
		if (findByFone(objDTO) != null) {
			throw new ViolationException("Telefone Já Cadastrado!");
		}

		return repository.save(new Cliente(null, objDTO.getNome(), objDTO.getEndereco(), objDTO.getFone()));
	}

	public Cliente update(Long id, @Valid ClienteDTO objDTO) {
		Cliente oldObj = findById(id);

		if (findByFone(objDTO) != null && findByFone(objDTO).getId() != id) {
			throw new ViolationException("Telefone Já Cadastrado!");
		}

		oldObj.setNome(objDTO.getNome());
		oldObj.setEndereco(objDTO.getEndereco());
		oldObj.setFone(objDTO.getFone());
		return repository.save(oldObj);
	}

	public void delete(Long id) {
		Cliente obj = findById(id);
		if(obj.getList().size() > 0) {
			throw new ViolationException("Ordem de serviçoas associadas ao cliente!");
		}
		repository.deleteById(id);
	}

	private Cliente findByFone(ClienteDTO objDTO) {
		Cliente obj = repository.findByFone(objDTO.getFone());

		if (obj != null) {
			return obj;
		}
		return null;
	}

}
