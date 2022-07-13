package pl.devopsi.akademia.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPhotoRepository extends JpaRepository<Photo, Long> {
}
