package me.mical.rice.config;

import me.mical.rice.Rice;
import org.serverct.parrot.parrotx.api.ParrotXAPI;
import org.serverct.parrot.parrotx.config.PConfig;
import org.serverct.parrot.parrotx.data.autoload.annotations.PAutoload;
import org.serverct.parrot.parrotx.data.autoload.annotations.PAutoloadGroup;

import java.util.Objects;

@PAutoloadGroup
public class SettingsConf extends PConfig {

    private static SettingsConf inst;

    @PAutoload("SQLAddress")
    public static String sqlAddress;
    @PAutoload("SQLPort")
    public static int sqlPort;
    @PAutoload("SQLDatabase")
    public static String sqlDatabase;
    @PAutoload("SQLName")
    public static String sqlName;
    @PAutoload("SQLPassword")
    public static String sqlPassword;

    @PAutoload("SeedDropChance")
    public static double seedDropChance;
    @PAutoload("Food")
    public static int food;
    @PAutoload("EatMessage")
    public static boolean eatMessage;

    public SettingsConf() {
        super(ParrotXAPI.getPlugin(Rice.class), "settings", "主配置文件");
    }

    public static SettingsConf getInst() {
        if (Objects.isNull(inst)) {
            inst = new SettingsConf();
        }
        return inst;
    }
}
