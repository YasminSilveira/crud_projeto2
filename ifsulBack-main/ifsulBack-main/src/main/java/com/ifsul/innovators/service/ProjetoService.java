package com.ifsul.innovators.service;
import com.ifsul.innovators.model.Projeto;
import com.ifsul.innovators.repository.ProjetoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public Projeto salvarProjeto(Projeto projeto) { return projetoRepository.save(projeto);
    }

    public List<Projeto> listarTodos() { return projetoRepository.findAll();
    }

    public Optional<Projeto> buscarPorId(Long id) { return projetoRepository.findById(id);
    }

    public Projeto atualizarProjeto(Long id, Projeto projetoAtualizado) {
        if (projetoRepository.existsById(id)) { projetoAtualizado.setId(id);
            return projetoRepository.save(projetoAtualizado);
        } else {
            throw new RuntimeException("Projeto não encontrado");
        }
    }

    public void deletarProjeto(Long id) {
        if (projetoRepository.existsById(id)) {
            projetoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Projeto não encontrado");
        }
    }
}