// 
// Decompiled by Procyon v0.5.30
// 

package com.bdoemu.core.network.receivable;

import com.bdoemu.commons.network.ReceivablePacket;
import com.bdoemu.core.network.GameClient;
import com.bdoemu.gameserver.model.creature.npc.worker.events.StopPlantWorkingToNpcWorkerEvent;
import com.bdoemu.gameserver.model.creature.player.Player;

public class CMStopPlantWorkingToNpcWorker extends ReceivablePacket<GameClient> {
    private long objectId;

    public CMStopPlantWorkingToNpcWorker(final short opcode) {
        super(opcode);
    }

    protected void read() {
        this.objectId = this.readQ();
    }

    public void runImpl() {
        final Player player = ((GameClient) this.getClient()).getPlayer();
        if (player != null) {
            player.getNpcWorkerController().onEvent(new StopPlantWorkingToNpcWorkerEvent(player, this.objectId));
        }
    }
}
