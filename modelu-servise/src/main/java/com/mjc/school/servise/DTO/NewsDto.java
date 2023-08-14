package com.mjc.school.servise.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto {
    Long id;
    String title;
    String content;
    LocalDateTime createDate;
    LocalDateTime lastUpdateDate;
    Long authorId;
}
