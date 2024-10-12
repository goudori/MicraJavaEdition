package plugin.micrajava_firework;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

  @Override
  public void onEnable() {
    this.getCommand("firework").setExecutor(new FireworkCommand());
    getLogger().info("firework使用可能。");

  }

  @Override
  public void onDisable() {
    getLogger().info("fireworkは、使用できません。");

  }
}
