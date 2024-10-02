package udemy.curso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import udemy.curso.model.Cliente;
import udemy.curso.repository.ClienteRepository;

@SpringBootApplication
public class InjecaoDeDependenciasApplication {
	
	@Bean
	public CommandLineRunner init(@Autowired ClienteRepository cliente) {
		return args -> {
			
			System.out.println("Salvandor clientes");
			cliente.save(new Cliente("Marcos"));
			cliente.save(new Cliente("Pedro"));
			cliente.save(new Cliente("LucasCliente"));
			
			List<Cliente> todosClientes = cliente.findAll();
			todosClientes.forEach(System.out::println);
			System.out.println();
			
			System.out.println("atualizando clientes....");
			todosClientes.forEach(c -> {
				c.setNome(c.getNome() + " atualizado.");
				cliente.save(c);
			});
			
			System.out.println("Obtendo clientes atualizados.");
			todosClientes = cliente.findAll();
			todosClientes.forEach(System.out::println);
			System.out.println();
			
			System.out.println("Buscando clientes");
			cliente.findByNameLike("Cli").forEach(System.out::println);;
			
			System.out.println("deletando clientes.");
			
			cliente.findAll().forEach(c -> {
				cliente.deleteById(c.getId());
			});
			
			todosClientes = cliente.findAll();
			if(todosClientes.isEmpty()) {
				System.out.println("nenhum cliente encontrado.");
			}else {
				todosClientes.forEach(System.out::println);
			}
			
			System.out.println();
			
			System.out.println("Obtendo todos os clientes.");
			todosClientes = cliente.findAll();
			todosClientes.forEach(System.out::println);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(InjecaoDeDependenciasApplication.class, args);
	}

}
