package co.ex.domain.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder(access = AccessLevel.PUBLIC)
public class DomThingPart {

  private final String partId;
  private final int qty;
  private final String lineAction;
  private final String promoCodes;
}
