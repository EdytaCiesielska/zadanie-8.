package pl.devopsi.akademia.springdata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor

@NoArgsConstructor
@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String privacy;
    private String uploaderName;
    private String uploaderPhoneNum;
    private String uploaderEmail;
    private String uploaderAddress;
    private String view;

    @OneToOne (mappedBy = "photo", cascade = CascadeType.ALL)
    private UploadHistory uploadHistory;

   @ManyToOne
   private Album album;

   @ManyToMany
   private Set<Tag> tags;

}
