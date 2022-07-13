package pl.devopsi.akademia.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAlbumRepository extends JpaRepository<Album, Long> {
}
