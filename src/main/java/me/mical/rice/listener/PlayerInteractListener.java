package me.mical.rice.listener;

import me.mical.rice.Rice;
import me.mical.rice.items.RiceSeed;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.serverct.parrot.parrotx.data.autoload.annotations.PAutoload;

@PAutoload
public class PlayerInteractListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInteract(final PlayerInteractEvent event) {
        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        if (event.getHand().equals(EquipmentSlot.HAND)) {
            if (event.getClickedBlock().getType().equals(Material.FARMLAND)) {
                if (event.getPlayer().getEquipment() != null) {
                    if (event.getPlayer().getEquipment().getItemInMainHand().isSimilar(RiceSeed.to())) {
                        Rice.getDao().create(
                                event.getClickedBlock().getWorld().getName(),
                                event.getClickedBlock().getX(),
                                event.getClickedBlock().getY() + 1,
                                event.getClickedBlock().getZ()
                        );
                        event.setCancelled(true);
                        event.getClickedBlock().getRelative(BlockFace.UP).setType(Material.WHEAT);
                        event.getPlayer().getEquipment().getItemInMainHand().setAmount(
                                event.getPlayer().getEquipment().getItemInMainHand().getAmount() - 1
                        );
                    }
                }
            }
        }
    }
}
