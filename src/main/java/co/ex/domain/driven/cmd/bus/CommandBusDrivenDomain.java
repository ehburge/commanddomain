package co.ex.domain.driven.cmd.bus;

import co.ex.domain.cmd.DomCommand;
import co.ex.domain.cmd.DomCommandBus;

public interface CommandBusDrivenDomain<C extends DomCommand> extends DomCommandBus {
    void perform( DomCommand command);
}
