package br.com.bicicletarioapp.service.impl;

import br.com.bicicletarioapp.model.Usuario;
import br.com.bicicletarioapp.repository.UsuarioRepository;
import br.com.bicicletarioapp.service.IUsuarioService;
import java.util.List;

public class UsuarioServiceImpl implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;
    
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void salvarUsuario(Usuario usuario) {
        usuarioRepository.salvar(usuario);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.buscarPorId(id);
    }

    @Override
    public Usuario buscarPorNome(String nome) {
        return usuarioRepository.buscarPorNome(nome);
    }

    @Override
    public List<Usuario> listarTodosUsuarios() {
        return usuarioRepository.listarTodos();
    }

    @Override
    public void atualizarUsuario(Usuario usuario) {
        usuarioRepository.atualizar(usuario);
    }

    @Override
    public void excluirUsuario(Long id) {
        usuarioRepository.excluir(id);
    }

    @Override
    public boolean verificarCredenciais(String nome, String senha) {
        Usuario usuario = usuarioRepository.buscarPorNome(nome);
        return usuario != null && usuario.getSenha().equals(senha);
    }
}