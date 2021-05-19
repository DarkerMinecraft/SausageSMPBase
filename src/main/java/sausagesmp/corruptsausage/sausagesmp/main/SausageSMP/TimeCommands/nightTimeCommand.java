package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.TimeCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.main;

public class nightTimeCommand implements CommandExecutor {

    main plugin;
    public nightTimeCommand(main plugin){this.plugin = plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(player.hasPermission("core.time") || player.hasPermission("core.staff")){
            player.getLocation().getWorld().setTime(13000);
            player.sendMessage(ChatColor.GREEN + "Time has been changed.");
            for(Player players : Bukkit.getOnlinePlayers()){
                if(plugin.receive_logs_list.contains(players)){
                    players.sendMessage(ChatColor.RED + "[LOGS] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.GRAY + " /night");
                }
            }
        }else{
            player.sendMessage(ChatColor.RED + "You don't have access to this command.");
        }



        return true;
    }
}
