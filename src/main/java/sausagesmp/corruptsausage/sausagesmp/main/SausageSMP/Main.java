package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.DifficultyCommands.*;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.Misc.*;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.TimeCommands.DayTimeCommand;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.TimeCommands.NightTimeCommand;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.Utils.UpdateChecker;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.commands.*;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.reportCommand.ReportCommand;

import java.util.ArrayList;

public final class Main extends JavaPlugin {

    //Vanish command
    public ArrayList<Player> vanish_list = new ArrayList<>();

    //Fly Command
    public ArrayList<Player> fly_list = new ArrayList<>();

    //See vanished players
    public ArrayList<Player> see_vanish_list = new ArrayList<>();

    //godmode players
    public ArrayList<Player> godmode_list = new ArrayList<>();

    //Command logging for admins
    public ArrayList<Player> receive_logs_list = new ArrayList<>();

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
        this.getCommand("gms").setExecutor(new Gms(this));
        this.getCommand("gmc").setExecutor(new Gmc(this));
        this.getCommand("day").setExecutor(new DayTimeCommand(this));
        this.getCommand("night").setExecutor(new NightTimeCommand(this));
        this.getCommand("vanish").setExecutor(new VanishCommand(this));
        this.getCommand("v").setExecutor(new VanishCommand(this));
        this.getCommand("fly").setExecutor(new FlyCommand(this));
        this.getCommand("easy").setExecutor(new DifficultyEasy(this));
        this.getCommand("normal").setExecutor(new DifficultyNormal(this));
        this.getCommand("hard").setExecutor(new DifficultyHard(this));
        this.getCommand("peaceful").setExecutor(new DifficultyPeacefull(this));
        this.getCommand("report").setExecutor(new ReportCommand());
        this.getCommand("god").setExecutor(new GodModeCommand(this));
        this.getCommand("feed").setExecutor(new FeedCommand(this));
        this.getCommand("heal").setExecutor(new HealCommand(this));
        this.getCommand("togglelogs").setExecutor(new ToggleCommandLogging(this));

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
