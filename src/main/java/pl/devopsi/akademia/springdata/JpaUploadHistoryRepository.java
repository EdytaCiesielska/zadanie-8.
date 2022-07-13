package pl.devopsi.akademia.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUploadHistoryRepository extends JpaRepository<UploadHistory,Long> {
}
