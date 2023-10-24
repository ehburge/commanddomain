package co.ex.domain.config;

import co.ex.domain.cmd.DomCommand;
import co.ex.domain.cmd.impl.DomainCommandSave;
import co.ex.domain.driven.cmd.bus.impl.CommandBusDrivenDomainImpl;
import co.ex.domain.driven.cmd.handler.CommandBusDrivenApp;
import co.ex.domain.driven.cmd.handler.impl.CommandHandlerDrivenDomainImpl;
import co.ex.domain.driving.cmd.bus.CommandBusDrivingDomain;
import co.ex.domain.driving.cmd.handler.impl.CommandHandlerDrivingDomainImpl;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@AllArgsConstructor
@Component
public class SetupMapBeans {

    private MapBeans mapBeans;

    @PostConstruct
    public void setup() {
        if (mapBeans == null) {
            mapBeans = new MapBeans();
        }
        var domainThingCommandSave = DomainCommandSave.builder().build();

        mapBeans
                .getChDrivingD_map()
                .put(
                        domainThingCommandSave.getClass(),
                        new CommandHandlerDrivingDomainImpl(mapBeans.getCbDrivenD_map()));
        mapBeans
                .getCbDrivenD_map()
                .put(
                        domainThingCommandSave.getClass(),
                        new CommandBusDrivenDomainImpl(mapBeans.getChDrivenD_map()));
        mapBeans
                .getChDrivenD_map()
                .put(
                        domainThingCommandSave.getClass(),
                        new CommandHandlerDrivenDomainImpl(mapBeans.getCbDrivenApp_map()) );
    }

    public void putCommandBusDrivenApp( Map<Class<?>, CommandBusDrivenApp<?>> cbDrivenApp_map) {
        mapBeans.loadCommandBusDrivenApp( cbDrivenApp_map);
    }

    public CommandBusDrivingDomain getCommandBusDrivingDomain() {
        return mapBeans.getCommandBusDrivingDomain();
    }

    public void setCommandHandlerDrivenDomain(Map<Class<? extends DomCommand>, CommandBusDrivenApp > cbDrivenApp_map) {
        mapBeans.setCommandHandlerDrivenDomain( cbDrivenApp_map );
    }
}
