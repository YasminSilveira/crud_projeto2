package com.ifsul.innovators.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Curriculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurriculo;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @ElementCollection
    private List<String> listaSkills;
    @OneToMany(mappedBy = "curriculo", cascade = CascadeType.ALL)
    private List<Experiencia> experiencias;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}
