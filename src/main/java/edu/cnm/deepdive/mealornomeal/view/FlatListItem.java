package edu.cnm.deepdive.mealornomeal.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.net.URI;
import org.springframework.lang.NonNull;


  @JsonPropertyOrder(value = {"id", "name", "quantity", "href"})
  public interface FlatListItem {

    Long getId();

    @NonNull
    String getListItem();

    URI getHref();

  }
