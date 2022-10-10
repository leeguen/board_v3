package com.project.board_v3.controller;

import com.project.board_v3.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {

    private BoardService boardService;

    @GetMapping("/board/save")
    public String save() {
        return "layout/board/board-save";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.detail(id));
        return "layout/board/board-detail";
    }

    @GetMapping("/board/{id}/update")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.detail(id));
        return "layout/board/board-update";
    }
}
