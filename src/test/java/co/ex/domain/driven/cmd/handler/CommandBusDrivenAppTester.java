package co.ex.domain.driven.cmd.handler;

import co.ex.domain.cmd.DomCommand;
import lombok.Getter;

@Getter
public class CommandBusDrivenAppTester implements CommandBusDrivenApp {

  DomCommand domCommand;

  @Override
  public void perform(DomCommand domCommand) {
    this.domCommand = domCommand;
  }
}
