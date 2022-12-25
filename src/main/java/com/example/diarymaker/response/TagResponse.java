package com.example.diarymaker.response;

import com.example.diarymaker.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
