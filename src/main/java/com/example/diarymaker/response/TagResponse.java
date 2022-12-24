package com.example.diarymaker.response;

import com.example.diarymaker.entity.Tag;

public class TagResponse {
    private String text;
    private long id;
    private EntryResponse entry;

    public TagResponse(Tag tag){
         id = tag.getId();
         text = tag.getText();
         entry = new EntryResponse(tag.getEntry());
    }
}
