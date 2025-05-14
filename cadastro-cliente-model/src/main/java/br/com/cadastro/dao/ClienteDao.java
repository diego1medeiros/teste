package br.com.cadastro.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import br.com.cadastro.entity.Cliente;

@Repository
public class ClienteDao {

	@PersistenceContext
	private EntityManager manager;

	public ClienteDao() {
		super();
	}

	//salvar os clientes no banco de dados
	@Transactional
	public Cliente cadastrarCliente(Cliente cliente) {	
		manager.persist(cliente);
		return cliente;
	}

	//listar os clientes do banco de dados
	@Transactional
	public List<Cliente> listaDadosDosClientes() {
		List<Cliente> listaClientes = null;
		listaClientes = manager.createQuery("select c from Cliente c", Cliente.class).getResultList();
		return listaClientes;
	}
	
	//Remover os clientes do banco de dados
	@Transactional
	public Cliente removerCliente(Cliente cliente) {
		cliente = manager.merge(cliente);
		manager.remove(cliente);
		return cliente;
	}
	
	//Editar os clientes do banco de dados
	@Transactional
	public Cliente editarCliente(Cliente cliente) {
		manager.merge(cliente);
		return cliente;
	}
	
	//buscar cliente pelo id
	@Transactional
	public Cliente buscarClientesPorId(Long id) {
		Cliente cliente = manager.find(Cliente.class, id);
		return cliente ;

	}
}
