package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.Misc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("core.feed") || p.hasPermission("core.staff")){
                if(args.length == 0){
                    if(p.getFoodLevel() == 20){
                        p.sendMessage(ChatColor.RED + "You are already at full hunger");
                    }else{
                        p.sendMessage(ChatColor.GREEN + "You have been fed to full hunger.");
                        p.setFoodLevel(20);
                    }
                }else{
                    Player t = Bukkit.getPlayer(args[0]);
                    if(t.getFoodLevel() == 20){
                        p.sendMessage(ChatColor.RED + "This player is already at full hunger.");
                    }else{
                        p.sendMessage(ChatColor.YELLOW + t.getDisplayName() + ChatColor.GREEN + " Has been fed to full hunger.");
                        t.setFoodLevel(20);
                        t.sendMessage(ChatColor.GREEN + "You have been fed to full hunger.");
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
