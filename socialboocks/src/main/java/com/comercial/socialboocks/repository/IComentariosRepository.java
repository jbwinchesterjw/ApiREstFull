package com.comercial.socialboocks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comercial.socialboocks.domain.Comentario;

public interface IComentariosRepository extends JpaRepository<Comentario, Long> {

}
