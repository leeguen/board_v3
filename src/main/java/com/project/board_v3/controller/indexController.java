package com.project.board_v3.controller;

import com.project.board_v3.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class indexController {
    private final BoardService boardService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("boards", boardService.findAll());
        return "index";
    }
}
