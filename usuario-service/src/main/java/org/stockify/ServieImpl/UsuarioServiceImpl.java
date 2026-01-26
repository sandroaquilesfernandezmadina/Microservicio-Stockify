package org.stockify.ServieImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.stockify.entity.Usuario;
import org.stockify.repository.UsuarioRepository;
import org.stockify.service.UsuarioSevice;

@Service
public class UsuarioServiceImpl implements UsuarioSevice {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Usuario guardar(Usuario usuario) {

        if (usuarioRepository.existsByUsername(usuario.getUsername())) {
            throw new RuntimeException("El usuario ya existe");
        }

        // 🔐 Encriptar password ANTES de guardar
        usuario.setPassword(
                passwordEncoder.encode(usuario.getPassword())
        );

        return usuarioRepository.save(usuario);
    }
}
