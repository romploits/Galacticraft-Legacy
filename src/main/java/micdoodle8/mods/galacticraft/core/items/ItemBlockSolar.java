package micdoodle8.mods.galacticraft.core.items;

import micdoodle8.mods.galacticraft.api.item.GCRarity;
import micdoodle8.mods.galacticraft.core.blocks.BlockSolar;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBlockSolar extends ItemBlockDesc implements GCRarity
{

    public ItemBlockSolar(Block block)
    {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public String getTranslationKey(ItemStack par1ItemStack)
    {
        int index = Math.min(Math.max(par1ItemStack.getItemDamage() / 4, 0), BlockSolar.EnumSolarType.values().length);

        String name = BlockSolar.EnumSolarType.values()[index].getName();

        return this.getBlock().getTranslationKey() + "." + name;
    }

    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }
}
