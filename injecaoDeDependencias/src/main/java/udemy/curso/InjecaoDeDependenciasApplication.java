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
			
			System.out.println("Salvandor clientes");
			clientes.salvar(new Cliente("Marcos"));
			clientes.salvar(new Cliente("Pedro"));
			clientes.salvar(new Cliente("LucasCliente"));
			
			List<Cliente> todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);
			System.out.println();
			
			System.out.println("atualizando clientes....");
			todosClientes.forEach(c -> {
				c.setNome(c.getNome() + " atualizado.");
				clientes.atualizar(c);
			});
			
			System.out.println("Obtendo clientes atualizados.");
			todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);
			System.out.println();
			
			System.out.println("Buscando clientes");
			clientes.buscarPorNome("Cli").forEach(System.out::println);;
			
			System.out.println("deletando clientes.");
			
			clientes.obterTodos().forEach(c -> {
				clientes.deletar(c.getId());
			});
			
			todosClientes = clientes.obterTodos();
			if(todosClientes.isEmpty()) {
				System.out.println("nenhum cliente encontrado.");
			}else {
				todosClientes.forEach(System.out::println);
			}
			
			System.out.println();
			
			System.out.println("Obtendo todos os clientes.");
			todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(InjecaoDeDependenciasApplication.class, args);
	}

}
