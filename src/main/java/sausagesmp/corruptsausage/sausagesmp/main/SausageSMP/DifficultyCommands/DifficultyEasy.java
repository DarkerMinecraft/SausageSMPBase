package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.DifficultyCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DifficultyEasy implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(sender instanceof Player){
            if(player.hasPermission("core.difficulty")){
                if(player.getWorld().getDifficulty() == Difficulty.EASY){
                    player.sendMessage(ChatColor.RED + "Difficulty is already Easy in this world.");
                }else{
                    player.getWorld().setDifficulty(Difficulty.EASY);

                    for(Player players : Bukkit.getOnlinePlayers()){
                        if(players.hasPermission("core.difficulty")){
                            players.sendMessage(ChatColor.GREEN + "Difficulty changed to " + ChatColor.YELLOW + "Easy" + ChatColor.GREEN + " by: " + ChatColor.YELLOW + player.getDisplayName());
                        }
                    }
                }

            }else{
                player.sendMessage(ChatColor.RED + "You don't have access to this command.");
            }
        }


        return true;
    }
}
