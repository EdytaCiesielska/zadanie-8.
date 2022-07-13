package pl.devopsi.akademia.springdata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Service
public class PhotoService {
    private final JpaPhotoRepository photoRepository;
    private final JpaAlbumRepository albumRepository;
    private final JpaTagRepository tagRepository;

     public void addPhoto(Photo photo, Long id, Long tag_id){

        Album album = albumRepository.findById(id).get();
        Set<Photo> photos = new HashSet<>();

        Tag tag = tagRepository.findById(tag_id).get();
        Set<Tag> tags = new HashSet<>();

        UploadHistory uploadHistory = new UploadHistory();
        Date nowDate = new Date();
        uploadHistory.setDate(nowDate);
        photo.setUploadHistory(uploadHistory);
        uploadHistory.setPhoto(photo);

        photo.setAlbum(album);
        album.setPhotos(photos);

        tags.add(tag);
        tag.setPhotos(photos);
        photo.setTags(tags);

        photos.add(photo);
        albumRepository.save(album);
      //  photoRepository.save(photo);
    }

    public void updatePhoto(Long id, Photo photo){
        if (photoRepository.existsById(id)){
            Photo changedPhoto = photoRepository.findById(id).get();
            changedPhoto.setTitle(photo.getTitle());
            changedPhoto.setDescription(photo.getDescription());
            changedPhoto.setPrivacy(photo.getPrivacy());
            changedPhoto.setUploaderName(photo.getUploaderName());
            changedPhoto.setUploaderAddress(photo.getUploaderAddress());
            changedPhoto.setUploaderEmail(photo.getUploaderEmail());
            changedPhoto.setUploaderPhoneNum(photo.getUploaderPhoneNum());
            changedPhoto.setView(photo.getView());
            photoRepository.save(changedPhoto);
        }
    }

    public void deletePhoto(Long id){
        photoRepository.deleteById(id);
    }

    public List<Photo> getPhotos(){
        return photoRepository.findAll();
    }

}

