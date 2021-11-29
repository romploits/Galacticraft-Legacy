package micdoodle8.mods.galacticraft.core.items;

import micdoodle8.mods.galacticraft.api.item.GCRarity;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBlockWallGC extends ItemBlock implements GCRarity
{

    private static final String[] types = new String[]
    {"tin", "tin", "moon", "moon_bricks", "mars", "mars_bricks"};

    public ItemBlockWallGC(Block block)
    {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int meta)
    {
        return meta;
    }

    @Override
    public String getTranslationKey(ItemStack itemstack)
    {
        int meta = itemstack.getItemDamage();

        if (meta < 0 || meta >= types.length)
        {
            meta = 0;
        }
        return super.getTranslationKey() + "." + types[meta];
    }
}
