package br.com.serratec.trabalho.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.trabalho.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	Optional<Cliente> findById(Long id);
	Optional<Cliente> findById(String nome);
}
