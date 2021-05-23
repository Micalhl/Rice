package me.mical.rice.items;

import com.cryptomorin.xseries.XMaterial;
import org.bukkit.inventory.ItemStack;
import org.serverct.parrot.parrotx.utils.ItemBuilder;

public class RiceLi {

    public static ItemStack to() {
        return ItemBuilder.start()
                .material(XMaterial.SUGAR)
                .display("&3&l水稻")
                .build();
    }
}
