package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.main;

public class ToggleCommandLogging implements CommandExecutor {

    main plugin;
    public ToggleCommandLogging(main plugin){
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {



        return true;
    }
}
