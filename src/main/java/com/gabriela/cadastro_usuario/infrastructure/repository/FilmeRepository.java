package com.gabriela.cadastro_usuario.infrastructure.repository;

import com.gabriela.cadastro_usuario.infrastructure.entitys.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {
    Optional<Filme> findByNome(String nome);

    @Transactional
    void deleteByNome(String nome);
}