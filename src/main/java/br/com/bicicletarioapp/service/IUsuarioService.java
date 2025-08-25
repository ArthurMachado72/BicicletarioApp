package br.com.bicicletarioapp.service;

import br.com.bicicletarioapp.model.Usuario;
import java.util.List;

public interface IUsuarioService {
    void salvarUsuario(Usuario usuario);
    Usuario buscarPorId(Long id);
    Usuario buscarPorNome(String nome);
    List<Usuario> listarTodosUsuarios();
    void atualizarUsuario(Usuario usuario);
    void excluirUsuario(Long id);
    boolean verificarCredenciais(String nome, String senha);
}