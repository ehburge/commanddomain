package co.ex.domain.driven.cmd.handler.impl;

import co.ex.domain.cmd.DomCommand;
import co.ex.domain.driven.cmd.handler.CommandBusDrivenApp;
import co.ex.domain.driven.cmd.handler.CommandHandlerDrivenDomain;
import lombok.RequiredArgsConstructor;

import java.util.Map;

//@RequiredArgsConstructor
public class CommandHandlerDrivenDomainImpl implements CommandHandlerDrivenDomain {

  private final Map<Class<?>, CommandBusDrivenApp > cbDrivenApp_map;

  public CommandHandlerDrivenDomainImpl( Map< Class< ? >, CommandBusDrivenApp > cbDrivenApp_map ) {
    this.cbDrivenApp_map = cbDrivenApp_map;
  }

  @Override
  public void handle( DomCommand domCommand) {
    // 6
    cbDrivenApp_map.get(domCommand.getClass()).perform(domCommand);
  }
}
