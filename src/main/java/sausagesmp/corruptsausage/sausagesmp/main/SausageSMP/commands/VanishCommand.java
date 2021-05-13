package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.main;

public class VanishCommand implements CommandExecutor {

    main plugin;

    public VanishCommand(main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("core.vanish")) {
                if (args.length == 0) {
                    if (plugin.vanish_list.contains(p)) {
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.showPlayer(plugin, p);
                        }
                        plugin.vanish_list.remove(p);
                        p.sendMessage(ChatColor.AQUA + "Vanish has been disabled.");
                    } else if (!plugin.vanish_list.contains(p)) {
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.hidePlayer(plugin, p);
                        }
                        plugin.vanish_list.add(p);
                        p.sendMessage(ChatColor.AQUA + "Vanish has been enabled.");
                    }

                } else {
                    Player t = Bukkit.getServer().getPlayer(args[0]);
                    if (plugin.vanish_list.contains(t)) {
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.showPlayer(plugin, t);
                        }
                        t.sendMessage(ChatColor.AQUA + "Vanish has been disabled.");
                        p.sendMessage(ChatColor.GREEN + "Vanish has been " + ChatColor.YELLOW + "Disabled " + ChatColor.GREEN + "for " + ChatColor.YELLOW + t.getDisplayName());
                        plugin.vanish_list.remove(t);
                    } else if (!plugin.vanish_list.contains(t)) {
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.hidePlayer(plugin, t);
                        }
                        t.sendMessage(ChatColor.AQUA + "Vanish has been enabled.");
                        p.sendMessage(ChatColor.GREEN + "Vanish has been " + ChatColor.YELLOW + "Enabled. " + ChatColor.GREEN + "for " + ChatColor.YELLOW + t.getDisplayName());
                        plugin.vanish_list.add(t);
                    }
                }
            } else {
                p.sendMessage(ChatColor.RED + "You don't have access to this command.");
            }



        }
        return true;
    }
}

