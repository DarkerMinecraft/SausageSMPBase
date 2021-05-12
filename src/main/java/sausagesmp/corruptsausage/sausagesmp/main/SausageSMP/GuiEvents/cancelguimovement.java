package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.GuiEvents;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class cancelguimovement implements Listener {

    @EventHandler
    public void clickEvent(InventoryClickEvent e){

        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "World Options")){
            Player player = (Player) e.getWhoClicked();

            switch (e.getCurrentItem().getType()){
                case LIGHT_BLUE_WOOL:
                    player.getLocation().getWorld().setTime(1000);
                    player.sendMessage(ChatColor.GREEN + "Time has been changed.");
                    break;
                case BLACK_WOOL:
                    player.getLocation().getWorld().setTime(13000);
                    player.sendMessage(ChatColor.GREEN + "Time has been changed.");
                    break;
            }


            e.setCancelled(true);
        }



    }
}
