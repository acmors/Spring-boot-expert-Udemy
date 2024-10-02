package udemy.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import udemy.curso.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	List<Cliente> findByNameLike(String nome);

}
