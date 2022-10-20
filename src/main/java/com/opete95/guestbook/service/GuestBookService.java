package com.opete95.guestbook.service;

import com.opete95.guestbook.domain.GuestBookDTO;
import com.opete95.guestbook.domain.PageRequestDTO;
import com.opete95.guestbook.domain.PageResponseDTO;
import com.opete95.guestbook.entity.GuestBook;

public interface GuestBookService {
    //데이터 삽입을 위한 메서드
    public Long register(GuestBookDTO dto);

    //목록보기를 위한 메서드
    public PageResponseDTO<GuestBookDTO,GuestBook>
        getList(PageRequestDTO pageRequestDTO);

    //상세보기를 위한 메서드
    public GuestBookDTO read(Long gno);

    //DTO를 Entity로 변환해주는 메서드
    default GuestBook dtoToEntity(GuestBookDTO dto){
        GuestBook entity = GuestBook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
        return entity;
    }

    //Entity를 DTO로 변환해주는 메서드
    default GuestBookDTO entityToDTO(GuestBook entity){
        GuestBookDTO dto = GuestBookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }
}
