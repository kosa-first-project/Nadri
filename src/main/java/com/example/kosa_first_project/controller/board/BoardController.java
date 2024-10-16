/*
package com.example.kosa_first_project.controller.board;

import com.example.kosa_first_project.domain.board.BoardDTO;
import com.example.kosa_first_project.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService; // 서비스와 연결

    @Autowired
    private HttpServletRequest request;

    // 메인화면
    @GetMapping() // 주소
    public String main(@CookieValue(name="user_id", required = false) String user_id, BoardDTO boardDTO, Model model) { // 메서드 이름

        List<BoardDTO> boardList = boardService.getBoardList(boardDTO);
        //로그인 아이디
*/
/*        if(user_id == null){
            model.addAttribute("boardList", boardList);
        }*//*

        model.addAttribute("boardList", boardList);
        return "board/main"; // 리턴할 화면의 이름
    }

    // 게시글 상세화면
    @GetMapping("/{id}")
    public String boardDetail(@PathVariable long id, Model model, BoardDTO boardDTO){
        BoardDTO boardDetail = boardService.getBoard(id);
        model.addAttribute("boardDetail", boardDetail);
        return "board/write";
    }

    //게시글 작성
    @RequestMapping("/write")
    public String boardWrite(@CookieValue(name="user_id", required = false) String user_id, BoardDTO boardDTO, Model model){
        model.addAttribute("boardDTO", boardDTO);
        return "board/write";
    }

    //게시글 삽입
//    @RequestMapping("/insertBoard")
//    public String insertBoard(@CookieValue(name="user_id", required = false) String user_id, @ModelAttribute BoardDTO boardDTO, Model model){
//        boardDTO.setUser_id(user_id);
//        model.addAttribute("user", boardDTO);
//        boardService.insertBoard(boardDTO);
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable long id){
        boolean deleted = boardService.deleteBoard(id);
        if(deleted){
            return ResponseEntity.ok("게시물이 성공적으로 삭제되었습니다.");
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("게시물 삭제 중 오류가 발생했습니다.");
        }
    }
*/
/*    @PostMapping("/boardSave")
    public String boardSave(     @RequestParam String user_id,
                                 @RequestParam String title,
                                 @RequestParam String context,
                                 @RequestParam String image,
                                 @RequestParam double rating,
                                  Model model
                            ){
        boolean save = boardService.boardSave(new BoardDTO(user_id, title, context, image, rating));
        if (save){
            List<BoardDTO> list = boardService.findAll();
            model.addAttribute("list", list);
            log.info("trace log{}", list);
            return "boardIndex";
        }
        else{
            log.info("{}", boardService.findAll().toString());
        }
        return "redirect:/board";
    }*//*

}
*/
