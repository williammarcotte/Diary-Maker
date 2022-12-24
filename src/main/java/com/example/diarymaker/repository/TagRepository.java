package com.example.diarymaker.repository;

import com.example.diarymaker.entity.Tag;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends CrudRepository<Tag,Long> {
    List<Tag> findAllByEntryId(long id);
    @Transactional//
    void deleteAllByEntryId(long id);
}
