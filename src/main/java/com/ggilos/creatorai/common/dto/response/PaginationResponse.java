package com.ggilos.creatorai.common.dto.response;

import org.springframework.data.domain.Slice;

import java.util.List;

public record PaginationResponse<T>(
        List<T> content,
        int page,
        int size,
        boolean hasNext
) {
    public static <T> PaginationResponse<T> from(Slice<T> slice) {
        return new PaginationResponse<>(
                slice.getContent(),
                slice.getNumber(),
                slice.getSize(),
                slice.hasNext()
        );
    }
}
