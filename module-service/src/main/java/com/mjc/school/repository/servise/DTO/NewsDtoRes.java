package com.mjc.school.repository.servise.DTO;

import java.time.LocalDateTime;

public record NewsDtoRes(Long id, String title, String content, LocalDateTime createDate, LocalDateTime lastUpdateDate, Long authorId) {
}
