package co.ex.domain.config;

import co.ex.domain.cmd.impl.DomainCommandSave;
import co.ex.domain.driven.cmd.handler.CommandBusDrivenAppTester;
import co.ex.domain.driven.cmd.handler.impl.CommandHandlerDrivenDomainImpl;
import co.ex.domain.driving.cmd.bus.CommandBusDrivingDomain;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapBeansTest {

  MapBeans mapBeans;

  @BeforeEach
  void setUp() {
    mapBeans = new MapBeans();
    mapBeans.postConstruct();
  }

  @AfterEach
  void tearDown() {}

  @Test
  void commandHandlerDrivenDomain() {
    var domainThingCommandSave = DomainCommandSave.builder().build();

//    mapBeans
//        .getChDrivingD_map()
//        .put(
//            domainThingCommandSave.getClass(),
//            new CommandHandlerDrivingDomainImpl(mapBeans.getCbDrivenD_map()));
//    mapBeans
//        .getCbDrivenD_map()
//        .put(
//            domainThingCommandSave.getClass(),
//            new CommandBusDrivenDomainImpl(mapBeans.getChDrivenD_map()));
    mapBeans
            .getChDrivenD_map()
            .put(
                    domainThingCommandSave.getClass(),
                    new CommandHandlerDrivenDomainImpl(mapBeans.getCbDrivenApp_map()) );

    CommandBusDrivenAppTester busDrivenAppTester = new CommandBusDrivenAppTester();
    mapBeans.getCbDrivenApp_map().put(DomainCommandSave.class, busDrivenAppTester);

    DomainCommandSave domainCommandSaveTest =
        DomainCommandSave.builder().thingNbr(1L).build();
    CommandBusDrivingDomain commandBusDrivingDomain = mapBeans.getCommandBusDrivingDomain();
    commandBusDrivingDomain.perform(domainCommandSaveTest);

    assertEquals(1L, ((DomainCommandSave) busDrivenAppTester.getDomCommand()).getThingNbr());
  }
}
