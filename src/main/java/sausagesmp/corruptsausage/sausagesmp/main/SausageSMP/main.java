package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.DifficultyCommands.DifficultyEasy;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.DifficultyCommands.DifficultyHard;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.DifficultyCommands.DifficultyNormal;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.DifficultyCommands.DifficultyPeacefull;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.Misc.FlyCommand;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.Misc.VanishCommand;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.Misc.gmc;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.Misc.gms;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.TimeCommands.dayTimeCommand;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.TimeCommands.nightTimeCommand;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.Utils.UpdateChecker;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.commands.*;

import java.util.ArrayList;

public final class main extends JavaPlugin {

    //Vanish command
    public ArrayList<Player> vanish_list = new ArrayList<>();

    //Fly Command
    public ArrayList<Player> fly_list = new ArrayList<>();

    @Override
    public void onEnable() {
        //check for updates:
        new UpdateChecker(this, 92295).getLatestVersion(version -> {
            if(this.getDescription().getVersion().equalsIgnoreCase(version)){
                System.out.println("Plugin is running latest version.");
            }else{
                System.out.println("Plugin has an update:");
                System.out.println("Please download it at: https://www.spigotmc.org/resources/sausagesmp.92295/");
            }
        });



      System.out.println("SausageSMP:");
      System.out.println("Model: Base");
      System.out.println("Status: Loaded and running.");


      //commands:
        this.getCommand("gms").setExecutor(new gms());
        this.getCommand("gmc").setExecutor(new gmc());
        this.getCommand("day").setExecutor(new dayTimeCommand());
        this.getCommand("night").setExecutor(new nightTimeCommand());
        this.getCommand("vanish").setExecutor(new VanishCommand(this));
        this.getCommand("v").setExecutor(new VanishCommand(this));
        this.getCommand("fly").setExecutor(new FlyCommand(this));
        this.getCommand("info").setExecutor(new InfoCommand());
        this.getCommand("easy").setExecutor(new DifficultyEasy());
        this.getCommand("normal").setExecutor(new DifficultyNormal());
        this.getCommand("hard").setExecutor(new DifficultyHard());
        this.getCommand("peaceful").setExecutor(new DifficultyPeacefull());

      //GuiCommands:


      //Events:



      //Gui Events:

    }



    //Config



    @Override
    public void onDisable() {
        System.out.println("SausageSMP:");
        System.out.println("Model: Base");
        System.out.println("Status: Stopped. ");
    }
}
