package micdoodle8.mods.galacticraft.api.galaxies;

import java.util.Locale;
import java.util.function.Predicate;
import lombok.Setter;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody.Prefix;

public class CelestialObject
{

    public final String name;
    public final Prefix prefix;
    public final String translationKey;
    @Setter
    public String ownerId;

    public CelestialObject(String name, Prefix prefix)
    {
        this.name = name.toLowerCase(Locale.ENGLISH);
        this.translationKey = name;
        this.prefix = prefix;
    }

    public String getName()
    {
        return this.name;
    }

    public String getTranslationKey()
    {
        return this.getPrefix() + translationKey;
    }

    public String getPrefix()
    {
        return this.prefix.get();
    }

    public String getOwnerId()
    {
        return this.ownerId;
    }

    public static Predicate<CelestialObject> filter(String modId)
    {
        return new Predicate<CelestialObject>()
        {

            @Override
            public boolean test(CelestialObject celestialObject)
            {
                return celestialObject.getOwnerId().equals(modId);
            }
        };
    }
}
