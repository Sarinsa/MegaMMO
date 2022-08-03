package sarinsa.megammo.content.alchemy;

import com.gmail.nossr50.config.skills.alchemy.PotionConfig;
import com.gmail.nossr50.datatypes.skills.alchemy.AlchemyPotion;
import com.google.common.collect.ImmutableList;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import sarinsa.megammo.core.MegaMMO;
import sarinsa.megammo.util.ReflectionHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MegaBrewing {

    private Map<String, AlchemyPotion> potionMap;
    private Map<Integer, List<ItemStack>> potionTiers = new HashMap<>();


    //------------------------ POTIONS -------------------------//

    public static final AlchemyPotion DARKNESS = new AlchemyPotionBuilder()
            .name("POTION_OF_DARKNESS")
            .color(Color.BLACK)
            .effects(ImmutableList.of(new PotionEffect(PotionEffectType.DARKNESS, 300, 0)))
            .build();

    //---------------------------------------------------------//


    public void registerPotions() {
        registerPotion(DARKNESS, new ItemStack(Material.SCULK), 4);
    }


    private void registerPotion(AlchemyPotion potion, ItemStack ingredient, int tier) {
        String key = potion.getName();

        if (potionMap.containsKey(key)) {
            MegaMMO.INSTANCE.getLogger().warning("Attempted to register alchemy potion with duplicate ID: \"" + key + "\"");
            return;
        }
        potionMap.put(key, potion);

        if (potionTiers.containsKey(tier)) {
            potionTiers.get(tier).add(ingredient);
        }
    }

    public void init() {
        potionMap = ReflectionHelper.get(PotionConfig.getInstance(), "potionMap");

        potionTiers.put(1, ReflectionHelper.get(PotionConfig.getInstance(), "concoctionsIngredientsTierOne"));
        potionTiers.put(2, ReflectionHelper.get(PotionConfig.getInstance(), "concoctionsIngredientsTierTwo"));
        potionTiers.put(3, ReflectionHelper.get(PotionConfig.getInstance(), "concoctionsIngredientsTierThree"));
        potionTiers.put(4, ReflectionHelper.get(PotionConfig.getInstance(), "concoctionsIngredientsTierFour"));
        potionTiers.put(5, ReflectionHelper.get(PotionConfig.getInstance(), "concoctionsIngredientsTierFive"));
        potionTiers.put(6, ReflectionHelper.get(PotionConfig.getInstance(), "concoctionsIngredientsTierSix"));
        potionTiers.put(7, ReflectionHelper.get(PotionConfig.getInstance(), "concoctionsIngredientsTierSeven"));
        potionTiers.put(8, ReflectionHelper.get(PotionConfig.getInstance(), "concoctionsIngredientsTierEight"));

        registerPotions();
    }
}
