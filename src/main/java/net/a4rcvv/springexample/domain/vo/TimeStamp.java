package net.a4rcvv.springexample.domain.vo;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotNull;

public record TimeStamp(
        @NotNull OffsetDateTime createdAt,
        @NotNull OffsetDateTime updatedAt) {
    public TimeStamp {
        if (createdAt.isAfter(updatedAt)) {
            throw new IllegalArgumentException("createdAt must be before updatedAt");
        }
    }

    public static TimeStamp now() {
        OffsetDateTime now = OffsetDateTime.now();
        return new TimeStamp(now, now);
    }

}
