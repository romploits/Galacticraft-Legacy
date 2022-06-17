package micdoodle8.mods.galacticraft.api.galaxies;

public interface ICelestial<T>
{

    public String getName();

    public void setOwnerId(String ownerId);

    public T get();
}
