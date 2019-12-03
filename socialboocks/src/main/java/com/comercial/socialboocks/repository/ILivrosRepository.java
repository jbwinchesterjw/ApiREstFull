package com.comercial.socialboocks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comercial.socialboocks.domain.Livro;

public interface ILivrosRepository extends JpaRepository<Livro, Long>{

}
