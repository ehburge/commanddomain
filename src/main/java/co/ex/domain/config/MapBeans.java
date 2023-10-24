package co.ex.domain.config;

import co.ex.domain.cmd.DomCommand;
import co.ex.domain.driven.cmd.bus.CommandBusDrivenDomain;
import co.ex.domain.driven.cmd.bus.impl.CommandBusDrivenDomainImpl;
import co.ex.domain.driven.cmd.handler.CommandBusDrivenApp;
import co.ex.domain.driven.cmd.handler.CommandHandlerDrivenDomain;
import co.ex.domain.driven.cmd.handler.impl.CommandHandlerDrivenDomainImpl;
import co.ex.domain.driving.cmd.bus.CommandBusDrivingDomain;
import co.ex.domain.driving.cmd.bus.impl.CommandBusDrivingDomainImpl;
import co.ex.domain.driving.cmd.handler.CommandHandlerDrivingDomain;
import co.ex.domain.driving.cmd.handler.impl.CommandHandlerDrivingDomainImpl;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
class MapBeans {

  @Getter private Map<Class<?>, CommandHandlerDrivingDomain<?>> chDrivingD_map = new HashMap<>();
  @Getter private Map<Class<?>, CommandBusDrivenDomain> cbDrivenD_map = new HashMap<>();
  @Getter private Map<Class<?>, CommandHandlerDrivenDomain<?>> chDrivenD_map = new HashMap<>();
  @Getter private Map<Class<?>, CommandBusDrivenApp> cbDrivenApp_map = new HashMap<>();

  private CommandBusDrivingDomain commandBusDrivingDomain;
  private CommandHandlerDrivingDomain<?> commandHandlerDrivingDomain;
  private CommandBusDrivenDomain<?> commandBusDrivenDomain;
  private CommandHandlerDrivenDomain<?> commandHandlerDrivenDomain;

  @PostConstruct
  public void postConstruct() {
    commandBusDrivingDomain = new CommandBusDrivingDomainImpl(chDrivingD_map);
    commandHandlerDrivingDomain = new CommandHandlerDrivingDomainImpl(cbDrivenD_map);
    commandBusDrivenDomain = new CommandBusDrivenDomainImpl(chDrivenD_map);
    commandHandlerDrivenDomain = new CommandHandlerDrivenDomainImpl(cbDrivenApp_map);
  }

  public CommandBusDrivingDomain getCommandBusDrivingDomain() {
    return commandBusDrivingDomain;
  }

  public void setCommandHandlerDrivenDomain(Map<Class<? extends DomCommand>, CommandBusDrivenApp > cbDrivenApp_map ) {
    this.cbDrivenApp_map.putAll( cbDrivenApp_map );
  }

  public CommandHandlerDrivenDomain<?> loadCommandBusDrivenApp(
      Map<Class<?>, CommandBusDrivenApp<?>> cbDrivenApp_map) {

    cbDrivenApp_map.forEach(
        (key, value) -> {
          this.getCbDrivenApp_map().put(key, value);
        });

    return commandHandlerDrivenDomain;
  }
}
