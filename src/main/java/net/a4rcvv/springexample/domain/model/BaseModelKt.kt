package net.a4rcvv.springexample.domain.model

abstract class BaseModelKt<T>(private val id: T) {
  override fun equals(other: Any?): Boolean {
    if (other == null || javaClass != other.javaClass) return false
    other as BaseModelKt<*>
    return id == other.id
  }
}
