package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private EncodingType encodingType;

    @OneToOne(mappedBy = "title")
    private Book book;

    public Title(String name, EncodingType encodingType) {
        this.name = name;
        this.encodingType = encodingType;
    }

    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", encodingType=" + encodingType +
//                ", book=" + book.getAuthor() +
                '}';
    }
}
