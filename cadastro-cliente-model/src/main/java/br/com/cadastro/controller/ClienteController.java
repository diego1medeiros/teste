package br.com.cadastro.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cadastro.dto.ClienteDto;
import br.com.cadastro.service.ClienteService;

@RestController
@RequestMapping("cliente/cadastro")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<ClienteDto> cadastrarCliente(@RequestBody ClienteDto dto,
			UriComponentsBuilder uriComponentsBuilder) {
		ClienteDto clienteDto = clienteService.cadastrarCliente(dto);
		URI uri = uriComponentsBuilder.path("/listarcliente/{id}").buildAndExpand(clienteDto.getId()).toUri();
		return ResponseEntity.created(uri).body(clienteDto);
	}
	
	/*@GetMapping
	public ResponseEntity<List<EmpresaDto>> listarClientes() {
		return ResponseEntity.ok(empresaService.listarEmpresas());
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<EmpresaDto> excluir(@PathVariable Long id) {
		empresaService.excluirEmpresa(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping
	public ResponseEntity<?> atualizar(@RequestBody EmpresaDto dto) {
		EmpresaDto atualizado = empresaService.atualizarEmpresa(dto);
		return ResponseEntity.ok(atualizado);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarEmpresas(@PathVariable Long id) {
		EmpresaDto empresaDados = empresaService.buscarEmpresas(id);
		return ResponseEntity.ok(empresaDados);
	}
	
	@GetMapping("buscar/{id}")
	public ResponseEntity<List<EmpresaDto>> listarEmpresasComUsuariosLogado(@PathVariable Long id) {
		return ResponseEntity.ok(empresaService.listarEmpresasComUsuariosLogado(id));
	}
	*/
}
