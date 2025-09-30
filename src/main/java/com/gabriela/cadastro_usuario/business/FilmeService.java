package com.gabriela.cadastro_usuario.business;

import com.gabriela.cadastro_usuario.infrastructure.entitys.Filme;
import com.gabriela.cadastro_usuario.infrastructure.repository.FilmeRepository;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {

    private final FilmeRepository repository;

    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    public void salvarFilme(Filme filme) {
        repository.saveAndFlush(filme);
    }

    public Filme buscarFilmePorNome(String nome) {
        return repository.findByNome(nome).orElseThrow(
                () -> new RuntimeException("Filme não encontrado")
        );
    }

    public void deletarFilmePorNome(String nome) {
        repository.deleteByNome(nome);
    }

    public void atualizarFilmePorId(Integer id, Filme filme) {
        Filme filmeEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Filme não encontrado"));

        Filme filmeAtualizado = Filme.builder()
                .id(filmeEntity.getId())
                .nome(filme.getNome() != null ? filme.getNome() : filmeEntity.getNome())
                .ano(filme.getAno() != null ? filme.getAno() : filmeEntity.getAno())
                .diretor(filme.getDiretor() != null ? filme.getDiretor() : filmeEntity.getDiretor())
                .build();

        repository.saveAndFlush(filmeAtualizado);
    }
}