package com.cinema.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.Model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{
}
