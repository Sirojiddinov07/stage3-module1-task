package com.mjc.school.servise.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsUpdateDtoReq {
    Long id;
    String title;
    String content;
    Long authorId;
}
