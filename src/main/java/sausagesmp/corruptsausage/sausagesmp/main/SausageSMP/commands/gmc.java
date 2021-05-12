package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gmc implements CommandExecutor {

    private String getConfig;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        if(p.hasPermission("core.gamemode")){
            if(args.length == 0){
                if(p.getGameMode() == GameMode.CREATIVE){
                    p.sendMessage(ChatColor.RED + "You are already in gamemode Creative");
                }else{
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(ChatColor.GREEN + "Gamemode has been changed to Creative.");
                }
            }else{
                Player t = Bukkit.getServer().getPlayer(args[0]);
                if(t.getGameMode() == GameMode.CREATIVE){
                    p.sendMessage(ChatColor.RED + "This player is already in gamemode Creative.");
                }else{
                    p.sendMessage(ChatColor.GREEN + "Gamemode from " + ChatColor.YELLOW + t.getDisplayName() + ChatColor.GREEN + " Has been changed to Creative.");
                    t.setGameMode(GameMode.CREATIVE);
                    t.sendMessage(ChatColor.YELLOW + "Your gamemode has been changed to Creative.");
                }
            }
        }else{
            p.sendMessage(ChatColor.RED + "You don't have access to this command.");
        }


        return false;
    }
}
