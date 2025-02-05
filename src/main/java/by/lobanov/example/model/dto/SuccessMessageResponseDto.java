package by.lobanov.example.model.dto;

import lombok.Builder;

@Builder
public record SuccessMessageResponseDto(

        String message
) {
}
