package com.example.diarymaker.service;

import com.example.diarymaker.entity.Entry;
import com.example.diarymaker.exception.ResourceNotFoundException;
import com.example.diarymaker.repository.EntryRepository;
import com.example.diarymaker.request.EntryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService {
    @Autowired
    EntryRepository entryRepository;

    public List<Entry> getAllEntries(){
        //null/isBlank
        return (List<Entry>) entryRepository.findAll();
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
