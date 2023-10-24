package co.ex.domain.config;

import co.ex.domain.cmd.impl.DomainCommandSave;
import co.ex.domain.driven.cmd.handler.CommandBusDrivenApp;
import co.ex.domain.driven.cmd.handler.CommandBusDrivenAppTester;
import co.ex.domain.driving.cmd.bus.CommandBusDrivingDomain;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SetupMapBeansTest {

    SetupMapBeans setupMapBeans;
    Map<Class<?>, CommandBusDrivenApp<?> > cbDrivenApp_map = new HashMap<>();
    DomainCommandSave save;
    CommandBusDrivenAppTester tester;
    @BeforeEach
    void setUp() {
        tester = new CommandBusDrivenAppTester();
        save = DomainCommandSave.builder().thingNbr( 1L ).build();

        cbDrivenApp_map.put( DomainCommandSave.builder().build().getClass(), tester );
        MapBeans mapBeans = new MapBeans();
        mapBeans.postConstruct();
        setupMapBeans = new SetupMapBeans( mapBeans );
        setupMapBeans.setup();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void putCommandBusDrivenApp() {
        setupMapBeans.putCommandBusDrivenApp( cbDrivenApp_map );

        CommandBusDrivingDomain commandBusDrivingDomain = setupMapBeans.getCommandBusDrivingDomain();

        commandBusDrivingDomain.perform( save );
        assertEquals( 1L, ((DomainCommandSave)tester.getDomCommand()).getThingNbr() );
    }
}