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
import br.com.cadastro.dto.EnderecoDto;
import br.com.cadastro.service.ClienteService;
import br.com.cadastro.service.EnderecoService;

@RestController
@RequestMapping("endereco/cadastro")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@PostMapping
	public ResponseEntity<EnderecoDto> cadastrarEndereco(@RequestBody EnderecoDto dto,
			UriComponentsBuilder uriComponentsBuilder) {
		EnderecoDto enderecoDto = enderecoService.cadastrarEndereco(dto);
		URI uri = uriComponentsBuilder.path("/listarendereco/{id}").buildAndExpand(enderecoDto.getId()).toUri();
		return ResponseEntity.created(uri).body(enderecoDto);
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
