package com.ifsul.innovators.repository;

import com.ifsul.innovators.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> { }