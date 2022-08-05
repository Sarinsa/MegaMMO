package sarinsa.megammo.modules.alchemy;

import com.gmail.nossr50.datatypes.skills.alchemy.AlchemyPotion;
import com.google.common.collect.ImmutableList;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MegaBrewing extends AbstractMegaBrewing {

    //---------------------- INGREDIENTS -----------------------//

    // Level < 125 - tier 1
    // Level 125 - tier 2
    // Level 250 - tier 3
    // Level 350 - tier 4
    // Level 500 - tier 5
    // Level 750 - tier 6
    // Level 900 - tier 7
    // Level 1000 - tier 8

    private static final PotionIngredient SCULK = new PotionIngredient(new ItemStack(Material.SCULK), 5);
    private static final PotionIngredient FEATHER = new PotionIngredient(new ItemStack(Material.FEATHER), 6);

    //------------------------ POTIONS -------------------------//

    public static final AlchemyPotion LONG_DARKNESS = new AlchemyPotionBuilder()
            .name("LONG_POTION_OF_DARKNESS")
            .color(Color.BLACK)
            .effects(ImmutableList.of(new PotionEffect(PotionEffectType.DARKNESS, 900, 0)))
            .build();

    public static final AlchemyPotion STRONG_DARKNESS = new AlchemyPotionBuilder()
            .name("LONG_POTION_OF_DARKNESS")
            .color(Color.BLACK)
            .effects(ImmutableList.of(new PotionEffect(PotionEffectType.DARKNESS, 180, 1)))
            .build();

    public static final AlchemyPotion DARKNESS = new AlchemyPotionBuilder()
            .name("POTION_OF_DARKNESS")
            .color(Color.BLACK)
            .effects(ImmutableList.of(new PotionEffect(PotionEffectType.DARKNESS, 400, 0)))
            .build();

    public static final AlchemyPotion LEVITATION = new AlchemyPotionBuilder()
            .name("POTION_OF_LEVITATION")
            .effects(ImmutableList.of(new PotionEffect(PotionEffectType.LEVITATION, 400, 0)))
            .build();

    //---------------------------------------------------------//

    @Override
    protected void registerPotions() {
        info("Registering additional potions and brewing recipes...");

        registerPotion(AWKWARD_POTION, DARKNESS, SCULK);
        registerPotion(AWKWARD_POTION, LEVITATION, FEATHER);
    }

    @Override
    public String logPrefix() {
        return "Alchemy Module";
    }
}
