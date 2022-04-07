package com.cinema.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.Model.Convidado;
import com.cinema.Model.Filme;

public interface ConvidadoRepository extends JpaRepository<Convidado, Long>{
	Iterable<Convidado> findByFilme(Filme filme);

}
