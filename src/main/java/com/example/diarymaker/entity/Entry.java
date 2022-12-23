package com.example.diarymaker.entity;


import com.example.diarymaker.request.EntryRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="entries")
@Getter
@Setter
@NoArgsConstructor
public class Entry {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="title",nullable = false)
    private String title;
    @Column(name="content",nullable = false)
    private String content;

    //@OneToMany(cascade = CascadeType.ALL, optional = true) //??? for tags

    public Entry(EntryRequest entryRequest){
        title = entryRequest.getTitle();
        content = entryRequest.getContent();
    }
}
