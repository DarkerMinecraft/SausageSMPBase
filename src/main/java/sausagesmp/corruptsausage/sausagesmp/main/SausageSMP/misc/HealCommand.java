package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.misc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.Main;

public class HealCommand implements CommandExecutor {

    Main plugin;
    public HealCommand(Main plugin){this.plugin = plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("core.heal") || p.hasPermission("core.staff")){
                if(args.length == 0){
                    for(Player players : Bukkit.getOnlinePlayers()){
                        if(plugin.receive_logs_list.contains(players)){
                            players.sendMessage(ChatColor.RED + "[LOGS] " + ChatColor.YELLOW + p.getDisplayName() + ChatColor.GRAY + " /heal");
                        }
                    }
                    if(p.getHealth() == 20){
                        p.sendMessage(ChatColor.RED + "You are already at full health.");
                    }else{
                        p.sendMessage(ChatColor.GREEN + "You have been healed to full health.");
                        p.setHealth(20);
                    }
                }else{
                    for(Player players : Bukkit.getOnlinePlayers()){
                        if(plugin.receive_logs_list.contains(players)){
                            players.sendMessage(ChatColor.RED + "[LOGS] " + ChatColor.YELLOW + p.getDisplayName() + ChatColor.GRAY + " /heal");
                        }
                    }
                    Player t = Bukkit.getPlayer(args[0]);
                    if(t.getHealth() == 20){
                        p.sendMessage(ChatColor.RED + "This player is already at full health.");
                    }else{
                        p.sendMessage(ChatColor.YELLOW + t.getDisplayName() + ChatColor.GREEN + " Has been healed to full health.");
                        t.setHealth(20);
                        t.sendMessage(ChatColor.GREEN + "You have been healed to full health.");
                    }
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
