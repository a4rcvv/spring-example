package net.a4rcvv.springexample.domain.vo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CommentBody(@NotNull @Size(max = 100) String body) {

}
