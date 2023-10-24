package co.ex.domain.driving.cmd.bus.impl;

import co.ex.domain.cmd.DomCommand;
import co.ex.domain.driving.cmd.bus.CommandBusDrivingDomain;
import co.ex.domain.driving.cmd.handler.CommandHandlerDrivingDomain;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class CommandBusDrivingDomainImpl implements CommandBusDrivingDomain {

  private final Map<Class<?>, CommandHandlerDrivingDomain<?>> commandHandlerDrivingDomainMap;

  @Override
  public void perform(DomCommand domCommand) {
    // 3
    CommandHandlerDrivingDomain chdd = commandHandlerDrivingDomainMap.get(domCommand.getClass());

    chdd.handle(domCommand);
  }
}
