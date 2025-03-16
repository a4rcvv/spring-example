package net.a4rcvv.springexample.infra.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import net.a4rcvv.springexample.domain.model.Comment;
import net.a4rcvv.springexample.domain.repository.CommentRepository;
import net.a4rcvv.springexample.domain.vo.CommentId;
import net.a4rcvv.springexample.infra.entity.CommentEntity;

@Repository
public class CommentRepositoryImpl implements CommentRepository {
  @NotNull
  private final JpaCommentRepository jpaCommentRepository;

  public CommentRepositoryImpl(@NotNull JpaCommentRepository jpaCommentRepository) {
    this.jpaCommentRepository = jpaCommentRepository;
  }

  @Override
  public List<Comment> find(@NotNull @Min(1) int limit, @NotNull @Min(0) int offset) {
    Pageable pageable = PageRequest.of(offset / limit, limit);
    return jpaCommentRepository.findAll(pageable).stream()
        .map(CommentEntity::toDomainModel)
        .collect(Collectors.toList());
  }

  @Override
  public Optional<Comment> findByCommentId(@NotNull CommentId id) {
    var result = jpaCommentRepository.findByCommentId(id.id());
    return result.map(CommentEntity::toDomainModel);
  }

  @Override
  public void save(@NotNull Comment comment) {
    jpaCommentRepository.save(CommentEntity.fromDomainModel(comment));
  }

}
