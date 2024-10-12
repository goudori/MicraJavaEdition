package plugin.micrajava_firework;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.entity.Player;

public class FireworkCommand implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (command.getName().equalsIgnoreCase("firework")) {
      if (sender instanceof Player) {
        Player player = (Player) sender;
        Location location = player.getLocation();
        launchFirework(location);
        player.sendMessage("花火を打ち上げました！");
        return true;
      } else {
        sender.sendMessage("このコマンドはプレイヤーのみ使用できます。");
        return false;
      }
    }
    return false;
  }

  // 花火を打ち上げるメソッド
  public void launchFirework(Location location) {
    Firework firework = location.getWorld().spawn(location, Firework.class);
    FireworkMeta fireworkMeta = firework.getFireworkMeta();

    // 花火の効果を設定
    FireworkEffect effect = FireworkEffect.builder()
        .withColor(Color.AQUA, Color.BLUE)
        .with(Type.CREEPER)
        .withFlicker()
        .withTrail()
        .build();

    fireworkMeta.addEffect(effect);
    fireworkMeta.setPower(1); // 花火の高さ
    firework.setFireworkMeta(fireworkMeta);
  }
}
