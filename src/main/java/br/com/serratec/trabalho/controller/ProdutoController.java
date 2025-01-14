package br.com.serratec.trabalho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.trabalho.model.Produto;
import br.com.serratec.trabalho.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {


    @Autowired
    private ProdutoRepository _repositorioProduto;

    @GetMapping
    public ResponseEntity<Produto> obterTodos(@RequestBody Produto produto){

        var obter = this._repositorioProduto.findAll(produto);

        return new ResponseEntity<>(obter, HttpStatus.OK);
    }
	
   @PostMapping
	public ResponseEntity<Produto> adicionar(@RequestBody Produto produto) {

        var adicionado = this._repositorioProduto.save(produto);

        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
		
	}

    @DeleteMapping("/{id}")
	public ResponseEntity<Optional<Produto>> deletar(@PathVariable(value = "id") Long id) {
		try {
			
		var deletado = this._repositorioProduto.deleteById(id);
		
		return new ResponseEntity<Optional<Produto>>(deletado, HttpStatus.OK);
		
		} catch (ProdutoNaoEncontratoException e) {
			
			System.out.println(e.getMessage()); 
			
			return new ResponseEntity<Optional<Produto>>(HttpStatus.NOT_FOUND);
		}
	}

     @GetMapping("/{id}")
     public ResponseEntity<Optional<Produto>> obter(@PathVariable(value = "id") Integer id){
 		
    	 try { 
    		   var encontrado = _repositorioProduto.findById(id);
    		   
    		    return new ResponseEntity<Optional<Produto>>(encontrado, HttpStatus.OK);
    		    
    	 } catch (ProdutoNaoEncontradoException e) {
    		 
    		 System.out.println(e.getMessage());
    		 
    		 return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    	 }
 
    }
     
}

