package com.example.weblab4.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Setter
@Getter
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String phone;
    private String name;
}
