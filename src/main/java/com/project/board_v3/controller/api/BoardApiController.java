package com.project.board_v3.controller.api;

import com.project.board_v3.config.auth.PrincipalDetail;
import com.project.board_v3.dto.BoardSaveRequestDto;
import com.project.board_v3.dto.BoardUpdateRequestDto;
import com.project.board_v3.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;


    @PostMapping("/api/v1/board")
    public Long save(@RequestBody BoardSaveRequestDto boardSaveRequestDto, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        return boardService.save(boardSaveRequestDto, principalDetail.getUser());
    }


    @DeleteMapping("/api/v1/board/{id}")
    public Long deleteById(@PathVariable Long id) {
        boardService.deleteById(id);
        return id;
    }


    @PutMapping("/api/v1/board/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto boardUpdateRequestDto) {
        return boardService.update(id, boardUpdateRequestDto);
    }
}
