package udemy.curso.services;

import org.springframework.stereotype.Service;
import udemy.curso.model.Cliente;
import udemy.curso.repository.ClienteRepository;

@Service
public class ClienteServices {
	
	private ClienteRepository repository;
	
	public ClienteServices(ClienteRepository repository) {
		this.repository = repository;
	}

	public void salvarCliente(Cliente cliente) {
		validarCliente(cliente);
		repository.persistir(cliente);
	}
	
	public void validarCliente(Cliente cliente) {
		
	}
}
