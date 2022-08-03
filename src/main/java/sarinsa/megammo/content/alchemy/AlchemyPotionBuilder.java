package sarinsa.megammo.content.alchemy;

import com.gmail.nossr50.datatypes.skills.alchemy.AlchemyPotion;
import com.google.common.collect.ImmutableList;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.List;
import java.util.Map;

/** Helper class for constructing AlchemyPotions */
public class AlchemyPotionBuilder {

    private Material material = Material.POTION;
    private PotionData data = new PotionData(PotionType.UNCRAFTABLE);
    private String name = "GENERIC_POTION";
    private List<String> lore = ImmutableList.of("");
    private List<PotionEffect> effects = ImmutableList.of(new PotionEffect(PotionEffectType.REGENERATION, 80, 0));
    private Color color = Color.TEAL;
    private Map<ItemStack, String> children;


    public AlchemyPotionBuilder() {

    }

    public AlchemyPotionBuilder material(Material material) {
        this.material = material;
        return this;
    }

    public AlchemyPotionBuilder data(PotionData potionData) {
        this.data = potionData;
        return this;
    }

    public AlchemyPotionBuilder name(String name) {
        this.name = name;
        return this;
    }

    public AlchemyPotionBuilder lore(List<String> lore) {
        this.lore = lore;
        return this;
    }

    public AlchemyPotionBuilder effects(List<PotionEffect> effects) {
        this.effects = effects;
        return this;
    }

    public AlchemyPotionBuilder color(Color color) {
        this.color = color;
        return this;
    }

    public AlchemyPotionBuilder children(Map<ItemStack, String> children) {
        this.children = children;
        return this;
    }

    public AlchemyPotion build() {
        return new AlchemyPotion(this.material, this.data, this.name, this.lore, this.effects, this.color, this.children);
    }
}
