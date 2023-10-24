package co.ex.domain.driving.cmd.bus.impl;

import co.ex.domain.cmd.DomCommand;
import co.ex.domain.driving.cmd.bus.CommandBusDrivingDomain;

public class CommandBusDrivingDomainTester implements CommandBusDrivingDomain {

  DomCommand cmd;

  @Override
  public void perform(DomCommand domCommand) {
    cmd = domCommand;
  }

  public DomCommand getCommand() {
    return cmd;
  }
}
