package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.Misc;

import jdk.internal.icu.impl.CharTrie;
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
                if(args.length == 0){
                    if(plugin.godmode_list.contains(p)){
                        p.setInvulnerable(false);
                        plugin.godmode_list.remove(p);
                        p.sendMessage(ChatColor.AQUA + "Godmode has been disabled.");
                        for(Player players : Bukkit.getOnlinePlayers()){
                            if(plugin.receive_logs_list.contains(players)){
                                players.sendMessage(ChatColor.RED + "[LOGS] " + ChatColor.YELLOW + p.getDisplayName() + ChatColor.GRAY + " /god");
                            }
                        }
                    }else if(!plugin.godmode_list.contains(p)){
                        p.setInvulnerable(true);
                        plugin.godmode_list.add(p);
                        p.sendMessage(ChatColor.AQUA + "Godmode has been enabled.");
                        for(Player players : Bukkit.getOnlinePlayers()){
                            if(plugin.receive_logs_list.contains(players)){
                                players.sendMessage(ChatColor.RED + "[LOGS] " + ChatColor.YELLOW + p.getDisplayName() + ChatColor.GRAY + " /god");
                            }
                        }
                    }
                }else{
                    Player t = Bukkit.getPlayer(args[0]);
                    if(plugin.godmode_list.contains(t)){
                        t.setInvulnerable(false);
                        plugin.godmode_list.remove(t);
                        t.sendMessage(ChatColor.AQUA + "Godmode has been disabled.");
                        p.sendMessage(ChatColor.AQUA + "Godmode has been disabled for: " + ChatColor.YELLOW + t.getDisplayName());
                        for(Player players : Bukkit.getOnlinePlayers()){
                            if(plugin.receive_logs_list.contains(players)){
                                players.sendMessage(ChatColor.RED + "[LOGS] " + ChatColor.YELLOW + p.getDisplayName() + ChatColor.GRAY + " /god");
                            }
                        }
                    }else if(!plugin.godmode_list.contains(t)){
                        t.setInvulnerable(true);
                        plugin.godmode_list.add(t);
                        t.sendMessage(ChatColor.AQUA + "Godmode has been enabled.");
                        p.sendMessage(ChatColor.AQUA + "Godmode has been enabled for: " + ChatColor.YELLOW + t.getDisplayName());
                        for(Player players : Bukkit.getOnlinePlayers()){
                            if(plugin.receive_logs_list.contains(players)){
                                players.sendMessage(ChatColor.RED + "[LOGS] " + ChatColor.YELLOW + p.getDisplayName() + ChatColor.GRAY + " /god");
                            }
                        }
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
