package mod.grimmauld.chest_minecart_sound;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.minecart.ChestMinecartEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@SuppressWarnings("unused")
public class EventListener {
    @SubscribeEvent
    public void onPlayerInteractWithEntity(PlayerInteractEvent.EntityInteract event) {
        Entity entity = event.getTarget();
        World world = entity.getEntityWorld();
        if (!(entity instanceof ChestMinecartEntity))
            return;
        world.playSound(null, entity.getPosX() + 0.5D, entity.getPosY() + 0.5D, entity.getPosZ() + 0.5D, SoundEvents.BLOCK_CHEST_OPEN, SoundCategory.BLOCKS, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
    }

    @SubscribeEvent
    public void onPlayerCloseGui(PlayerContainerEvent.Close event) {
        if (!(event.getContainer() instanceof ChestContainer))
            return;
        IInventory inventory = ((ChestContainer) event.getContainer()).getLowerChestInventory();
        if (!(inventory instanceof ChestMinecartEntity))
            return;
        ChestMinecartEntity entity = (ChestMinecartEntity) inventory;
        World world = event.getEntity().getEntityWorld();
        world.playSound(null, entity.getPosX() + 0.5D, entity.getPosY() + 0.5D, entity.getPosZ() + 0.5D, SoundEvents.BLOCK_CHEST_CLOSE, SoundCategory.BLOCKS, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
    }
}
