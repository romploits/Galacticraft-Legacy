package micdoodle8.mods.galacticraft.api.galaxies;

public class Moon extends CelestialBody implements IChildBody
{
    protected Planet parentPlanet = null;

    public Moon(String moonName)
    {
        super(CelestialType.MOON, moonName);
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
}
