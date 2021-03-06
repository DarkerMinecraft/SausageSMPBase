package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.commands.misc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.Main;

public class Gms implements CommandExecutor {

    Main plugin;
    public Gms(Main plugin){this.plugin = plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        if(p.hasPermission("core.gamemode") || p.hasPermission("core.staff")){
            if(args.length == 0){
                if(p.getGameMode() == GameMode.SURVIVAL){
                    p.sendMessage(ChatColor.RED + "You are already in gamemode Survival.");
                    for(Player players : Bukkit.getOnlinePlayers()){
                        if(plugin.receive_logs_list.contains(players)){
                            players.sendMessage(ChatColor.RED + "[LOGS] " + ChatColor.YELLOW + p.getDisplayName() + ChatColor.GRAY + " /gmc");
                        }
                    }
                }else{
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(ChatColor.GREEN + "Gamemode has been changed to Survival.");
                    for(Player players : Bukkit.getOnlinePlayers()){
                        if(plugin.receive_logs_list.contains(players)){
                            players.sendMessage(ChatColor.RED + "[LOGS] " + ChatColor.YELLOW + p.getDisplayName() + ChatColor.GRAY + " /gmc");
                        }
                    }
                }
            }else{
                Player t = Bukkit.getServer().getPlayer(args[0]);
                if(t.getGameMode() == GameMode.SURVIVAL){
                    p.sendMessage(ChatColor.RED + "This player is already in gamemode Survival.");
                    for(Player players : Bukkit.getOnlinePlayers()){
                        if(plugin.receive_logs_list.contains(players)){
                            players.sendMessage(ChatColor.RED + "[LOGS] " + ChatColor.YELLOW + p.getDisplayName() + ChatColor.GRAY + " /gmc");
                        }
                    }
                }else{
                    p.sendMessage(ChatColor.GREEN + "Gamemode from " + ChatColor.YELLOW + t.getDisplayName() + ChatColor.GREEN + " Has been changed to Survival.");
                    t.setGameMode(GameMode.SURVIVAL);
                    t.sendMessage(ChatColor.YELLOW + "Your gamemode has been changed to Survival.");
                    for(Player players : Bukkit.getOnlinePlayers()){
                        if(plugin.receive_logs_list.contains(players)){
                            players.sendMessage(ChatColor.RED + "[LOGS] " + ChatColor.YELLOW + p.getDisplayName() + ChatColor.GRAY + " /gmc");
                        }
                    }
                }
            }
        }else{
            p.sendMessage(ChatColor.RED + "You don't have access to this command.");
        }


        return true;
    }
}
