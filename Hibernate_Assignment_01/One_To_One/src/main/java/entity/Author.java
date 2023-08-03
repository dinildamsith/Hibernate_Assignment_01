package entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Entity
public class Author {
    @Id
    private String author_id;
    private String author_name;
    private String birth_day;

    @OneToOne
    private Book book;

    public Author(){

    }

    public Author(String author_id, String author_name, String birth_day) {
        this.author_id = author_id;
        this.author_name = author_name;
        this.birth_day = birth_day;
    }
}
