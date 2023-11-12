package toy.five.triprecord.domain.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toy.five.triprecord.domain.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
