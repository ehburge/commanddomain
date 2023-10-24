package co.ex.domain.driving.cmd.handler.impl;

import co.ex.domain.cmd.DomCommand;
import co.ex.domain.driven.cmd.bus.CommandBusDrivenDomain;
import co.ex.domain.driving.cmd.bus.CommandBusDrivingDomain;
import co.ex.domain.driving.cmd.handler.CommandHandlerDrivingDomain;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class CommandHandlerDrivingDomainImpl implements CommandHandlerDrivingDomain {

  private final Map<Class<?>, CommandBusDrivenDomain > cbDriven;

  @Override
  public void handle(DomCommand domCommand) {
    // 4
    cbDriven.get(domCommand.getClass()).perform(domCommand);
  }
}
