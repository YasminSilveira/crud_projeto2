package com.ifsul.innovators.repository;

import com.ifsul.innovators.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> { }
