package com.comercial.socialboocks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comercial.socialboocks.domain.Autor;

public interface IAutoresRepository extends JpaRepository<Autor, Long> {

}
