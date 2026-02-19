package org.stockify.ServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.stockify.controller.auth.RegisterRequest;
import org.stockify.controller.auth.UsuarioResponse;
import org.stockify.entity.Usuario;
import org.stockify.repository.UsuarioRepository;
import org.stockify.service.UsuarioService;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {


    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UsuarioResponse register(RegisterRequest request) {

        if (usuarioRepository.existsByUsername(request.name())) {
            throw new RuntimeException("El usuario ya existe");
        }

        Usuario usuario = new Usuario();
        usuario.setUsername(request.name());
        usuario.setPassword(passwordEncoder.encode(request.password()));

        // 🔒 EL SERVIDOR DECIDE EL ROL
        usuario.setRol("USER");

        Usuario saved = usuarioRepository.save(usuario);

        return new UsuarioResponse(
                saved.getId(),
                saved.getUsername()
        );
    }
}
