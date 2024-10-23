package com.example.kosa_first_project.repository.board;


import com.example.kosa_first_project.domain.board.BoardDTO;
import com.example.kosa_first_project.domain.board.BoardFileDTO;
import com.example.kosa_first_project.domain.board.PageDTO;
import com.example.kosa_first_project.domain.board.TitleSearchCond;

import java.util.List;

public interface BoardRepository {
    BoardDTO save(BoardDTO boardDTO);
    void saveFile(BoardFileDTO boardFileDTO);
    List<BoardDTO> findAll(TitleSearchCond titleSearchCond, PageDTO pageDTO);
    void updateViewCount(Long id);
    BoardDTO findById(Long id);
    List<BoardFileDTO> findFile(Long id);
    BoardFileDTO findFiletest(Long id);
    void delete(Long id);
    void update(BoardDTO boardDTO);
//    Long getTotalCount();
    Long getTotalCount(TitleSearchCond titleSearchCond);

}
