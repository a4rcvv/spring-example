package net.a4rcvv.springexample.presentation.response;

import java.util.List;

public record QueryResult<T>(List<T> data, int total) {

}
