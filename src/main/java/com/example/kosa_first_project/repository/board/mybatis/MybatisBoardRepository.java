package com.example.kosa_first_project.repository.board.mybatis;

import com.example.kosa_first_project.domain.board.BoardDTO;
import com.example.kosa_first_project.domain.board.BoardFileDTO;
import com.example.kosa_first_project.domain.board.PageDTO;
import com.example.kosa_first_project.domain.board.TitleSearchCond;
import com.example.kosa_first_project.repository.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MybatisBoardRepository implements BoardRepository {

    private final BoardMapper boardMapper;
    @Override
    public BoardDTO save(BoardDTO boardDTO) {
        boardMapper.save(boardDTO);
        return boardDTO;
    }
    @Override
    public void saveFile(BoardFileDTO boardFileDTO) {
        boardMapper.saveFile(boardFileDTO);
    }
    @Override
    public List<BoardDTO> findAll(TitleSearchCond titleSearchCond, PageDTO pageDTO) {
        return boardMapper.findAll(titleSearchCond, pageDTO);
    }
    @Override
    public void updateViewCount(Long id) {
        boardMapper.updateViewCount(id);
    }
    @Override
    public BoardDTO findById(Long id) {
        return boardMapper.findById(id);
    }
    @Override
    public List<BoardFileDTO> findFile(Long id) {
        return boardMapper.findFile(id);
    }
    @Override
    public void delete(Long id) {
        boardMapper.delete(id);
    }
    @Override
    public void update(BoardDTO boardDTO) {
        boardMapper.update(boardDTO);
    }
    /*@Override
    public Long getTotalCount() {
        return boardMapper.getTotalCount();
    }*/
    @Override
    public Long getTotalCount(TitleSearchCond titleSearchCond) {
        return boardMapper.getTotalCount(titleSearchCond);
    }
}
