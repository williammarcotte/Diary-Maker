package com.example.diarymaker.request;

import jakarta.validation.constraints.NotBlank;
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
