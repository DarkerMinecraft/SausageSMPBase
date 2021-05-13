package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.main;

public class VanishCommand implements CommandExecutor {

    main plugin;

    public VanishCommand(main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("core.vanish")){
                if(plugin.vanish_list.contains(p)){
                    for(Player players : Bukkit.getOnlinePlayers()){
                        players.showPlayer(plugin, p);
                    }
                    plugin.vanish_list.remove(p);
                    p.sendMessage(ChatColor.AQUA + "Vanish has been disabled.");
                }else if(!plugin.vanish_list.contains(p)){
                    for(Player players : Bukkit.getOnlinePlayers()){
                        players.hidePlayer(plugin, p);
                    }
                    plugin.vanish_list.add(p);
                    p.sendMessage(ChatColor.AQUA + "Vanish has been enabled.");
                }
            }else{
                p.sendMessage(ChatColor.RED + "You don't have access to this command.");
            }
        }






        return true;
    }
}
