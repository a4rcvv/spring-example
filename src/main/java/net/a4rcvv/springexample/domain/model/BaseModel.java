package net.a4rcvv.springexample.domain.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

/**
 * Base model class
 * 
 * @param <T> Type of the id
 */
@Getter
public abstract class BaseModel<T> {
  @NotNull
  private T id;

  public BaseModel(@NotNull T id) {
    this.id = id;
  }

  public boolean equals(@NotNull Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    BaseModel<?> baseModel = (BaseModel<?>) o;
    return id.equals(baseModel.id);
  }

}
