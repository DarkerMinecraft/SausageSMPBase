package sausagesmp.corruptsausage.sausagesmp.main.SausageSMP;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.commands.*;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.commands.difficulty.*;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.commands.misc.*;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.commands.report.ReportCommand;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.commands.time.*;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.utils.ConfigUtils;
import sausagesmp.corruptsausage.sausagesmp.main.SausageSMP.utils.UpdateChecker;


import java.util.ArrayList;

public final class Main extends JavaPlugin {

    //Vanish command
    public ArrayList<Player> vanish_list = new ArrayList<>();

    //Fly Command
    public ArrayList<Player> fly_list = new ArrayList<>();


    //godmode players
    public ArrayList<Player> godmode_list = new ArrayList<>();

    //Command logging for admins
    public ArrayList<Player> receive_logs_list = new ArrayList<>();

    @Override
    public void onEnable() {
        //check for updates
        new UpdateChecker(this, 92295).getLatestVersion(version -> {
            if(this.getDescription().getVersion().equalsIgnoreCase(version)){
                System.out.println("Plugin is up to date.");
            }else{
                System.out.println("PLugin has an update!");
            }
        });

        ConfigUtils.setupConfigUtils(this);

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
        /** Readd this if you don't like my difficulty command
        this.getCommand("easy").setExecutor(new DifficultyEasy(this));
        this.getCommand("normal").setExecutor(new DifficultyNormal(this));
        this.getCommand("hard").setExecutor(new DifficultyHard(this));
        this.getCommand("peaceful").setExecutor(new DifficultyPeaceful(this));
         **/
        this.getCommand("difficulty").setExecutor(new DifficultyCommand(this));
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
