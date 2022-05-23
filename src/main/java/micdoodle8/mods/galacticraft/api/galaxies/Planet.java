package micdoodle8.mods.galacticraft.api.galaxies;

import micdoodle8.mods.galacticraft.annotations.ReplaceWith;
import net.minecraft.world.biome.Biome.SpawnListEntry;

public class Planet extends CelestialBody implements ICelestial<Planet>
{
    protected SolarSystem parentSolarSystem = null;

    public Planet(String planetName)
    {
        super(Prefix.PLANET, planetName);
    }

    public SolarSystem getParentSolarSystem()
    {
        return this.parentSolarSystem;
    }

    public Planet setParentSolarSystem(SolarSystem galaxy)
    {
        this.parentSolarSystem = galaxy;
        return this;
    }
    
    public static void addMobToSpawn(String planetName, SpawnListEntry mobData)
    {
        GalaxyRegistry.getPlanetOrMoonFromTranslationkey("planet." + planetName).addMobInfo(mobData);
    }

    @Override
    public Planet get()
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
