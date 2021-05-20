package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.commands.difficulty;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.Main;

public class DifficultyCommand implements CommandExecutor  {

    Main plugin;
    public DifficultyCommand(Main plugin){this.plugin = plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            if (args.length == 1) {
                if (sender.hasPermission("core.difficulty") || sender.hasPermission("core.staff") || sender.isOp()) {
                    Difficulty difficulty = ((Player) sender).getWorld().getDifficulty();
                    Difficulty newDifficulty = Difficulty.valueOf(args[0].toUpperCase());
                    if(newDifficulty == null) sender.sendMessage(ChatColor.RED + "Please specify peaceful, easy, normal, or hard. You wrote " + args[0]);
                    else {
                        if(!difficulty.equals(newDifficulty)) {
                            ((Player) sender).getWorld().setDifficulty(newDifficulty);
                            for(Player players : Bukkit.getOnlinePlayers()) {
                                if (plugin.receive_logs_list.contains(players)) {
                                    players.sendMessage(ChatColor.RED + "[LOGS] " + ChatColor.YELLOW + ((Player) sender).getDisplayName() + ChatColor.GRAY + " /difficulty " + args[0]);
                                }
                            }
                            sender.sendMessage(ChatColor.GREEN + "Difficulty has been changed to " + args[0]);
                        } else sender.sendMessage(ChatColor.RED + "Difficulty is already " + args[0] + " in this world.");
                    }
                } else sender.sendMessage(ChatColor.RED + "You don't have access to this command.");
            } else{
                sender.sendMessage(ChatColor.RED + "Please specify a difficulty: peaceful, easy, normal, hard");
                for(Player players : Bukkit.getOnlinePlayers()) {
                    if (plugin.receive_logs_list.contains(players)) {
                        players.sendMessage(ChatColor.RED + "[LOGS] " + ChatColor.YELLOW + ((Player) sender).getDisplayName() + ChatColor.GRAY + " /difficulty");
                    }
                }
            }
        } else sender.sendMessage("Console cannot use this command.");
        return true;
    }
}
