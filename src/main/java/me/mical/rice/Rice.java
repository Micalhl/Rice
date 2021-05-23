package me.mical.rice;

import me.mical.rice.config.SettingsConf;
import me.mical.rice.recipe.RiceRecipe;
import me.mical.rice.sql.Dao;
import org.serverct.parrot.parrotx.PPlugin;

public final class Rice extends PPlugin {

    private static Dao dao;

    @Override
    protected void preload() {
        pConfig = SettingsConf.getInst();
    }

    @Override
    protected void load() {
        dao = new Dao();
        RiceRecipe.initialize();
    }

    @Override
    protected void afterInit() {
        getDao().connect();
        registerStats(11450, null);
    }

    public static Dao getDao() {
        return dao;
    }
}
