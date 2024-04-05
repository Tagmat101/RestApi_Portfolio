package org.group.portfolio.Entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
@Data
@Builder
public class User
{
    @Id
    private int Id;
    private String name;

    public User(int id, String name) {
        Id = id;
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}