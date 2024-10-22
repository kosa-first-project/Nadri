package com.example.kosa_first_project.repository.board.mybatis;

import com.example.kosa_first_project.domain.board.BoardDTO;
import com.example.kosa_first_project.domain.board.BoardFileDTO;
import com.example.kosa_first_project.domain.board.PageDTO;
import com.example.kosa_first_project.domain.board.TitleSearchCond;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    void save(BoardDTO boardDTO);
    void saveFile(BoardFileDTO boardFileDTO);
    List<BoardDTO> findAll(TitleSearchCond titleSearchCond, PageDTO pageDTO);
    void updateViewCount(Long id);
    BoardDTO findById(Long id);
    List<BoardFileDTO> findFile(Long id);
    void delete(Long id);
    void update(BoardDTO boardDTO);
//    Long getTotalCount();
    Long getTotalCount(TitleSearchCond titleSearchCond);

}
