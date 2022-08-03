package sarinsa.megammo.core;

import com.gmail.nossr50.mcMMO;
import org.bukkit.plugin.java.JavaPlugin;
import sarinsa.megammo.content.alchemy.MegaBrewing;

public final class MegaMMO extends JavaPlugin {

    /** Plugin instance. */
    public static MegaMMO INSTANCE;

    /** McMMO instance. */
    private mcMMO mcMMO;

    private MegaBrewing megaBrewing = new MegaBrewing();


    @Override
    public void onEnable() {
        INSTANCE = this;
        // Super annoying class name, grrr
        this.mcMMO = com.gmail.nossr50.mcMMO.p;

         megaBrewing.init();
    }

    @Override
    public void onDisable() {

    }
}
