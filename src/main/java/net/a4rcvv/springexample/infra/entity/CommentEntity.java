package net.a4rcvv.springexample.infra.entity;

import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import net.a4rcvv.springexample.domain.model.Comment;
import net.a4rcvv.springexample.domain.vo.CommentBody;
import net.a4rcvv.springexample.domain.vo.CommentId;
import net.a4rcvv.springexample.domain.vo.TimeStamp;

@Entity
@Getter
@Setter
@Table(name = "comments")
public class CommentEntity {

  @Id
  @GeneratedValue
  private Long pk;

  @Column(name = "comment_id", nullable = false, unique = true)
  private UUID commentId;

  @Column(name = "created_at", nullable = false, updatable = false)
  private OffsetDateTime createdAt;

  @Column(name = "updated_at", nullable = false)
  private OffsetDateTime updatedAt;

  @Column(name = "body", nullable = false)
  private String body;

  public Comment toDomainModel() {
    return new Comment(new CommentId(commentId), new TimeStamp(createdAt, updatedAt), new CommentBody(body));
  }

  public static CommentEntity fromDomainModel(Comment comment) {
    CommentEntity entity = new CommentEntity();
    entity.setCommentId(comment.getId().id());
    entity.setCreatedAt(comment.getTimeStamp().createdAt());
    entity.setUpdatedAt(comment.getTimeStamp().updatedAt());
    entity.setBody(comment.getBody().body());
    return entity;
  }

}
