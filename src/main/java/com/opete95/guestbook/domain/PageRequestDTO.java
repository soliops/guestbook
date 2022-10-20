package com.opete95.guestbook.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {
    //페이지 번호
    private int page;
    //페이지당 출력할 데이터 개수
    private int size;
    
    //검색 타입
    private String type;

    //검색어
    private String keyword;
    
    //기본값을 설젛하기 위한 생성자
    public PageRequestDTO(){
        this.page = 1;
        this.size = 10;
    }
           
    //페이지 번호 와 데이터 개수를 가지고 Pageable 객체를
    //만들어주는 메서달
    public Pageable getPageable(Sort sort){
        return PageRequest.of(page-1,size,sort);
    }
}
