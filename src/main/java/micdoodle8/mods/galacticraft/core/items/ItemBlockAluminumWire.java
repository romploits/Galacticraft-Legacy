package micdoodle8.mods.galacticraft.core.items;

import micdoodle8.mods.galacticraft.api.item.GCRarity;
import micdoodle8.mods.galacticraft.core.blocks.BlockAluminumWire;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBlockAluminumWire extends ItemBlockDesc implements GCRarity
{

    public ItemBlockAluminumWire(Block block)
    {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public String getTranslationKey(ItemStack itemstack)
    {
        String name = BlockAluminumWire.EnumWireType.values()[itemstack.getItemDamage()].getName();
        return this.getBlock().getTranslationKey() + "." + name;
    }

    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }
}
