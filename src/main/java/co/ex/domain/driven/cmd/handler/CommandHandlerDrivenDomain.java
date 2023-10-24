package co.ex.domain.driven.cmd.handler;

import co.ex.domain.cmd.DomCommand;
import co.ex.domain.cmd.DomCommandHandler;

public interface CommandHandlerDrivenDomain<C extends DomCommand> extends DomCommandHandler {
    void handle( DomCommand command);
}
