package co.ex.domain.driven.cmd.handler;

import co.ex.domain.cmd.DomCommand;
import co.ex.domain.cmd.DomCommandApp;

public interface CommandBusDrivenApp< C extends DomCommand> extends DomCommandApp {
    void perform(DomCommand domCommand);
}
