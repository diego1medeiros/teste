package br.com.cadastro.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.dao.EnderecoDao;
import br.com.cadastro.dto.EnderecoDto;
import br.com.cadastro.entity.Endereco;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoDao enderecoDao;

	@Autowired
	private ModelMapper modelMapper;

	public EnderecoDto cadastrarEndereco(EnderecoDto dto) {
		Endereco endereco = modelMapper.map(dto, Endereco.class);
		enderecoDao.cadastrarEndereco(endereco);
		return modelMapper.map(endereco, EnderecoDto.class);
	}

/*	public List<ClienteDto> listarCliente() {
		List<Cliente> clientes = cliente.findAll();
		return clientes.stream().map(cliente -> modelMapper.map(cliente, ClienteDto.class))
				.collect(Collectors.toList());
	}

	public void excluirEmpresa(Long id) {
		//empresaRepository.deleteById(id);
	}

	public EmpresaDto atualizarCliente(ClienteDto dto) {
		Cliente cliente = modelMapper.map(dto, Cliente.class);
		cliente.setId(dto.getId());
		cliente = empresaRepository.save(cliente);
		return modelMapper.map(cliente, ClienteDto.class);

	}

	public ClienteDto buscarClientes(Long id) {
		Cliente cliente = empresaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		return modelMapper.map(cliente, ClienteDto.class);

	}

	public List<EmpresaDto> listarEmpresasComUsuariosLogado(Long id) {
		List<Empresa> empresas = empresaRepository.findByFuncionarioId(id);
		return empresas.stream().map(empresa -> modelMapper.map(empresa, EmpresaDto.class))
				.collect(Collectors.toList());*/
	}


