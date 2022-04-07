package com.cinema.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_convidados_filme")
public class Convidado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_convidado;
	
	@NotNull
	private String nome_convidado;
	
	@NotNull
	private String rg_convidado;
	
	@ManyToOne
	@JoinColumn(name = "id_convidado_filme")
	private Filme filme;
	
	
	public long getId_convidado() {
		return id_convidado;
	}
	public void setId_convidado(long id_convidado) {
		this.id_convidado = id_convidado;
	}
	public String getNome_convidado() {
		return nome_convidado;
	}
	public void setNome_convidado(String nome_convidado) {
		this.nome_convidado = nome_convidado;
	}
	public String getRg_convidado() {
		return rg_convidado;
	}
	public void setRg_convidado(String rg_convidado) {
		this.rg_convidado = rg_convidado;
	}
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
	
}
