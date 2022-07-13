package pl.devopsi.akademia.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommentRepository extends JpaRepository<Comment,Long> {
}
