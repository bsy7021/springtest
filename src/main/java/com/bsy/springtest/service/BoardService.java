package com.bsy.springtest.service;

import java.util.List;

import com.bsy.springtest.dto.Board;
import com.bsy.springtest.dto.Page;

public interface BoardService {

    // 게시글 조회
    public Board read(int no) throws Exception;
    // 게시글 등록
    public int insert(Board board) throws Exception;
    // 게시글 수정
    public int update(Board board) throws Exception;
    // 게시글 삭제
    public int delete(int no) throws Exception;

    // 페이징
    public List<Board> list(Page page) throws Exception;
    
    // 전체 게시물 수
    public int total() throws Exception;
}