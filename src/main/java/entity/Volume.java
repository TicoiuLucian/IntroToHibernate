package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Volume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer volumeNumber;

    private String volumeName;


    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "book_id")
    @JoinTable(
            name = "Volume_Book",
            joinColumns = @JoinColumn(name = "Volume_ID"),
            inverseJoinColumns = @JoinColumn(name = "Book_id"))
    private Book book;


    public Volume(Integer volumeNumber, String volumeName) {
        this.volumeNumber = volumeNumber;
        this.volumeName = volumeName;
    }
}
