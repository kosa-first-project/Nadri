package com.example.kosa_first_project.controller.board;

import com.example.kosa_first_project.domain.board.BoardDTO;
import com.example.kosa_first_project.domain.board.BoardFileDTO;
import com.example.kosa_first_project.service.board.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board") // URL에서 무조건 /board 이하로 시작해야한다.
public class BoardController {

    @Autowired
    private BoardService boardService; // 서비스 연결

    @GetMapping("")
    public ResponseEntity<?> getListBoard(BoardDTO board, @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(boardService.getListBoard(board, pageable));
    }

    @RequestMapping // 메인 화면 매핑 주소
    public String boardMain(@ModelAttribute("params") Model model) {

        // 전체 게시글 출력
        List<BoardDTO> boardDTOList = boardService.getBoardAll();
        model.addAttribute("boardList", boardDTOList);
        System.out.println("boardDTOList : " + boardDTOList);

        // 각 게시글에 대한 파일 리스트를 모델에 추가
        List<List<BoardFileDTO>> boardFileLists = new ArrayList<>();
        for (BoardDTO board : boardDTOList) {
            List<BoardFileDTO> boardFiles = boardService.getFile(board.getId());

            // 파일 리스트가 null인 경우 빈 리스트로 초기화
            if (boardFiles == null) {
                boardFiles = new ArrayList<>();
            }

            boardFileLists.add(boardFiles);
        }
        model.addAttribute("boardFileLists", boardFileLists);
        System.out.println("boardFileLists : " + boardFileLists);

        // 게시글 총 개수
        int total = boardService.cntBoard();
        model.addAttribute("cntBoard", total); // 전체 개수를 모델에 저장

        return "board/main";
    }


    // 게시글 상세화면
    @GetMapping("/{id}") // URL에서 : /board/{id}
    public String boardDetail(@PathVariable Long id, Model model) {
        boardService.updateHit(id); // 조회 수 처리

        BoardDTO boardDetail = boardService.getBoardOne(id); // 상세 게시글 가져옴
        model.addAttribute("board", boardDetail);
        log.info("boardDetail: {}", boardDetail);
        if (boardDetail.getFileAttached() == 1) { // 파일이 있으면 가져오기
            List<BoardFileDTO> boardFileDTOList = boardService.getFile(id);
            model.addAttribute("boardFileList", boardFileDTOList);
            log.info("boardFileList {} :", boardFileDTOList);
        }

        List<BoardFileDTO> file = boardService.getFile(id); // 게시글 번호에 따른 파일 가져오기.
        model.addAttribute("getFile", file);
        log.info("getFile: {}", file);

        return "board/detail";
    }

    // 게시글 조회(Get)
    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        BoardDTO boardOne = boardService.getBoardOne(id);
        model.addAttribute("board", boardOne);
//        log.info("boardOneGet: {}", boardOne);
        return "board/update";
    }

    // 게시글 수정(Post)
    @PostMapping("/update/{id}")
    public String update(BoardDTO boardDTO, Model model) {
        boardService.updateBoard(boardDTO);
        BoardDTO boardOne = boardService.getBoardOne(boardDTO.getId());
        model.addAttribute("board", boardOne);
//        log.info("boardOnePost: {}", boardOne);
        return "board/update";
    }

    //Get으로 전달될 경우 게시글 저장 페이지로 이동
    @GetMapping("/insert")
    public String insertBoard() {
        return "board/insert";
    }

    //게시글 삽입
    @PostMapping("/insert")
    public String insertBoard(@ModelAttribute BoardDTO boardDTO) throws IOException {
//        log.info("boardDTO: {}", boardDTO);
        boardService.insertBoard(boardDTO);
        return "redirect:/board"; // 게시글 저장 후 메인 페이지로 이동
    }

    //게시글 삭제
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        boardService.deleteBoard(id);
        redirectAttributes.addFlashAttribute("message", "삭제 작업이 완료되었습니다.");
        return "redirect:/board"; // 게시글 삭제 후 메인 페이지로 이동
    }

    @GetMapping("/search")
    public String searchBoard(@RequestParam("keyword") String keyword, Model model) {
        List<BoardDTO> searchResults = boardService.searchBoardByKeyword(keyword);
        model.addAttribute("boardList", searchResults);

        return "main6";
    }
}
