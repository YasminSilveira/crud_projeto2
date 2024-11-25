package com.ifsul.innovators.model;

import java.time.LocalDateTime;
import java.util.List;
import com.ifsul.innovators.enums.UsuarioTipo;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String fotoDePerfilURL;
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Curriculo curriculo;

    // Projetos criados pelo usuário (autor)
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Projeto> projetosCriados;

    // Projetos em que o usuário é membro
    @ManyToMany(mappedBy = "membros")
    private List<Projeto> projetosParticipados;
    @Enumerated(EnumType.STRING)
    private UsuarioTipo usuarioTipo;
    private String matricula;
    private String email;
    private String senha;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}
