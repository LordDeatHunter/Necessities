package wraith.necessities;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import wraith.necessities.command.CommandRegistry;

public class Necessities implements ModInitializer {

    public static final String MOD_ID = "necessities";
    public static final String MOD_NAME = "Necessities";
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {
        registerEvents();
        LOGGER.info("[" + MOD_NAME + "] has been initiated.");
    }

    private void registerEvents() {
        CommandRegistry.registerAllCommands();
    }

}
