package sarinsa.megammo.modules.alchemy;

import com.gmail.nossr50.config.skills.alchemy.PotionConfig;
import com.gmail.nossr50.datatypes.skills.alchemy.AlchemyPotion;
import org.bukkit.inventory.ItemStack;
import sarinsa.megammo.modules.AbstractModule;
import sarinsa.megammo.util.ReflectionHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Handles custom potion recipes
 * and concoction ingredients.
 */
public abstract class AbstractMegaBrewing extends AbstractModule {

    // Obtained via reflection
    private Map<String, AlchemyPotion> potionMap;
    private final Map<Integer, List<ItemStack>> potionTiers = new HashMap<>();

    protected static AlchemyPotion AWKWARD_POTION;


    protected abstract void registerPotions();


    /**
     * Registers a child potion to the given parent potion.
     */
     protected final void registerPotion(AlchemyPotion parent, AlchemyPotion child, PotionIngredient ingredient) {
        Objects.requireNonNull(parent);
        Objects.requireNonNull(child);
        Objects.requireNonNull(ingredient);

        potionMap.put(child.getName(), child);

        final ItemStack itemStack = ingredient.itemStack;
        final int tier = ingredient.tier;

        parent.getChildren().put(itemStack, child.getName());

        if (potionTiers.containsKey(tier)) {
            potionTiers.get(tier).add(itemStack);
        }
    }

    /**
     *  Registers a child potion to the given parent potion.
     *  Also creates sub potions (splash, extended, lingering etc.)
     */
    // TODO
    protected final void registerPotionWithVariants(AlchemyPotion child, PotionIngredient ingredient) {
        Objects.requireNonNull(child);
        Objects.requireNonNull(ingredient);
    }

    /** Big reflection moment! */
    @Override
    public final void init() {
        potionMap = ReflectionHelper.get(PotionConfig.getInstance(), "potionMap");

        potionTiers.put(1, ReflectionHelper.get(PotionConfig.getInstance(), "concoctionsIngredientsTierOne"));
        potionTiers.put(2, ReflectionHelper.get(PotionConfig.getInstance(), "concoctionsIngredientsTierTwo"));
        potionTiers.put(3, ReflectionHelper.get(PotionConfig.getInstance(), "concoctionsIngredientsTierThree"));
        potionTiers.put(4, ReflectionHelper.get(PotionConfig.getInstance(), "concoctionsIngredientsTierFour"));
        potionTiers.put(5, ReflectionHelper.get(PotionConfig.getInstance(), "concoctionsIngredientsTierFive"));
        potionTiers.put(6, ReflectionHelper.get(PotionConfig.getInstance(), "concoctionsIngredientsTierSix"));
        potionTiers.put(7, ReflectionHelper.get(PotionConfig.getInstance(), "concoctionsIngredientsTierSeven"));
        potionTiers.put(8, ReflectionHelper.get(PotionConfig.getInstance(), "concoctionsIngredientsTierEight"));

        AWKWARD_POTION = potionMap.get("POTION_OF_AWKWARD");

        registerPotions();
    }

    protected record PotionIngredient(ItemStack itemStack, int tier) {

    }
}
