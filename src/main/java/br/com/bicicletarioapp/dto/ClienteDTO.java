package br.com.bicicletarioapp.dto;

public class ClienteDTO {
    private Long id;
    private String nome;
    private String contato;

    // Getters e Setters
    public Long getId() {
    return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
