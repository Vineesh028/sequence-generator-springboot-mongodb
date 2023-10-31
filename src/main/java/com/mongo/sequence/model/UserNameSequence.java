package com.mongo.sequence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Setter
@Document(collection = "username_sequences")
public class UserNameSequence {

    @Id
    private String id;

    private long seq;
    
    private String userName;
    
}