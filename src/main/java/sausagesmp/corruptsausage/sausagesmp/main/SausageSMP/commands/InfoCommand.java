package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InfoCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            //Check if player is staff for extra info
            Player player = (Player) sender;
            if(player.hasPermission("core.staff")){
                player.sendMessage(ChatColor.BLUE + "List of commands you have access to:");
                player.sendMessage(ChatColor.GREEN + "--------------------");
                player.sendMessage(ChatColor.GREEN + "/day (core.time)");
                player.sendMessage(ChatColor.GREEN + "/night (core.time)");
                player.sendMessage(ChatColor.GREEN + "/gmc (core.gamemode)");
                player.sendMessage(ChatColor.GREEN + "/gms (core.gamemode)");
                player.sendMessage(ChatColor.GREEN + "/fly (core.fly)");
                player.sendMessage(ChatColor.GREEN + "/Vanish (core.vanish)");
                player.sendMessage(ChatColor.GREEN + "/info (Staff)");
                player.sendMessage(ChatColor.GREEN + "--------------------");
            }else{
                //If not staff, send this.
                player.sendMessage(ChatColor.GREEN + "--------------------");
                player.sendMessage(ChatColor.BLUE + "List of commands you have access to:");
                player.sendMessage(ChatColor.GREEN + "/info (Default)");
                player.sendMessage(ChatColor.GREEN + "--------------------");
            }

        }else{
            System.out.println("You are not a player!");
        }


        return true;
    }
}
