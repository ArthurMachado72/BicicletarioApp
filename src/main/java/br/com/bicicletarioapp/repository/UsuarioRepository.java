package br.com.bicicletarioapp.repository;

import br.com.bicicletarioapp.model.Usuario;
import java.util.List;

public interface UsuarioRepository {

    void save(Usuario usuario);

    void salvar(Usuario usuario);

    Usuario buscarPorId(Long id);

    Usuario buscarPorNome(String nome);

    List<Usuario> listarTodos();

    void atualizar(Usuario usuario);

    void excluir(Long id);

    public Usuario findByNome(String nome);

    public Usuario findById(Long id);

}
