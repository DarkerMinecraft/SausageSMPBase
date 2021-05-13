package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.GuiCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class WorldMenu implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if(p.hasPermission("core.worldmenu")){
            Inventory worldmenu = Bukkit.createInventory(p, 54, ChatColor.GREEN + "World Options");
            
            
            //menu options:
            //Time Options:
            ItemStack timeSign = new ItemStack(Material.ACACIA_WALL_SIGN);
            ItemStack daytime = new ItemStack(Material.LIGHT_BLUE_WOOL);
            ItemStack nighttime = new ItemStack(Material.BLACK_WOOL);
            ItemStack blackpane = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
            
            
            
            //Edit Items:
            
            //TimeSign:
            ItemMeta timeSign_meta = timeSign.getItemMeta();
            timeSign_meta.setDisplayName(ChatColor.YELLOW + "Time Options:");
            ArrayList<String> timeSign_lore = new ArrayList<>();
            timeSign_lore.add(ChatColor.GREEN + "Changes time");
            timeSign_meta.setLore(timeSign_lore);
            timeSign.setItemMeta(timeSign_meta);


            //Daytime:
            ItemMeta daytime_meta = daytime.getItemMeta();
            daytime_meta.setDisplayName(ChatColor.GREEN + "Time Change");
            ArrayList<String> daytime_lore = new ArrayList<>();
            daytime_lore.add(ChatColor.GREEN + "Changes time to daytime.");
            daytime_meta.setLore(daytime_lore);
            daytime.setItemMeta(daytime_meta);
            
            //Nighttime:
            ItemMeta nighttime_meta = nighttime.getItemMeta();
            nighttime_meta.setDisplayName(ChatColor.GREEN + "Time Change");
            ArrayList<String> nighttime_lore = new ArrayList<>();
            nighttime_lore.add(ChatColor.GREEN + "Changes time to night.");
            nighttime_meta.setLore(nighttime_lore);
            nighttime.setItemMeta(nighttime_meta);
            
            





            //Put the items in the inventory:

            ItemStack[] menu_items = {
                   daytime,
                    nighttime,
            };
            worldmenu.setContents(menu_items);
            p.openInventory(worldmenu);


            //Replace empty slots with panels:
            for (int i = 0; i < worldmenu.getSize(); i++){
                if(worldmenu.getItem(i) == null || worldmenu.getItem(i).getType().equals(Material.AIR)){
                    worldmenu.setItem(i, blackpane);
                }
            }

        }





        return true;
    }
}
