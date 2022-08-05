package sarinsa.megammo.modules.repair;

import org.bukkit.Material;

public class MegaRepair extends AbstractMegaRepair {

    @Override
    protected void registerRepairables() {
        registerArmorSet(Material.IRON_NUGGET,
                null,
                0.25D,
                Material.CHAINMAIL_BOOTS,
                Material.CHAINMAIL_LEGGINGS,
                Material.CHAINMAIL_CHESTPLATE,
                Material.CHAINMAIL_HELMET);
    }

    @Override
    public String logPrefix() {
        return "Repair Module";
    }
}
