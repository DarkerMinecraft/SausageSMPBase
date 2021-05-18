package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.TimeCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class dayTimeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(player.hasPermission("core.time") || player.hasPermission("core.staff")){
            player.getLocation().getWorld().setTime(1000);
            player.sendMessage(ChatColor.GREEN + "Time has been changed.");
        }else{
            player.sendMessage(ChatColor.RED + "You don't have access to this command.");
        }




        return true;
    }
}
