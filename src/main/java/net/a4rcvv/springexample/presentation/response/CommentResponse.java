package net.a4rcvv.springexample.presentation.response;

import java.time.OffsetDateTime;
import java.util.UUID;

public record CommentResponse(UUID id, String body, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
}
