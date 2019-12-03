package com.comercial.socialboocks.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.comercial.socialboocks.domain.Comentario;
import com.comercial.socialboocks.domain.Livro;
import com.comercial.socialboocks.repository.IComentariosRepository;
import com.comercial.socialboocks.repository.ILivrosRepository;
import com.comercial.socialboocks.services.exceptions.LivroNaoEncontradoException;


@Service
public class LivrosService {

	@Autowired
	private ILivrosRepository livrosRepository;
	
	@Autowired
	private IComentariosRepository comentariosRepository;
	
	public List<Livro> listar() {
		return livrosRepository.findAll();
	}
	
	public Livro buscar(Long id) {
		Livro livro = livrosRepository.getOne(id);
		
		if(livro == null) {
			throw new LivroNaoEncontradoException("O livro não pôde ser encontrado.");
		}
		
		return livro;
	}
	
	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livrosRepository.save(livro);
	}
	
	public void deletar(Long id) {
		try {
			livrosRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("O livro não pôde ser encontrado.");
		}
	}
	
	public void atualizar(Livro livro) {
		verificarExistencia(livro);
		livrosRepository.save(livro);
	}
	
	private void verificarExistencia(Livro livro) {
		buscar(livro.getId());
	}
	
	public Comentario salvarComentario(Long livroId, Comentario comentario) {
		Livro livro = buscar(livroId);
		
		comentario.setLivro(livro);
		comentario.setData(new Date());
		
		return comentariosRepository.save(comentario);
	}
	
	public List<Comentario> listarComentarios(Long livroId) {
		Livro livro = buscar(livroId);
		
		return livro.getComentarios();
	}
	
}
