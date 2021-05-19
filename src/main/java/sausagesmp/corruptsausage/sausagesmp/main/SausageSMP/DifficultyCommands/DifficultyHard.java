package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.DifficultyCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.main;

public class DifficultyHard implements CommandExecutor {

    main plugin;
    public DifficultyHard(main plugin){this.plugin = plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(sender instanceof Player){
            if(player.hasPermission("core.difficulty") || player.hasPermission("core.staff")){
                if(player.getWorld().getDifficulty() == Difficulty.HARD){
                    player.sendMessage(ChatColor.RED + "Difficulty is already Hard in this world.");
                }else{
                    player.getWorld().setDifficulty(Difficulty.HARD);

                    for(Player players : Bukkit.getOnlinePlayers()){
                        if(plugin.receive_logs_list.contains(players)){
                            players.sendMessage(ChatColor.RED + "[LOGS] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.GRAY + " /hard");
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
