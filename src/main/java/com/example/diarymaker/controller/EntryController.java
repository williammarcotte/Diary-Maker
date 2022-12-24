package com.example.diarymaker.controller;

import com.example.diarymaker.entity.Entry;
import com.example.diarymaker.request.EntryRequest;
import com.example.diarymaker.response.EntryResponse;
import com.example.diarymaker.service.EntryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@CrossOrigin("*")a
@RequestMapping("api/entries")
public class EntryController {

    @Autowired
    EntryService entryService;

    @GetMapping()// /"entryId"/tags
    public List<EntryResponse> getAllEntries(){
        List<Entry> entries = entryService.getAllEntries();

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
