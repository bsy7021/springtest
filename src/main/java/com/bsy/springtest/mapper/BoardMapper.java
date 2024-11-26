package com.bsy.springtest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bsy.springtest.dto.Board;
import com.bsy.springtest.dto.Page;

@Mapper
public interface BoardMapper {
    
    // 게시글 조회
    public Board read(int no) throws Exception;
    // 게시글 등록
    public int insert(Board board) throws Exception;
    // 게시글 수정
    public int update(Board board) throws Exception;
    // 게시글 삭제
    public int delete(int no) throws Exception;
    
    // 페이징
    public List<Board> list(@Param("page") Page page) throws Exception;
    
    // 전체 게시물 수
    public int total() throws Exception;
}

