package udemy.curso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import udemy.curso.model.Cliente;
import udemy.curso.repository.ClientesRepository;

@SpringBootApplication
public class InjecaoDeDependenciasApplication {
	
	@Bean
	public CommandLineRunner init(@Autowired ClientesRepository clientes) {
		return args -> {
			
			clientes.salvar(new Cliente("Marcos"));
			clientes.salvar(new Cliente("Pedro"));
			clientes.salvar(new Cliente("Lucas"));
			
			List<Cliente> todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(InjecaoDeDependenciasApplication.class, args);
	}

}
