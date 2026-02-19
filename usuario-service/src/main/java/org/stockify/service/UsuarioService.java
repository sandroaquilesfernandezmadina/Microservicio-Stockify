package org.stockify.service;

import org.stockify.controller.auth.RegisterRequest;
import org.stockify.controller.auth.UsuarioResponse;

public interface UsuarioService {
    UsuarioResponse register(RegisterRequest request);
}
