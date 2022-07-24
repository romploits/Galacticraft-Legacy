package micdoodle8.mods.galacticraft.api.galaxies;

import java.util.Locale;
import java.util.function.Predicate;
import lombok.Setter;
import micdoodle8.mods.galacticraft.annotations.ReplaceWith;
import micdoodle8.mods.galacticraft.core.util.TranslateUtil;

public abstract class CelestialObject implements ICelestial
{

    protected final String bodyName;
    @Setter
    private CelestialType type;
    @Setter
    public String ownerId;

    public CelestialObject(CelestialType type, String bodyName)
    {
        this(bodyName);
        this.type = type;
    }

    public CelestialObject(String bodyName)
    {
        this.bodyName = bodyName.toLowerCase(Locale.ENGLISH);
    }

    @Override
    public String getName()
    {
        return this.bodyName;
    }

    public String getTranslationKey()
    {
        return this.getCelestialType().getPrefix() + bodyName;
    }

    @Deprecated
    @ReplaceWith("getCelestialType().getPrefix()")
    public String getTranslationKeyPrefix()
    {
        return this.getCelestialType().getPrefix();
    }

    public CelestialType getCelestialType()
    {
        return this.type;
    }

    public String getOwnerId()
    {
        return this.ownerId;
    }

    public String getTranslatedName()
    {
        return TranslateUtil.getInstance().translate(this.getTranslationKey());
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
