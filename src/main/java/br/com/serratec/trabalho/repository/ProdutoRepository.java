package br.com.serratec.trabalho.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.trabalho.model.Cliente;
import br.com.serratec.trabalho.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	Optional<Produto> findById(Long id);
	Optional<Cliente> findById(String nome);
}
