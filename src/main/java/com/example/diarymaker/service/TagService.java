package com.example.diarymaker.service;

import com.example.diarymaker.entity.Tag;
import com.example.diarymaker.exception.ResourceNotFoundException;
import com.example.diarymaker.repository.TagRepository;
import com.example.diarymaker.request.TagRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public Tag getTag(long tagId){
        Tag tag = tagRepository.findById(tagId).orElseThrow(()->new ResourceNotFoundException("tag id not found"));
        return tag;
    }

    public Tag updateTag(long tagId, TagRequest tagRequest){
        if(tagRepository.existsById(tagId)){
            Tag tagToBeUpdated = new Tag(tagRequest);
            tagToBeUpdated.setId(tagId);
            return tagRepository.save(tagToBeUpdated);
        }
        else{
            throw new ResourceNotFoundException("tag id not found");
        }
    }

    public void deleteTag(long tagId){
        if(tagRepository.existsById(tagId)){
            tagRepository.deleteById(tagId);
        }
        else{
            throw new ResourceNotFoundException("tag id not found");
        }
    }
}
