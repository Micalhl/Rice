package me.mical.rice.listener;

import me.mical.rice.Rice;
import me.mical.rice.config.SettingsConf;
import me.mical.rice.items.RiceLi;
import me.mical.rice.items.RiceSeed;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.serverct.parrot.parrotx.data.autoload.annotations.PAutoload;

import java.util.Random;

@PAutoload
public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBreak(final BlockBreakEvent event) {
        if (event.getBlock().getType().equals(Material.TALL_GRASS)) {
            if (Math.random() <= SettingsConf.seedDropChance) {
                event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), RiceSeed.to());
            }
        }
        if (event.getBlock().getType().equals(Material.WHEAT)) {
            if (Rice.getDao().isPlant(
                    event.getBlock().getWorld().getName(),
                    event.getBlock().getX(),
                    event.getBlock().getY(),
                    event.getBlock().getZ()
            )) {
                Rice.getDao().remove(
                        event.getBlock().getWorld().getName(),
                        event.getBlock().getX(),
                        event.getBlock().getY(),
                        event.getBlock().getZ()
                );
                event.setDropItems(false);
                final ItemStack riceLi = RiceLi.to();
                riceLi.setAmount(new Random().nextInt(4));
                event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), riceLi);
            }
        }
    }
}
