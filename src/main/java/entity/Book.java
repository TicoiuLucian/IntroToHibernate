package entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "book")
@Table(name = "CARTI")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Title title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private List<Volume> volumes = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Author> authors = new ArrayList<>();

    public void addVolumeToBook(Volume volume) {
        this.volumes.add(volume);
        volume.setBook(this);
    }

    public void removeVolumeFromBook(Volume volume) {
        this.volumes.remove(volume);
        volume.setBook(null);
    }

    public void addAuthorToBook(Author author) {
        this.authors.add(author);
        author.addBookToAuthor(this);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
//                ", authors=" + authors +
                ", title=" + title.getName() +
                '}';
    }
}

