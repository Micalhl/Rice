package me.mical.rice.sql;

import me.mical.rice.Rice;
import me.mical.rice.config.SettingsConf;
import org.jetbrains.annotations.NotNull;
import org.serverct.parrot.parrotx.PPlugin;
import org.serverct.parrot.parrotx.api.ParrotXAPI;
import org.serverct.parrot.parrotx.utils.HikariCPUtil;
import org.serverct.parrot.parrotx.utils.i18n.I18n;

import java.sql.SQLException;

public class Dao {

    private PPlugin plugin;
    private SQLInfo info;

    public Dao() {
        this.plugin = ParrotXAPI.getPlugin(Rice.class);
        this.info = SQLInfo.builder()
                .sqlAddress(SettingsConf.sqlAddress)
                .sqlDatabase(SettingsConf.sqlDatabase)
                .sqlPort(SettingsConf.sqlPort)
                .sqlName(SettingsConf.sqlName)
                .sqlPassword(SettingsConf.sqlPassword)
                .build();
    }

    public void connect() {
        HikariCPUtil.setSqlConnectionPool(
                plugin,
                info.getSqlAddress(),
                String.valueOf(info.getSqlPort()),
                info.getSqlDatabase(),
                info.getSqlName(),
                info.getSqlPassword()
        );
        HikariCPUtil.execute(
                plugin,
                "CREATE TABLE IF NOT EXISTS `plant_loc` (`world` TEXT,`x` INT,`y` INT,`z` INT);"
                , null
        );
    }

    public void create(@NotNull final String world, final int x, final int y, final int z) {
        HikariCPUtil.execute(
                plugin,
                "INSERT INTO plant_loc (world,x,y,z) VALUE('" + world + "'," + x + "," + y + "," + z + ");",
                null
        );
    }

    public void remove(@NotNull final String world, final int x, final int y, final int z) {
        HikariCPUtil.execute(
                plugin,
                "DELETE FROM plant_loc WHERE world = '" + world + "' AND x = " + x + " AND y = " + y + " AND z = " + z + ";",
                null
        );
    }

    public Boolean isPlant(@NotNull final String world, final int x, final int y, final int z) {
        return HikariCPUtil.query(
                plugin,
                "SELECT * FROM plant_loc WHERE world = '" + world + "' AND x = " + x + " AND y = " + y + " AND z = " + z + ";",
                resultSet -> {
                    if (resultSet == null) {
                        return false;
                    }
                    try {
                        return resultSet.next();
                    } catch (SQLException e) {
                        plugin.getLang().log.error(I18n.EXECUTE, "MySQL 语句", e, plugin.getPackageName());
                    }
                    return false;
                },
                null
        );
    }
}
