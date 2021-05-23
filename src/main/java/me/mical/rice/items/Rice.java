package me.mical.rice.items;

import com.cryptomorin.xseries.XMaterial;
import org.bukkit.inventory.ItemStack;
import org.serverct.parrot.parrotx.utils.ItemBuilder;

public class Rice {

    public static ItemStack to() {
        return ItemBuilder.start()
                .material(XMaterial.SUGAR)
                .display("&3&l米饭")
                .build();
    }
}
