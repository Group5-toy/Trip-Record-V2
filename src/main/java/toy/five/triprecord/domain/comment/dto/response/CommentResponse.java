package toy.five.triprecord.domain.comment.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import toy.five.triprecord.domain.comment.entity.Comment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CommentResponse {

    private Long id;
    private String comment;
    private String createdDate = LocalDateTime.now()
        .format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
    private String modifiedDate = LocalDateTime
        .now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
    private String nickname;
    private Long tripId;

    public static CommentResponse fromEntity(Comment comment) {
        return CommentResponse.builder()
            .id(comment.getId())
            .comment(comment.getComment())
            .nickname(comment.getUser().getName())
            .tripId(comment.getTrip().getId())
            .build();
    }
}
