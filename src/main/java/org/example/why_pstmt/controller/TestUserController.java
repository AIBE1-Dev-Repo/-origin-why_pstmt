package org.example.why_pstmt.controller;

import org.example.why_pstmt.model.dao.TestUserRepository;
import org.example.why_pstmt.model.dto.TestUser;
import org.example.why_pstmt.model.dto.TestUserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/")
public class TestUserController {
    private final TestUserRepository testUserRepository;

    public TestUserController(TestUserRepository testUserRepository) {
        this.testUserRepository = testUserRepository;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @PostMapping("/join")
    public String join(
            @ModelAttribute TestUserDTO dto
            ) throws SQLException {
        testUserRepository.createTestUser(dto.username(), dto.password());
        return "redirect:/";
    }
}
