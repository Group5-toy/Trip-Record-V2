package toy.five.triprecord.domain.comment.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import toy.five.triprecord.domain.comment.entity.Comment;
import toy.five.triprecord.domain.trip.entity.Trip;
import toy.five.triprecord.domain.user.entity.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CommentRequest {

    private Long id;
    private String comment;
    private String createdDate = LocalDateTime.now()
        .format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
    private String modifiedDate = LocalDateTime
        .now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
    private User user;
    private Trip trip;

    public Comment toEntity() {
        return Comment.builder()
            .id(id)
            .comment(comment)
            .user(user)
            .trip(trip)
            .build();
    }
}
