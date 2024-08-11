package org.boatexecute;

import net.minecraft.network.protocol.game.ServerboundMoveVehiclePacket;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.phys.Vec3;
import org.rusherhack.client.api.feature.module.ModuleCategory;
import org.rusherhack.client.api.feature.module.ToggleableModule;


/**
 * @Author PhilipPanda
 * @Credits John200410
 */
public class BoatExecuteModule extends ToggleableModule {

    public BoatExecuteModule() {
        super("BoatExecute", "Instantly kills by exploiting boat movement packets", ModuleCategory.MISC);
    }


    @Override
    public void onEnable() {
        if (!(mc.player.getVehicle() instanceof Boat boat)) return;
        Vec3 originalPos = boat.position();
        boat.setPos(originalPos.add(0, 0.05, 0));
        ServerboundMoveVehiclePacket groundPacket = new ServerboundMoveVehiclePacket(boat);
        boat.setPos(originalPos.add(0, 20, 0));
        ServerboundMoveVehiclePacket skyPacket = new ServerboundMoveVehiclePacket(boat);
        boat.setPos(originalPos);
        for (int i = 0; i < 20; i++) {
            mc.player.connection.send(skyPacket);
            mc.player.connection.send(groundPacket);
        }
        mc.player.connection.send(new ServerboundMoveVehiclePacket(boat));
        this.toggle();
    }

    @Override
    public void onDisable() {
    }
}
