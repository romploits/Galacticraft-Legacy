package micdoodle8.mods.galacticraft.api.galaxies;

import micdoodle8.mods.galacticraft.annotations.ReplaceWith;

public class Star extends CelestialBody implements ICelestial<Star>

{
    protected SolarSystem parentSolarSystem = null;

    public Star(String planetName)
    {
        super(Prefix.STAR, planetName);
    }

    public SolarSystem getParentSolarSystem()
    {
        return this.parentSolarSystem;
    }

    public Star setParentSolarSystem(SolarSystem galaxy)
    {
        this.parentSolarSystem = galaxy;
        return this;
    }

    @Override
    public Star get()
    {
        return this;
    }

    @Deprecated
    @Override
    @ReplaceWith("getPrefix()")
    public String getUnlocalizedNamePrefix()
    {
        return this.getPrefix();
    }
}
