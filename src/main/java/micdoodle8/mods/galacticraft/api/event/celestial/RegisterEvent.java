package micdoodle8.mods.galacticraft.api.event.celestial;

import micdoodle8.mods.galacticraft.api.galaxies.ICelestial;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.eventhandler.Event;

public class RegisterEvent<T extends ICelestial<T>> extends Event
{

    public T celestialObject;

    public RegisterEvent(T celestialObject, ModContainer mod)
    {
        this.celestialObject = celestialObject;
        celestialObject.setOwnerId(mod.getModId());
    }
}
