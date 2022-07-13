package pl.devopsi.akademia.springdata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor

@NoArgsConstructor
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String view;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private Set<Photo> photos;
}
