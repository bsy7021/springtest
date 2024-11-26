package com.bsy.springtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsy.springtest.dto.Board;
import com.bsy.springtest.dto.Page;
import com.bsy.springtest.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
    
    @Autowired
    private BoardMapper boardMapper;

    // 게시글 목록 조회
    @Override
    public List<Board> list(Page page) throws Exception {
        List<Board> boardList = boardMapper.list(page);
        return boardList;
    }

    // 게시글 조회
    @Override
    public Board read(int no) throws Exception {
        Board board = boardMapper.read(no);
        return board;        
    }

    // 게시글 등록
    @Override
    public int insert(Board board) throws Exception {
        int result = boardMapper.insert(board);
        return result;
    }

    // 게시글 수정
    @Override
    public int update(Board board) throws Exception {
        int result = boardMapper.update(board);
        return result;
    }

    // 게시글 삭제
    @Override
    public int delete(int no) throws Exception {
        int result = boardMapper.delete(no);
        return result;
    }

    @Override
    public int total() throws Exception {
        int result = boardMapper.total();
        return result;
    }

}