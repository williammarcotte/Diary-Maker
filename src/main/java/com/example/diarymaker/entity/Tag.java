package com.example.diarymaker.entity;

import com.example.diarymaker.request.TagRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @ManyToOne//(optional = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JoinColumn(name = "entry_id")
    private Entry entry;

    public Tag(TagRequest tagRequest){
        text = tagRequest.getText();
    }

}
