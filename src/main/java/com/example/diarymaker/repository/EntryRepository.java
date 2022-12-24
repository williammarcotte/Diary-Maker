package com.example.diarymaker.repository;

import com.example.diarymaker.entity.Entry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends CrudRepository<Entry,Long> {
    List<Entry> findAllByTitle(String title);
}
