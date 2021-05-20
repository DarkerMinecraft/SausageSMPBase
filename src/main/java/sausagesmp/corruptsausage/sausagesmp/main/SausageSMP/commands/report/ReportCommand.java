package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.commands.report;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReportCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("core.report.send") || p.hasPermission("core.staff")){
                if(args.length == 0){
                    p.sendMessage(ChatColor.RED + "Format: /report <message>");
                }else{
                    for(Player players : Bukkit.getOnlinePlayers()){
                        if(players.hasPermission("core.report.receive") || p.hasPermission("core.staff")){
                            String message = "";
                                for (int i = 1; i < args.length; i++){
                                    message += args[i] + " ";
                                }
                                message = message.trim();
                                players.sendMessage(ChatColor.YELLOW + "[Report] " + ChatColor.WHITE + ChatColor.AQUA + "(" + p.getDisplayName() + ")" + " " + ChatColor.GRAY + args[0] + " " + message);
                                p.sendMessage(ChatColor.YELLOW + "Report has been send to the staff online!");
                        }else{

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
