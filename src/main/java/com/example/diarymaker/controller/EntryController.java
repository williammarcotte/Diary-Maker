package com.example.diarymaker.controller;

import com.example.diarymaker.entity.Entry;
import com.example.diarymaker.request.EntryRequest;
import com.example.diarymaker.response.EntryResponse;
import com.example.diarymaker.service.EntryService;
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

    @GetMapping()//unsure
    public List<EntryResponse> getAllEntries(){
        List<Entry> entries = entryService.getAllEntries();

        List<EntryResponse> entryResponse = new ArrayList<>();
        entries.forEach(entry ->{
            entryResponse.add(new EntryResponse(entry));
        });

        return entryResponse;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntryResponse addEntry(@RequestBody EntryRequest entryRequest){
        Entry savedEntry = entryService.addEntry(entryRequest);

        return new EntryResponse(savedEntry);
    }


}
