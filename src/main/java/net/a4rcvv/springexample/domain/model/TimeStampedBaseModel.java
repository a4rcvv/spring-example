package net.a4rcvv.springexample.domain.model;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import net.a4rcvv.springexample.domain.vo.TimeStamp;

/**
 * Base model class with timestamp
 * 
 * @param <T> Type of the id
 */
@Getter
public abstract class TimeStampedBaseModel<T> extends BaseModel<T> {
  @NotNull
  private TimeStamp timeStamp;

  public TimeStampedBaseModel(@NotNull T id, @NotNull TimeStamp timeStamp) {
    super(id);
    this.timeStamp = timeStamp;
  }

  public void update(@NotNull OffsetDateTime updatedAt) {
    this.timeStamp = new TimeStamp(timeStamp.createdAt(), updatedAt);
  }

  public void updateAsNow() {
    OffsetDateTime now = OffsetDateTime.now();
    this.update(now);
  }

}
