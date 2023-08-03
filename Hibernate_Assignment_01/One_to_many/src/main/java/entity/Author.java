package entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString

@Entity
public class Author {
    @Id
    private String author_id;
    private String author_name;


    @OneToMany(mappedBy = "authors")
    private List<Book> books;

    public Author(){

    }

    public Author(String author_id, String author_name, List<Book> books) {
        this.author_id = author_id;
        this.author_name = author_name;
        this.books = books;
    }
}
