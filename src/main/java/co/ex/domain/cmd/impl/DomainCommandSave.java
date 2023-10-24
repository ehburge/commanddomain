package co.ex.domain.cmd.impl;

import co.ex.domain.cmd.DomCommand;
import co.ex.domain.model.DomRole;
import co.ex.domain.model.DomThingComments;
import co.ex.domain.model.DomThingParts;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Builder
public class DomainCommandSave implements DomCommand {

    private UUID uuid;
    @Setter
    private Long id;
    private DomRole role;
    private String eventKind;
    private String promoCodes;
    private String partsCompatibility;
    private DomThingComments comments;
    private DomThingParts parts;
}
