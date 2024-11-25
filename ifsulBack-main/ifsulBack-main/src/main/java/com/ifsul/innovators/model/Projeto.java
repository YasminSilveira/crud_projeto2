package com.ifsul.innovators.model;

import com.ifsul.innovators.enums.StatusTipo;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProjeto;
    private String nome;
    private String descricao;
    // Autor do projeto
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;
    // Membros do projeto
    @ManyToMany
    @JoinTable(name = "projeto_usuario_membros",
            joinColumns = @JoinColumn(name = "projeto_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> membros;
    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
    private List<Necessidade> necessidades;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private LocalDateTime dataEstimadaTermino;
    @Enumerated(EnumType.STRING)
    private StatusTipo statusTipo;
}
