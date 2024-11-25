package com.ifsul.innovators.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Necessidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNecessidade;

    @ManyToOne
    @JoinColumn(name = "id_projeto")
    private Projeto projeto;

    private String titulo;
    private String descricao;
    private int qtdVagas;

    @ManyToMany
    @JoinTable(
            name = "necessidade_curriculos_recebidos",
            joinColumns = @JoinColumn(name = "id_necessidade"),
            inverseJoinColumns = @JoinColumn(name = "id_curriculo")
    )
    private List<Curriculo> curriculosRecebidos;

    @ManyToMany
    @JoinTable(
            name = "necessidade_curriculos_aceitos",
            joinColumns = @JoinColumn(name = "id_necessidade"),
            inverseJoinColumns = @JoinColumn(name = "id_curriculo")
    )
    private List<Curriculo> curriculosAceitos;

    @ManyToMany
    @JoinTable(
            name = "necessidade_curriculos_recusados",
            joinColumns = @JoinColumn(name = "id_necessidade"),
            inverseJoinColumns = @JoinColumn(name = "id_curriculo")
    )
    private List<Curriculo> curriculosRecusados;
    private Boolean necessidadeAtiva;
}
