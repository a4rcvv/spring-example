package net.a4rcvv.springexample.infra.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import net.a4rcvv.springexample.infra.entity.CommentEntity;

@Repository
public interface JpaCommentRepository extends JpaRepository<CommentEntity, UUID> {
  @NonNull
  Page<CommentEntity> findAll(@NonNull Pageable pageable);
}
