package com.example.diarymaker.controller;

import com.example.diarymaker.request.TagRequest;
import com.example.diarymaker.response.TagResponse;
import com.example.diarymaker.service.TagService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/tagId")
    public TagResponse getCourse(@PathVariable long tagId, @Valid @RequestBody TagRequest tagRequest){
        return new TagResponse(tagService.updateTag(tagId,tagRequest));
    }

    @DeleteMapping("/tagId")
    public void deleteCourse(@PathVariable long tagId) {tagService.deleteTag(tagId);}
}
