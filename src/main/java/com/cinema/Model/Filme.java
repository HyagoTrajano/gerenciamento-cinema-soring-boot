package com.cinema.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_filme")
public class Filme implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Nome do filme é obrigatoria")
    private String nome;
    
    @NotNull(message = "Idade indicativa é obrigatória")
    private String idade_indicativa;
    
    @NotNull(message = "Data é obrigatorio")
    private String data;
    
    @NotNull(message = "Sala da sessão é obrigatório")
    private String sessao;
    
    @NotNull(message = "Hora do filme é obrigatória")
    private String hora;

    @OneToMany
	@JoinColumn(name = "id_convidado_filme")
    private List<Convidado>convidado;

    
    /**
     * @return long return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return String return the idade_indicativa
     */
    public String getIdade_indicativa() {
        return idade_indicativa;
    }

    /**
     * @param idade_indicativa the idade_indicativa to set
     */
    public void setIdade_indicativa(String idade_indicativa) {
        this.idade_indicativa = idade_indicativa;
    }

    /**
     * @return String return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return String return the sessao
     */
    public String getSessao() {
        return sessao;
    }

    /**
     * @param sessao the sessao to set
     */
    public void setSessao(String sessao) {
        this.sessao = sessao;
    }

    /**
     * @return String return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

	public List<Convidado> getConvidado() {
		return convidado;
	}

	public void setConvidado(List<Convidado> convidado) {
		this.convidado = convidado;
	}

    

}
