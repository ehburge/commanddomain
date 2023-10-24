package co.ex.domain.driven.cmd.bus.impl;

import co.ex.domain.cmd.DomCommand;
import co.ex.domain.driven.cmd.bus.CommandBusDrivenDomain;
import co.ex.domain.driven.cmd.handler.CommandHandlerDrivenDomain;

import java.util.Map;

//@RequiredArgsConstructor
public class CommandBusDrivenDomainImpl implements CommandBusDrivenDomain {

  private final Map<Class<?>, CommandHandlerDrivenDomain<?> > chDrivenD_map;

  public CommandBusDrivenDomainImpl( Map< Class< ? >, CommandHandlerDrivenDomain< ? > > commandHandlerDrivenDomainMap ) {
    this.chDrivenD_map = commandHandlerDrivenDomainMap;
  }

  @Override
  public void perform( DomCommand domCommand) {
    // 5
    CommandHandlerDrivenDomain<?> commandHandlerDrivenDomain =
        chDrivenD_map.get(domCommand.getClass());
    commandHandlerDrivenDomain.handle(domCommand);
  }
}
