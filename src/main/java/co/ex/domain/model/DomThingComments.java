package co.ex.domain.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Builder(access = AccessLevel.PUBLIC)
public class DomThingComments {
  private List<String> comments;
}
