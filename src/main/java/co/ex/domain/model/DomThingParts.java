package co.ex.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Builder
public class DomThingParts {

  private String partsCompatibility;
  private List<DomThingPart> parts;
}
