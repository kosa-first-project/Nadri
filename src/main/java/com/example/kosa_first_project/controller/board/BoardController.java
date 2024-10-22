package com.example.kosa_first_project.controller.board;
import com.example.kosa_first_project.domain.board.BoardDTO;
import com.example.kosa_first_project.domain.board.BoardFileDTO;
import com.example.kosa_first_project.domain.board.PageDTO;
import com.example.kosa_first_project.domain.board.TitleSearchCond;
import com.example.kosa_first_project.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    // 게시판 목록 화면
    @GetMapping("")
    public String boardList(@ModelAttribute("titleSearch") TitleSearchCond titleSearchCond,
                            @ModelAttribute("page") PageDTO pageDTO,
                            Model model) {

        List<BoardDTO> boardDTOList = boardService.findBoardList(titleSearchCond, pageDTO);
        model.addAttribute("boardList", boardDTOList);

        // 상세내용 처리
        BoardDTO boardDTO = boardService.findById(boardDTOList.get(0).getId());
        model.addAttribute("board", boardDTO);
        // 첨부파일이 있는 게시글의 경우 첨부파일 처리
        if (boardDTO.getAttachedFile().equals(1)) {
            List<BoardFileDTO> boardFileList = boardService.findFile(boardDTO.getId());
            model.addAttribute("boardFileList", boardFileList);
        }
        return "/board/main";
    }

    // 게시글 등록 화면
    @GetMapping("/save")
    public String boardRegistration() {
        return "/board/addForm";
    }

    @PostMapping("/save")
    public String boardRegistration(BoardDTO boardDTO) throws IOException {
        boardService.save(boardDTO);
        return "redirect:/board";
    }

    // 게시글 상세 화면
    @GetMapping("/{id}")
    public String boardDetail(@PathVariable("id") Long id, Model model) {
        // 조회수 처리
        boardService.updateViewCount(id);
        // 상세내용 처리
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        // 첨부파일이 있는 게시글의 경우 첨부파일 처리
        if (boardDTO.getAttachedFile().equals(1)) {
            List<BoardFileDTO> boardFileList = boardService.findFile(id);
            model.addAttribute("boardFileList", boardFileList);
        }
        return "/board/detailForm";
    }

    // 게시글 수정 화면
    @GetMapping("/edit/{id}")
    public String boardEdit(@PathVariable("id") Long id, Model model) {
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "/board/editForm";
    }

    @PostMapping("/edit/{id}")
    public String boardEdit(BoardDTO boardDTO, Model model) {
        boardService.update(boardDTO);
        BoardDTO boardId = boardService.findById(boardDTO.getId());
        model.addAttribute("board", boardId);
        return "redirect:/board/{id}";
    }

    // 게시글 삭제
    @GetMapping("/delete/{id}")
    public String boardDelete(@PathVariable("id") Long id) {
        boardService.delete(id);
        return "redirect:/board";
    }
}
