package com.example.diarymaker.entity;

import com.example.diarymaker.request.TagRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="tags")
public class Tag {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String text;

    public Tag(TagRequest tagRequest){

    }

}
