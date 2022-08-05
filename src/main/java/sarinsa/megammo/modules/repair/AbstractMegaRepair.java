package sarinsa.megammo.modules.repair;

import com.gmail.nossr50.datatypes.skills.ItemType;
import com.gmail.nossr50.datatypes.skills.MaterialType;
import com.gmail.nossr50.skills.repair.repairables.Repairable;
import com.gmail.nossr50.skills.repair.repairables.RepairableFactory;
import com.gmail.nossr50.skills.repair.repairables.RepairableManager;
import org.bukkit.Material;
import sarinsa.megammo.modules.AbstractModule;
import sarinsa.megammo.util.ReflectionHelper;

import javax.annotation.Nullable;

public abstract class AbstractMegaRepair extends AbstractModule {

    protected RepairableManager repairableManager;

    @Override
    public void init() {
        this.repairableManager = ReflectionHelper.getStatic(com.gmail.nossr50.mcMMO.class, "repairableManager");
        registerRepairables();
    }

    protected abstract void registerRepairables();

    protected final void registerItem(Repairable repairable) {
        this.repairableManager.registerRepairable(repairable);
    }

    protected final void registerArmorSet(Material repairMaterial, @Nullable MaterialType materialType, double xpMult, Material... armors) {
        for (Material material : armors) {
            registerItem(RepairableFactory.getRepairable(
                    material,
                    repairMaterial,
                    0,
                    material.getMaxDurability(),
                    ItemType.ARMOR,
                    materialType == null ? MaterialType.OTHER : materialType,
                    xpMult
            ));
        }
    }
}
