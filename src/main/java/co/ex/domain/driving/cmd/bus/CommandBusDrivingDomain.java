package co.ex.domain.driving.cmd.bus;

import co.ex.domain.cmd.DomCommand;
import co.ex.domain.cmd.DomCommandBus;

public interface CommandBusDrivingDomain extends DomCommandBus {
    void perform(DomCommand command);
}
