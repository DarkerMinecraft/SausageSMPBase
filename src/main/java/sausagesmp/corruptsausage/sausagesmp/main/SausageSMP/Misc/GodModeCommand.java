package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.Misc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.main;

public class GodModeCommand implements CommandExecutor {

    main plugin;
    public GodModeCommand(main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("core.godmode") || p.hasPermission("core.staff")){
                    if(plugin.godmode_list.contains(p)){
                        p.setInvulnerable(false);
                        plugin.godmode_list.remove(p);
                        p.sendMessage(ChatColor.AQUA + "Godmode has been disabled.");
                    }else if(!plugin.godmode_list.contains(p)){
                        p.setInvulnerable(true);
                        plugin.godmode_list.add(p);
                        p.sendMessage(ChatColor.AQUA + "Godmode has been enabled.");
                    }


            }else{
                p.sendMessage(ChatColor.RED + "You don't have access to this command.");
            }
        }else{
            System.out.println("You are not a player.");
        }



        return true;
    }
}
