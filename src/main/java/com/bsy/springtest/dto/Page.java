package com.bsy.springtest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
@Builder
public class Page {
    // 페이징 기본값
    private static final int PAGE_NUM = 1;  // 현재 페이지 번호 기본값
    private static final int ROWS = 10;     // 페이지당 게시글 수 기본값
    private static final int COUNT = 10;    // 노출 페이지 개수 기본값

    // ✅ 필수 정보
    private int page;
    private int rows;
    private int count;
    private int total;

    // ⭐ 수식 정보
    private int start;
    private int end;
    private int first;
    private int last;

    private int prev;
    private int next;

    private int index;

    // 생성자
    public Page(){
        this(0);
    }

    // 데이터 개수
    public Page(int total){
        this(PAGE_NUM, total);
    }
    // 현재 번호, 데이터 개수
    public Page(int page, int total){
        this(page, ROWS, COUNT, total);
    }
    // 필수 정보
    public Page(int page, int rows, int count, int total){
        this.page = page;
        this.rows = rows;
        this.count = count;
        this.total = total;
        calc();
    }

    // setter
    // * 데이터 개수 지정 후, 페이지 서식 재계산
    public void setTotal(int total){
        this.total = total;
        calc();
    }

    // 페이징 처리 수식
    public void calc(){
        // 첫 번호
        this.first = 1;
        // 마지막 번호
        this.last = (this.total -1) / rows + 1;
        // 시작 번호
        this.start = ((page-1) / count) * count + 1;
        // 끝 번호
        this.end = ((page-1) / count + 1) * count;
        if( this.end > this.last ) this.end = this.last;

        // 이전 번호
        this.prev = this.start - 1;
        // 다음 번호
        this.next = this.end + 1;
        // 데이터 순서 번호
        this.index = (this.page - 1) * this.rows;
        log.info("page : " + page );
        log.info("rows : " + rows );
        log.info("count : " + count );
        log.info("total : " + total );
        log.info("start : " + start );
        log.info("end : " + end );
        log.info("first : " + first );
        log.info("last : " + last );
        log.info("prev : " + prev );
        log.info("next : " + next );
        log.info("index : " + index );
        
    }

}
