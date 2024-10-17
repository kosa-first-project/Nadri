package com.example.kosa_first_project.controller.board;

import com.example.kosa_first_project.domain.board.BoardDTO;
import com.example.kosa_first_project.domain.board.FileDTO;
import com.example.kosa_first_project.domain.board.PaginationDTO;
import com.example.kosa_first_project.service.board.BoardService;
import com.example.kosa_first_project.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board") // URL에서 무조건 /board 이하로 시작해야한다.
public class BoardController {

    @Autowired
    private BoardService boardService; // 서비스 연결

    // 메인화면(전체 게시글 출력)
    @GetMapping() // 매핑 주소
    public String boardMain(BoardDTO boardDTO, Model model, @RequestParam(defaultValue = "1") int page) { // 페이지 기본값 1로 세팅

        // 게시글 총 개수
        int total = boardService.cntBoard();
        model.addAttribute("cntBoard", total); // 전체 개수를 모델에 저장

        // 페이징
        PaginationDTO pagination = new PaginationDTO(5, 3); // 페이지 당 게시글 수,
        pagination.setPageNo(page); // 페이지 번호 저장
        pagination.setTotalSize(total); // 전체 페이지 저장

        boardDTO.setPageNo(page); // 게시판에 페이지 번호 저장
        boardDTO.setPageSize(pagination.getTotalSize()); // 전체 페이지 수
        boardDTO.setPageOffset(pagination.getPageOffset()); // 페이지 시작 위치

        model.addAttribute("paginate", pagination);
        model.addAttribute("boardList", boardService.getBoardAll(boardDTO));

        return "board/main"; // 리턴할 뷰
    }

    // 게시글 상세화면
    @GetMapping("/{id}") // URL에서 : /board/{id}
    public String boardDetail(@PathVariable long id, Model model, BoardDTO boardDTO){
        BoardDTO boardDetail = boardService.getBoardOne(id); // 게시글 번호 저장
        List<FileDTO> file = boardService.getFile(boardDTO); // 게시글 번호에 따른 파일 가져오기.
        model.addAttribute("board", boardDetail);
        model.addAttribute("getFile", file);
        return "board/write";
    }

    // 게시글 작성
    @GetMapping("/write")
    public String showWriteForm(BoardDTO boardDTO, Model model) {
        model.addAttribute("getBoard", boardDTO);
        model.addAttribute("getFile", boardService.getFile(boardDTO));
        return "board/write";
    }

    //게시글 삽입
    @PostMapping("/insertBoard")
    public String insertBoard(@CookieValue(name="user_id", required = false) String user_id, @ModelAttribute BoardDTO boardDTO, Model model){
        boardDTO.setUser_id(user_id);
        boardService.insertBoard(boardDTO);
        return "redirect:/main";
    }

    //게시글 삭제
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable long id){ // ResponseEntity : 응답
        boolean deleted = boardService.deleteBoard(id);
        if(deleted){
            return ResponseEntity.ok("게시물이 성공적으로 삭제되었습니다.");
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("게시물 삭제 중 오류가 발생했습니다.");
        }
    }

    // ajax로 첨부파일 처리
    @RequestMapping("/ajaxFile")
    @ResponseBody
    public List<FileDTO> ajaxFile(@RequestParam("files") MultipartFile[] uploadFile){
        List<FileDTO> fileList = FileUtil.uploadFile(uploadFile);  //파일 등록
        return fileList;
    }

    // 파일 다운로드
    @RequestMapping("/downloadFile")
    public ResponseEntity<Resource> downloadFile(@ModelAttribute FileDTO fileDTO) throws IOException {
        return boardService.downloadFile(fileDTO);
    }

}
