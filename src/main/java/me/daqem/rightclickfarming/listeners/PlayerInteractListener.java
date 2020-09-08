package me.daqem.rightclickfarming.listeners;

import me.daqem.rightclickfarming.RightClickFarming;
import me.daqem.rightclickfarming.doers.BreakCrops;
import me.daqem.rightclickfarming.doers.PlantSeeds;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {

    public RightClickFarming plugin;

    public PlayerInteractListener(final RightClickFarming pl) {
        this.plugin = pl;
    }

    private final BreakCrops breakCrops = new BreakCrops(RightClickFarming.getInstance());
    PlantSeeds plantSeeds = new PlantSeeds();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        if (block == null) {
            return;
        }
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (plugin.getConfig().getBoolean("hoe-required")) {
                Material MainHand = player.getInventory().getItemInMainHand().getType();
                if (MainHand == Material.WOODEN_HOE || MainHand == Material.STONE_HOE || MainHand == Material.IRON_HOE || MainHand == Material.GOLDEN_HOE || MainHand == Material.DIAMOND_HOE) {
                    player.sendMessage("Hoe in hand");
                    breakCrops.breakCrops(block, player);
                    plantSeeds.plantSeeds("Wheat", block.getLocation().getBlock());
                }

            } else {
                breakCrops.breakCrops(block, player);
            }
        }
    }
}
