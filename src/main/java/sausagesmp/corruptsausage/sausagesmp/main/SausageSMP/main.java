package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP;

import org.bukkit.plugin.java.JavaPlugin;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.GuiCommands.WorldMenu;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.GuiEvents.cancelguimovement;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.Utils.UpdateChecker;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.commands.gmc;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.commands.gms;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        //check for updates:
        new UpdateChecker(this, 92295).getLatestVersion(version -> {
            if(this.getDescription().getVersion().equalsIgnoreCase(version)){
                System.out.println("Plugin is running latest version.");
            }else{
                System.out.println("Plugin has an update!");
            }
        });



      System.out.println("SausageSMP:");
      System.out.println("Model: Base");
      System.out.println("Status: Loaded and running.");


      //commands:
        this.getCommand("gms").setExecutor(new gms());
        this.getCommand("gmc").setExecutor(new gmc());

      //GuiCommands:
      this.getCommand("worldmenu").setExecutor(new WorldMenu());

      //Events:



      //Gui Events:
        getServer().getPluginManager().registerEvents(new cancelguimovement(), this);
    }



    //Config



    @Override
    public void onDisable() {
        System.out.println("SausageSMP:");
        System.out.println("Model: Base");
        System.out.println("Status: Stopped. ");
    }
}
