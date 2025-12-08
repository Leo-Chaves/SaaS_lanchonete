package com.leo.chaves.SaaS.Controller;

import com.leo.chaves.SaaS.DTO.LoginDTO;
import com.leo.chaves.SaaS.DTO.RegisterDTO;
import com.leo.chaves.SaaS.Service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterDTO dto) {
        return service.register(dto);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto) throws Exception {
        return service.login(dto);
    }
}
