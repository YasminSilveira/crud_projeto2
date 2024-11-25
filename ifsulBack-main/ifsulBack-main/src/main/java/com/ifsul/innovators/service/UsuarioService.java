package com.ifsul.innovators.service;

import com.ifsul.innovators.model.Usuario;
import com.ifsul.innovators.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        Usuario usuarioParaExcluir = usuarioRepository.findById(id)
                .orElseThrow();
        usuarioRepository.delete(usuarioParaExcluir);
    }
}
