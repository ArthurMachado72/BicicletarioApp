package br.com.bicicletarioapp.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id") 
    private Long id;  
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "senha", nullable = false)
    private String senha;
    

    @OneToMany(mappedBy = "usuario")
    private List<Aluguel> alugueis = new ArrayList<>();

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;

    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }


   }

