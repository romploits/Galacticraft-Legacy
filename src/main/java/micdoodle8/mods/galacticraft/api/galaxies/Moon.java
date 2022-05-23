package micdoodle8.mods.galacticraft.api.galaxies;

import micdoodle8.mods.galacticraft.annotations.ReplaceWith;

public class Moon extends CelestialBody implements IChildBody, ICelestial<Moon>
{
    protected Planet parentPlanet = null;

    public Moon(String moonName)
    {
        super(Prefix.MOON, moonName);
    }

    public Moon setParentPlanet(Planet planet)
    {
        this.parentPlanet = planet;
        return this;
    }

    @Override
    public Planet getParentPlanet()
    {
        return this.parentPlanet;
    }

    @Override
    public Moon get()
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
}
