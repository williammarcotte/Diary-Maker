package com.example.diarymaker.repository;

import com.example.diarymaker.entity.Entry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends CrudRepository<Entry,Long> {

}
