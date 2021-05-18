package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.Misc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.main;

public class FlyCommand implements CommandExecutor {

    main plugin;

    public FlyCommand(main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("core.fly") || p.hasPermission("core.staff")){
                if(args.length == 0){
                    if(plugin.fly_list.contains(p)){
                        p.setAllowFlight(false);
                        plugin.fly_list.remove(p);
                        p.sendMessage(ChatColor.RED + "Flight has been disabled.");
                    }else if(!plugin.fly_list.contains(p)){
                        p.setAllowFlight(true);
                        plugin.fly_list.add(p);
                        p.sendMessage(ChatColor.GREEN + "Flight has been enabled.");
                    }
                }else{
                    Player t = Bukkit.getServer().getPlayer(args[0]);
                    if(plugin.fly_list.contains(t)){
                        t.setAllowFlight(false);
                        t.sendMessage(ChatColor.RED + "Flight has been disabled.");
                        p.sendMessage(ChatColor.GREEN + "Flight has been " + ChatColor.YELLOW +  "Disabled " + ChatColor.GREEN + "for " + ChatColor.YELLOW + t.getDisplayName());
                        plugin.fly_list.remove(t);
                    }else if(!plugin.fly_list.contains(t)){
                        t.setAllowFlight(true);
                        t.sendMessage(ChatColor.GREEN + "Flight has been enabled.");
                        p.sendMessage(ChatColor.GREEN + "Flight has been " + ChatColor.YELLOW +  "Enabled " + ChatColor.GREEN + "for " + ChatColor.YELLOW + t.getDisplayName());
                        plugin.fly_list.add(t);
                    }
                }

            }else{
                p.sendMessage(ChatColor.RED + "You don't have access to this command.");
            }

        }







        return true;
    }
}
