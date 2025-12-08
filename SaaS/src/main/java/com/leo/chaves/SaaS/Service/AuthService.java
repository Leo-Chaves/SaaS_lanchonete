package com.leo.chaves.SaaS.Service;

import com.leo.chaves.SaaS.DTO.LoginDTO;
import com.leo.chaves.SaaS.DTO.RegisterDTO;
import com.leo.chaves.SaaS.Entity.User;
import com.leo.chaves.SaaS.Repository.UserRepository;
import com.leo.chaves.SaaS.Security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repo;
    private final JwtUtil jwt;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository repo, JwtUtil jwt) {
        this.repo = repo;
        this.jwt = jwt;
    }

    public String register(RegisterDTO dto) {
        var user = new User();
        user.setEmail(dto.email());
        user.setPassword(encoder.encode(dto.password()));
        repo.save(user);
        return "Registrado com sucesso!";
    }

    public String login(LoginDTO dto) throws Exception {
        var user = repo.findByEmail(dto.email())
                .orElseThrow(() -> new Exception("Usuário não encontrado"));

        if (!encoder.matches(dto.password(), user.getPassword()))
            throw new Exception("Senha incorreta!");

        return jwt.generateToken(dto.email());
    }
}
