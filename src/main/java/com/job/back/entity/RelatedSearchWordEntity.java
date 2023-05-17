package com.job.back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="RelatedSearchWord")
@Table(name="RelatedSearchWord")
public class RelatedSearchWordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sequence;
    private String searchWord;
    private String previousSearchWord;

    public RelatedSearchWordEntity(String searchWord, String previousSearchWord) {
        this.searchWord = searchWord;
        this.previousSearchWord = previousSearchWord;
    }

}
