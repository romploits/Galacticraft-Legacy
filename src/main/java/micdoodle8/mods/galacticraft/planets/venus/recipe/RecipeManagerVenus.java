package micdoodle8.mods.galacticraft.planets.venus.recipe;

import java.util.Arrays;
import java.util.HashMap;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.CircuitFabricatorRecipes;
import micdoodle8.mods.galacticraft.api.recipe.SpaceStationRecipe;
import micdoodle8.mods.galacticraft.api.world.SpaceStationType;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.items.ItemBasic;
import micdoodle8.mods.galacticraft.core.recipe.RecipeManagerGC;
import micdoodle8.mods.galacticraft.planets.venus.ConfigManagerVenus;
import micdoodle8.mods.galacticraft.planets.venus.VenusBlocks;
import micdoodle8.mods.galacticraft.planets.venus.VenusItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeManagerVenus
{

    public static void loadCompatibilityRecipes()
    {
    }

    public static void addSpaceStationRecipes()
    {
        final HashMap<Object, Integer> spaceStationRequirements = new HashMap<>(4, 1.0F);
        spaceStationRequirements.put("ingotTin", 32);
        spaceStationRequirements.put(RecipeManagerGC.aluminumIngots, 16);
        spaceStationRequirements.put(new ItemStack(GCItems.basicItem, 1, ItemBasic.WAFER_ADVANCED), 1);
        spaceStationRequirements.put(Items.IRON_INGOT, 24);
        GalacticraftRegistry.registerSpaceStation(new SpaceStationType(ConfigManagerVenus.dimensionIDVenusSpacestation, ConfigManagerVenus.dimensionIDVenus, new SpaceStationRecipe(spaceStationRequirements)));

    }

    public static void addUniversalRecipes()
    {
        OreDictionary.registerOre("ingotLead", new ItemStack(VenusItems.basicItem, 1, 1));
        OreDictionary.registerOre("waferSolarThin", new ItemStack(VenusItems.basicItem, 1, 6));

        // Smelting
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(VenusBlocks.venusBlock, 1, 6), new ItemStack(GCItems.basicItem, 1, 5), 0.5F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(VenusBlocks.venusBlock, 1, 7), new ItemStack(GCItems.basicItem, 1, 3), 0.5F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(VenusBlocks.venusBlock, 1, 8), new ItemStack(VenusItems.basicItem, 1, 1), 1.0F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(VenusBlocks.venusBlock, 1, 9), new ItemStack(Items.QUARTZ), 0.2F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(VenusBlocks.venusBlock, 1, 11), new ItemStack(GCItems.basicItem, 1, 4), 0.5F);

        ItemStack solarPanels = new ItemStack(VenusItems.basicItem, 3, 6);
        ItemStack silicon = new ItemStack(GCItems.basicItem, 1, 2);
        CircuitFabricatorRecipes.addRecipe(solarPanels, Arrays.asList(new ItemStack(Items.DIAMOND), silicon, silicon, new ItemStack(Items.REDSTONE), new ItemStack(VenusItems.basicItem, 1, 4)));
    }
}
