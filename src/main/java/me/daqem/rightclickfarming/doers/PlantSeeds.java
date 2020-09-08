package me.daqem.rightclickfarming.doers;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class PlantSeeds {

    public void plantSeeds(String crop, Block block) {
        if (crop.equals("Wheat")) {
            block.setType(Material.WHEAT_SEEDS);
        }
    }
}
