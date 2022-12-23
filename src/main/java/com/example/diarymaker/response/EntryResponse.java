package com.example.diarymaker.response;

import com.example.diarymaker.entity.Entry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntryResponse {
    private long id;
    private String title;
    private String content;

    public EntryResponse(Entry entry){
        id = entry.getId();
        title = entry.getTitle();
        content = entry.getContent();
    }
}
