package me.daqem.rightclickfarming.doers;

import me.daqem.rightclickfarming.RightClickFarming;
import me.daqem.rightclickfarming.checkers.FullyGrownChecker;
import me.daqem.rightclickfarming.utils.DropMath;
import org.apache.commons.lang.ObjectUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class BreakCrops {

    public RightClickFarming plugin;

    public BreakCrops(RightClickFarming pl) {
        this.plugin = pl;
    }

    DropMath dropMath = new DropMath();
    FullyGrownChecker fullyGrownChecker = new FullyGrownChecker();

    public void breakCrops(Block block, Player player) {
        if (fullyGrownChecker.isFullyGrown(block)) {
            player.sendMessage("Fully Grown");
            if (block.getType() == Material.WHEAT) {
                block.setType(Material.AIR);
                player.getInventory().addItem(new ItemStack(Material.WHEAT, 1));
                if (plugin.getConfig().getBoolean("wheat.seed-drops")) {
                    player.getInventory().addItem(new ItemStack(Material.WHEAT_SEEDS, dropMath.getRandomNumberInRange(plugin.getConfig().getInt("wheat.min-seed-drops"), plugin.getConfig().getInt("wheat.max-seed-drops"))));

                }
            }
        }
    }
}
