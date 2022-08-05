package sarinsa.megammo.core;

import com.gmail.nossr50.mcMMO;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import sarinsa.megammo.modules.alchemy.AbstractMegaBrewing;
import sarinsa.megammo.modules.alchemy.MegaBrewing;
import sarinsa.megammo.modules.repair.AbstractMegaRepair;
import sarinsa.megammo.modules.repair.MegaRepair;
import sarinsa.megammo.event.EntityListener;

public final class MegaMMO extends JavaPlugin {

    //------------------------ Feature List ----------------------------//
    //  o = Complete feature
    //  x = Incomplete feature
    //  - = Planned feature
    //  ? = Feature to consider
    //
    //
    //  ------- ALCHEMY -------
    //  (x) Potion of Darkness, alchemy
    //  (-) Potion of Levitation, alchemy
    //
    //  ----- EXCAVATION -----
    //  (-) Command for toggling excavation drops
    //
    //  ------- TAMING -------
    //  (?) Wolf dodge arrow AI (unlockable ability; "Quick Reflexes")
    //
    //------------------------------------------------------------------//


    /** Plugin instance. */
    public static MegaMMO INSTANCE;

    /** McMMO instance. */
    private mcMMO mcMMO;

    /** Addon modules */
    private final AbstractMegaBrewing megaBrewing = new MegaBrewing();
    private final AbstractMegaRepair megaRepair = new MegaRepair();


    @Override
    public void onEnable() {
        INSTANCE = this;
        // Super annoying class name, grrr
        this.mcMMO = com.gmail.nossr50.mcMMO.p;

        megaBrewing.init();
        megaRepair.init();

        Bukkit.getPluginManager().registerEvents(new EntityListener(), this);
    }

    @Override
    public void onDisable() {

    }

    public com.gmail.nossr50.mcMMO getMcMMO() {
        return mcMMO;
    }
}
