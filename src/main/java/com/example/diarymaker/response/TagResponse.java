package com.example.diarymaker.response;

import com.example.diarymaker.entity.Tag;

public class TagResponse {
    private String text;

    public TagResponse(Tag tag){
        text = tag.getText();
    }
}
