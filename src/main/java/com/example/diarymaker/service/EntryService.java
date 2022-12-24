package com.example.diarymaker.service;

import com.example.diarymaker.entity.Entry;
import com.example.diarymaker.entity.Tag;
import com.example.diarymaker.exception.ResourceNotFoundException;
import com.example.diarymaker.repository.EntryRepository;
import com.example.diarymaker.repository.TagRepository;
import com.example.diarymaker.request.EntryRequest;
import com.example.diarymaker.request.TagRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService {
    @Autowired
    EntryRepository entryRepository;
    @Autowired
    TagRepository tagRepository;

    public Tag addTag(long entry_id, TagRequest entryRequest){//valid?
        Entry entry = entryRepository.findById(entry_id).orElseThrow(()->new ResourceNotFoundException("entry id not found"));

        Tag tagToBeSaved = new Tag(new TagRequest());
        tagToBeSaved.setEntry(entry);

        return tagRepository.save(tagToBeSaved);
    }

    public List<Tag> getAllTags(long entryId){return tagRepository.findAllByEntryId(entryId);}

    public void deleteAllTags(long entryId){
        if(entryRepository.existsById(entryId)){
            tagRepository.deleteAllByEntryId(entryId);
        }
        else{
            throw new ResourceNotFoundException("entry id not found");
        }
    }

    public List<Entry> getAllEntries(String title){
        if(title == null || title.isEmpty())
        return (List<Entry>) entryRepository.findAll();
        else{
            return entryRepository.findAllByTitle(title);
        }
    }

    public Entry addEntry(EntryRequest entryRequest){
        Entry entry = new Entry(entryRequest);

        return entryRepository.save(entry);
    }

    public Entry updateEntry(long entryId, EntryRequest entryRequest){
        entryRepository.findById(entryId)
                .orElseThrow(()->new ResourceNotFoundException("Entry id is not found"));

        Entry entryToBeUpdated = new Entry(entryRequest);
        entryToBeUpdated.setId(entryId);

        return entryRepository.save(entryToBeUpdated);
    }
    public void deleteEntry(long entryId){
        if(entryRepository.existsById(entryId)){
            entryRepository.deleteById(entryId);
        }
        else{
            throw new ResourceNotFoundException("Entry Id not found");
        }
    }
}
