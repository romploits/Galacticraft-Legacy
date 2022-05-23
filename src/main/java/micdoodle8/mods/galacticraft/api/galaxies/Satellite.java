package micdoodle8.mods.galacticraft.api.galaxies;

import micdoodle8.mods.galacticraft.annotations.ReplaceWith;
import net.minecraft.world.WorldProvider;

public class Satellite extends CelestialBody implements IChildBody, ICelestial<Satellite>
{
    protected Planet parentCelestialBody = null;
    protected int dimensionIdStatic = 0;

    public Satellite(String satelliteName)
    {
        super(Prefix.SATELLITE, satelliteName);
    }

    @Override
    public Planet getParentPlanet()
    {
        return this.parentCelestialBody;
    }

    public Satellite setParentBody(Planet parentCelestialBody)
    {
        this.parentCelestialBody = parentCelestialBody;
        return this;
    }

    public CelestialBody setDimensionInfo(int providerIdDynamic, int providerIdStatic, Class<? extends WorldProvider> providerClass)
    {
        this.dimensionIdStatic = providerIdStatic;
        return super.setDimensionInfo(providerIdDynamic, providerClass, false);
    }

    public int getDimensionIdStatic()
    {
        return dimensionIdStatic;
    }

    @Override
    public Satellite get()
    {
        return this;
    }

    @Override
    @Deprecated
    @ReplaceWith("getPrefix()")
    public String getUnlocalizedNamePrefix()
    {
        return this.getPrefix();
    }

    @Override
    @Deprecated
    public CelestialBody setDimensionInfo(int providerId, Class<? extends WorldProvider> providerClass, boolean autoRegister)
    {
        throw new UnsupportedOperationException("Satellite registered using an outdated method (setDimensionInfo)! Tell Galacticraft addon authors to update to the latest API.");
    }
}
