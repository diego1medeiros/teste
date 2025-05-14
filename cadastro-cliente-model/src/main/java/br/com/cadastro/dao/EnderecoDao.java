package br.com.cadastro.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import br.com.cadastro.entity.Cliente;
import br.com.cadastro.entity.Endereco;

@Repository
public class EnderecoDao {

	@PersistenceContext
	private EntityManager manager;

	public EnderecoDao() {
		super();
	}

	//salvar os clientes no banco de dados
	@Transactional
	public Endereco cadastrarEndereco(Endereco endereco) {	
		manager.persist(endereco);
		return endereco;
	}

	//listar os clientes do banco de dados
	@Transactional
	public List<Endereco> listaDadosDosEnderecos() {
		List<Endereco> listaEnderecos = null;
		listaEnderecos = manager.createQuery("select c from Cliente c", Endereco.class).getResultList();
		return listaEnderecos;
	}
	
	//Remover os clientes do banco de dados
	@Transactional
	public Endereco removerEndereco(Endereco endereco) {
		endereco = manager.merge(endereco);
		manager.remove(endereco);
		return endereco;
	}
	
	//Editar os clientes do banco de dados
	@Transactional
	public Endereco editarEndereco(Endereco endereco) {
		manager.merge(endereco);
		return endereco;
	}
	
	//buscar cliente pelo id
	@Transactional
	public Endereco buscarEnderecosPorId(Long id) {
		Endereco endereco = manager.find(Endereco.class, id);
		return endereco ;

	}
}
