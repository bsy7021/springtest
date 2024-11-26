package com.bsy.springtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bsy.springtest.dto.Board;
import com.bsy.springtest.dto.Page;
import com.bsy.springtest.service.BoardService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 게시글 목록
    @GetMapping("/list")
    public String list(Model model, Page page) throws Exception {
        int total = boardService.total();
        page.setTotal(total);
        List<Board> boardList = boardService.list(page);
        model.addAttribute("boardList", boardList);
        model.addAttribute("page", page);
        return "/board/list";
    }

    // 게시글 목록 조회
    @GetMapping("/read")
    public String read(@RequestParam("no") int no, Model model) throws Exception {
        Board board = boardService.read(no);
        model.addAttribute("board", board);
        return "/board/read";
    }
    
    // 게시글 등록
    @GetMapping("/insert")
    public String insert() {
        return "/board/insert";
    }

    // 게시글 등록 처리
    @PostMapping("/insert")
    public String insertResult(Board board) throws Exception{
        int result = boardService.insert(board);

        if( result > 0 ){
            return "redirect:/board/list";
        }

        return "redirect:/board/insert?error";
    }
    
    // 게시글 수정
    @GetMapping("/update")
    public String update(@RequestParam("no") int no, Model model) throws Exception{
        Board board = boardService.read(no);
        model.addAttribute("board", board);
        return "/board/update";
    }

    // 게시글 수정 처리
    @PostMapping("/update")
    public String updateResult(Board board) throws Exception {
        int result = boardService.update(board);
        if( result > 0 ){
            return "redirect:/board/list";
        }
        return "redirect:/board/update?error";
    }
    
    // 게시글 삭제 처리
    @PostMapping("/delete")
    public String deleteResult(@RequestParam("no") int no) throws Exception {
        int result = boardService.delete(no);
        if( result > 0 ){
            return "redirect:/board/list";
        }
        return "redirect:/board/update?no" + no + "&error";
    }
    
    
}
