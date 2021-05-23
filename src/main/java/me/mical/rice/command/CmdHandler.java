package me.mical.rice.command;

import me.mical.rice.Rice;
import org.serverct.parrot.parrotx.api.ParrotXAPI;
import org.serverct.parrot.parrotx.command.CommandHandler;
import org.serverct.parrot.parrotx.command.subcommands.DebugCommand;
import org.serverct.parrot.parrotx.command.subcommands.HelpCommand;
import org.serverct.parrot.parrotx.command.subcommands.ReloadCommand;
import org.serverct.parrot.parrotx.command.subcommands.VersionCommand;
import org.serverct.parrot.parrotx.data.autoload.annotations.PAutoload;

@PAutoload
public class CmdHandler extends CommandHandler {

    public CmdHandler() {
        super(ParrotXAPI.getPlugin(Rice.class), "rice");
        register(new VersionCommand(plugin));
        register(new HelpCommand(plugin));
        register(new DebugCommand(plugin, ".debug"));
        register(new ReloadCommand(plugin, ".reload"));
    }
}
