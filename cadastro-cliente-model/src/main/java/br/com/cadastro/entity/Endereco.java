package br.com.cadastro.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "endereco")
public class Endereco {
	
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private String numero;
	private String cep;
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente = new Cliente();

}
