package me.daqem.rightclickfarming.checkers;

import org.bukkit.CropState;
import org.bukkit.block.Block;
import org.bukkit.material.Crops;
import org.bukkit.material.MaterialData;

public class FullyGrownChecker {

    public boolean isFullyGrown(Block block) {
        MaterialData md = block.getState().getData();

        if(md instanceof Crops) {
            return (((Crops) md).getState() == CropState.RIPE);
        }
        else return false;
    }
}
