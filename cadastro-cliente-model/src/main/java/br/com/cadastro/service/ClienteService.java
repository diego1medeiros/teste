package br.com.cadastro.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.dao.ClienteDao;
import br.com.cadastro.dto.ClienteDto;
import br.com.cadastro.entity.Cliente;

@Service
public class ClienteService {

	@Autowired
	private ClienteDao clienteDao;

	@Autowired
	private ModelMapper modelMapper;

	public ClienteDto cadastrarCliente(ClienteDto dto) {
		Cliente cliente = modelMapper.map(dto, Cliente.class);
		clienteDao.cadastrarCliente(cliente);
		return modelMapper.map(cliente, ClienteDto.class);
	}

	public List<ClienteDto> listarCliente() {
		List<Cliente> clientes = clienteDao.listaDadosDosClientes();
		return clientes.stream().map(cliente -> modelMapper.map(cliente, ClienteDto.class))
				.collect(Collectors.toList());
	}

	/*public void excluirEmpresa(Long id) {
		empresaRepository.deleteById(id);
	}

	public ClienteDto atualizarCliente(ClienteDto dto) {
		Cliente cliente = modelMapper.map(dto, Cliente.class);
		cliente.setId(dto.getId());
		clienteDao.cadastrarCliente(cliente);
		return modelMapper.map(cliente, ClienteDto.class);

	}

	public ClienteDto buscarClientes(Long id) {
		Cliente cliente = empresaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		return modelMapper.map(cliente, ClienteDto.class);

	}

	public List<ClienteDto> listarEmpresasComUsuariosLogado(Long id) {
		List<Cliente> empresas = empresaRepository.findByFuncionarioId(id);
		return empresas.stream().map(empresa -> modelMapper.map(empresa, ClienteDto.class))
				.collect(Collectors.toList());*/
	}


