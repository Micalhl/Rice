package me.mical.rice.listener;

import me.mical.rice.config.SettingsConf;
import me.mical.rice.items.Rice;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.serverct.parrot.parrotx.api.ParrotXAPI;
import org.serverct.parrot.parrotx.data.autoload.annotations.PAutoload;
import org.serverct.parrot.parrotx.utils.i18n.I18n;

@PAutoload
public class EatFoodListener implements Listener {

    @EventHandler
    public void onPlayerEat(final PlayerInteractEvent event) {
        if (event.getHand().equals(EquipmentSlot.HAND)) {
            if (!event.getAction().equals(Action.RIGHT_CLICK_AIR) && !event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                return;
            }
            if (event.getItem() != null) {
                final ItemStack item = event.getPlayer().getEquipment().getItemInMainHand();
                if (event.getItem().isSimilar(Rice.to())) {
                    event.setCancelled(true);

                    item.setAmount(item.getAmount() - 1);

                    if (20 - event.getPlayer().getFoodLevel() < SettingsConf.food) {
                        event.getPlayer().setFoodLevel(20);
                    } else {
                        event.getPlayer().setFoodLevel(event.getPlayer().getFoodLevel() + SettingsConf.food);
                    }

                    if (SettingsConf.eatMessage) {
                        I18n.send(event.getPlayer(), ParrotXAPI.getPlugin(me.mical.rice.Rice.class).getLang().data.getInfo("Lang", "Eat"));
                    }
                }
            }
        }
    }
}
