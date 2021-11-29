package micdoodle8.mods.galacticraft.api.recipe;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

import java.util.HashMap;

import javax.annotation.Nonnull;

public interface INasaWorkbenchRecipe
{

    boolean matches(IInventory inventory);

    int getRecipeSize();

    @Nonnull
    ItemStack getRecipeOutput();

    HashMap<Integer, ItemStack> getRecipeInput();
}
