package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.main;

public class ToggleCommandLogging implements CommandExecutor {

    main plugin;
    public ToggleCommandLogging(main plugin){
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        Player p = (Player) sender;
        if(p.hasPermission("core.admin")){
            if(plugin.receive_logs_list.contains(p)){
                p.sendMessage(ChatColor.YELLOW + "Command logs has been disabled.");
                plugin.receive_logs_list.remove(p);
            }else if(!plugin.receive_logs_list.contains(p)){
                p.sendMessage(ChatColor.YELLOW + "Command logs has now been enabled.");
                plugin.receive_logs_list.add(p);
            }

        }else{
            p.sendMessage(ChatColor.RED + "You don't have access to this command.");
        }


        return true;
    }
}
