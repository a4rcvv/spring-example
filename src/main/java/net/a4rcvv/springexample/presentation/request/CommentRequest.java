package net.a4rcvv.springexample.presentation.request;

import jakarta.validation.constraints.NotNull;

public record CommentRequest(@NotNull String body) {

}
