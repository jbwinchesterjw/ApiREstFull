package com.comercial.socialboocks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.socialboocks.domain.Autor;
import com.comercial.socialboocks.repository.IAutoresRepository;
import com.comercial.socialboocks.services.exceptions.AutorExistenteException;
import com.comercial.socialboocks.services.exceptions.AutorNaoEncontradoException;


@Service
public class AutoresService {

	@Autowired
	private IAutoresRepository autoresRepository;
	
	public List<Autor> listar() {
		return autoresRepository.findAll();
	}	
	
	public Autor salvar(Autor autor) {
		if(autor.getId() != null) {
			Optional<Autor> a = autoresRepository.findById(autor.getId());
			
			if(a != null) {
				throw new AutorExistenteException("O autor já existe.");
			}
		}
		return autoresRepository.save(autor);
	}
	
	public Optional<Autor> buscar(Long id) {
		Optional<Autor> autor = autoresRepository.findById(id);
		
		if(autor == null) {
			throw new AutorNaoEncontradoException("O autor não pôde ser encontrado.");
		}
		return autor;
	}
}