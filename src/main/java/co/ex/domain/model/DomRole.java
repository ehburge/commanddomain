package co.ex.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DomRole {

  private final Long actorId;
  private final String groupId;
  private final String loyaltyCode;
}
