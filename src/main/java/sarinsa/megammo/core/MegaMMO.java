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
