package micdoodle8.mods.galacticraft.api.galaxies;

import java.util.Locale;
import micdoodle8.mods.galacticraft.annotations.ReplaceWith;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody.Prefix;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.util.TranslateUtil;
import net.minecraft.util.text.translation.I18n;

@SuppressWarnings("deprecation")
public class SolarSystem extends CelestialObject implements ICelestial<SolarSystem>
{

    protected Vector3      mapPosition = null;
    protected Star         mainStar    = null;
    protected String       unlocalizedGalaxyName;

    public SolarSystem(String solarSystem, String parentGalaxy)
    {
        super(solarSystem.toLowerCase(Locale.ENGLISH), Prefix.SOLARSYSTEM);
        this.unlocalizedGalaxyName = parentGalaxy;
    }

    @Override
    public void setOwnerId(String ownerId)
    {
        super.setOwnerId(ownerId);
    }

    public String getTranslatedName()
    {
        return I18n.translateToLocal(this.getTranslationKey());
    }

    public Vector3 getMapPosition()
    {
        return this.mapPosition;
    }

    public SolarSystem setMapPosition(Vector3 mapPosition)
    {
    	mapPosition.scale(500D);
        this.mapPosition = mapPosition;
        return this;
    }

    public Star getMainStar()
    {
        return this.mainStar;
    }

    public SolarSystem setMainStar(Star star)
    {
        this.mainStar = star;
        return this;
    }

    public String getTranslatedParentGalaxyName()
    {
        return TranslateUtil.getInstance().translate(this.getTranslationKey());
    }

    public String getParentGalaxyTranslationKey()
    {
        return "galaxy." + this.unlocalizedGalaxyName;
    }

    @Override
    public SolarSystem get()
    {
        return this;
    }

    // DEPRECATED METHODS

    @Deprecated
    @ReplaceWith("getTranslationKey()")
    public String getUnlocalizedName()
    {
        return getTranslationKey();
    }

    @Deprecated
    @ReplaceWith("getTranslatedName()")
    public String getLocalizedName()
    {
        return getTranslatedName();
    }

    @Deprecated
    @ReplaceWith("getTranslatedParentGalaxyName()")
    public String getLocalizedParentGalaxyName()
    {
        return getTranslatedParentGalaxyName();
    }

    @Deprecated
    @ReplaceWith("getParentGalaxyTranslationKey()")
    public String getUnlocalizedParentGalaxyName()
    {
        return "galaxy." + this.unlocalizedGalaxyName;
    }
}
