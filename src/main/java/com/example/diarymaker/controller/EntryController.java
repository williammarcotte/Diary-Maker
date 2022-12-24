package com.example.diarymaker.controller;

import com.example.diarymaker.entity.Entry;
import com.example.diarymaker.entity.Tag;
import com.example.diarymaker.request.EntryRequest;
import com.example.diarymaker.request.TagRequest;
import com.example.diarymaker.response.EntryResponse;
import com.example.diarymaker.response.TagResponse;
import com.example.diarymaker.service.EntryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/entries")
public class EntryController {

    @Autowired
    EntryService entryService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{entry_id}/tags")
    public TagResponse addTag(
            @PathVariable long entry_id,
            @Valid @RequestBody TagRequest tagRequest
            ){
        return new TagResponse(entryService.addTag(entry_id, tagRequest));
    }

    @GetMapping("{entryId}/tags")
    public List<TagResponse> getAllTags(@PathVariable long entryId){
        List<Tag> tags = entryService.getAllTags(entryId);
        List<TagResponse> tagResponses = new ArrayList<>();
        for(int i=0; i < tags.size();i++){
            tagResponses.add(new TagResponse(tags.get(i)));
        }
        return tagResponses;
    }

    @DeleteMapping("{entryId}/tags")
    public void deleteAllTags(@PathVariable long entryId){entryService.deleteAllTags(entryId);}

    @GetMapping()// /"entryId"/tags
    public List<EntryResponse> getAllEntries(@RequestParam(required = false) String title){
        List<Entry> entries = entryService.getAllEntries(title);

        List<EntryResponse> entryResponse = new ArrayList<>();
        entries.forEach(entry ->{
            entryResponse.add(new EntryResponse(entry));
        });

        return entryResponse;
    }

    @PostMapping()//"/{entry_id}/tags"
    @ResponseStatus(HttpStatus.CREATED)
    public EntryResponse addEntry(@RequestBody EntryRequest entryRequest){
        Entry savedEntry = entryService.addEntry(entryRequest);

        return new EntryResponse(savedEntry);
    }


    @PutMapping("/{id}")
    public EntryResponse updateEntry
            (@PathVariable long id,
             @Valid @RequestBody EntryRequest entryRequest){
        Entry updatedEntry = entryService.updateEntry(id, entryRequest);
        return new EntryResponse(updatedEntry);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable long id){
        entryService.deleteEntry(id);
    }


}

