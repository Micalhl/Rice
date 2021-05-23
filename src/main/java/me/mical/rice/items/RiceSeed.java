package me.mical.rice.items;

import com.cryptomorin.xseries.XMaterial;
import org.bukkit.inventory.ItemStack;
import org.serverct.parrot.parrotx.utils.ItemBuilder;

public class RiceSeed {

    public static ItemStack to() {
        return ItemBuilder.start()
                .material(XMaterial.WHEAT_SEEDS)
                .display("&3&l水稻种子")
                .build();
    }
}
