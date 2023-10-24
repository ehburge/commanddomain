package co.ex.domain.driving.cmd.handler;

import co.ex.domain.cmd.DomCommand;
import co.ex.domain.cmd.DomCommandHandler;

public interface CommandHandlerDrivingDomain<C extends DomCommand> extends DomCommandHandler {
    void handle(C command);
}
