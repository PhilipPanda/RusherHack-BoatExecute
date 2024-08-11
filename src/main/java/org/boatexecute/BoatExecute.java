package org.boatexecute;

import org.rusherhack.client.api.RusherHackAPI;
import org.rusherhack.client.api.plugin.Plugin;

/**
 * @Author PhilipPanda
 * @Credits John200410
 */
public class BoatExecute extends Plugin {

    @Override
    public void onLoad() {

        this.getLogger().info("Hello World!");

        final BoatExecuteModule exampleModule = new BoatExecuteModule();
        RusherHackAPI.getModuleManager().registerFeature(exampleModule);

    }

    @Override
    public void onUnload() {
        this.getLogger().info("Example plugin unloaded!");
    }

}