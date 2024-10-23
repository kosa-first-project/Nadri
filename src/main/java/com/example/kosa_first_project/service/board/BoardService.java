package com.example.kosa_first_project.service.board;


import com.example.kosa_first_project.domain.board.BoardDTO;
import com.example.kosa_first_project.domain.board.BoardFileDTO;
import com.example.kosa_first_project.domain.board.PageDTO;
import com.example.kosa_first_project.domain.board.TitleSearchCond;
import com.example.kosa_first_project.repository.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoardService {

    @Value("${file.dir}")
    private String fileDir;


    private final BoardRepository boardRepository;

    public String getFullPath(String filename) { // 파일 저장 경로
        return fileDir + filename;
    }
    private String createStoreFileName(String originalFilename) { //UUID로 하나뿐인 이름 만들기
        String uuid = UUID.randomUUID().toString();
        String ext = extractExt(originalFilename);
        String storeFileName = uuid + "." + ext;
        return storeFileName;
    }
    private String extractExt(String originalFilename) { // 확장자 뽑아내는 메서드
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }

    public void save(BoardDTO boardDTO) throws IOException {
        // 첨부파일이 없을때
        if (boardDTO.getBoardFile().get(0).isEmpty()) {
            boardDTO.setAttachedFile(0); // 첨부파일이 없으므로 0값을 넘겨준다.
            boardRepository.save(boardDTO);
        } else { // 첨부파일이 있을 때
            // board 테이블의 attachedFile에 첨부파일이 존재하므로 1의 값을 넘겨준다.
            boardDTO.setAttachedFile(1);
            // 첨부파일DB의 boardId에 들어가는 값 반환 받기
            BoardDTO boardId = boardRepository.save(boardDTO);
            // 여러개의 파일일 경우가 존재 for문으로 file 테이블에 저장
            for (MultipartFile boardFile : boardDTO.getBoardFile()) {
                // 파일 이름 가져오기
                String originalFilename = boardFile.getOriginalFilename();
                // 저장용 파일 이름 만들기
                String storedFilename = createStoreFileName(originalFilename);
                // BoardFileDTO 세팅
                BoardFileDTO boardFileDTO = new BoardFileDTO();
                boardFileDTO.setOriginalFilename(originalFilename);
                boardFileDTO.setStoredFilename(storedFilename);
                boardFileDTO.setBoardId(boardId.getId());
                // 파일 저장용 폴더에 파일 저장처리
                boardFile.transferTo(new File(getFullPath(storedFilename)));
                // file 테이블에 저장 처리
                boardRepository.saveFile(boardFileDTO);
            }
        }
    }

    public List<BoardDTO> findBoardList(TitleSearchCond titleSearchCond, PageDTO pageDTO) {
//        Long totalCount = boardRepository.getTotalCount();
        Long totalCount = boardRepository.getTotalCount(titleSearchCond);
        pageDTO.setRow();
        pageDTO.setNum(totalCount);
        return boardRepository.findAll(titleSearchCond, pageDTO);
    }
    public void updateViewCount(Long id) {
        boardRepository.updateViewCount(id);
    }

    public BoardDTO findById(Long id) {
        return boardRepository.findById(id);
    }

    public List<BoardFileDTO> findFile(Long id) {
        return boardRepository.findFile(id);
    }

    public BoardFileDTO findFiletest(Long id) {
        return boardRepository.findFiletest(id);
    }
    public void delete(Long id) {
        boardRepository.delete(id);
    }

    public void update(BoardDTO boardDTO) {
        boardRepository.update(boardDTO);
    }



}
