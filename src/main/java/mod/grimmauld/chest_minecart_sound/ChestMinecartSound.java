package mod.grimmauld.chest_minecart_sound;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ChestMinecartSound.MODID)
@SuppressWarnings("unused")
public class ChestMinecartSound {
    public static final String MODID = "chest_minecart_sound";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public ChestMinecartSound() {
        MinecraftForge.EVENT_BUS.register(new EventListener());
    }
}
