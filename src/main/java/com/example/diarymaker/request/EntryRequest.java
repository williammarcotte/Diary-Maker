package com.example.diarymaker.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntryRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
