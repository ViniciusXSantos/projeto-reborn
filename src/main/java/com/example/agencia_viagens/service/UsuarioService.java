package com.example.agencia_viagens.service;


import com.example.agencia_viagens.model.Telefone;
import com.example.agencia_viagens.model.Usuario;
import com.example.agencia_viagens.repository.TelefoneRepository;
import com.example.agencia_viagens.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Transactional
    public Usuario atualizar(Long idUsuario, Usuario usuario) {
        Usuario usuarioSalvo = buscarUsuarioPeloId(idUsuario);

        // Atualiza os campos normais do usuário
        BeanUtils.copyProperties(usuario, usuarioSalvo, "idUsuario", "telefones");

        // Atualiza os telefones do usuário
        if (usuario.getTelefones() != null) {
            atualizarTelefones(idUsuario, usuario.getTelefones());
        }

        return usuarioRepository.save(usuarioSalvo);
    }

    public void atualizarPropriedadeEmail(Long idUsuario, String email) {
        Usuario usuarioSalvo = buscarUsuarioPeloId(idUsuario);
        usuarioSalvo.setEmail(email);
        usuarioRepository.save(usuarioSalvo);
    }

    public void atualizarPropriedadeAtivo(Long idUsuario, Boolean ativo) {
        Usuario usuarioSalvo = buscarUsuarioPeloId(idUsuario);
        usuarioSalvo.setAtivo(ativo);
        usuarioRepository.save(usuarioSalvo);
    }

    /**
     * Atualiza os telefones do usuário, removendo os antigos e adicionando os novos.
     */
    @Transactional
    public void atualizarTelefones(Long idUsuario, List<Telefone> novosTelefones) {
        Usuario usuario = buscarUsuarioPeloId(idUsuario);

        // Remove telefones antigos
        //telefoneRepository.deleteByUsuario(usuario);

        // Adiciona novos telefones
        for (Telefone telefone : novosTelefones) {
            telefone.setUsuario(usuario);
            telefoneRepository.save(telefone);
        }

        usuario.setTelefones(novosTelefones);
        usuarioRepository.save(usuario);
    }

    private Usuario buscarUsuarioPeloId(Long idUsuario) {
        return usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

}
