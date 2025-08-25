package br.com.bicicletarioapp.repository;

import br.com.bicicletarioapp.model.Usuario;
import java.util.List;

public interface IUsuarioRepository {
    Usuario findByNome(String nome);
    Usuario save(Usuario usuario);
    List<Usuario> findAll();
    void delete(Long id);
    Usuario findById(Long id);
}
