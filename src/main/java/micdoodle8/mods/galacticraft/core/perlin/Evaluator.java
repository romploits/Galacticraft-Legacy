package micdoodle8.mods.galacticraft.core.perlin;

public interface Evaluator
{

    double evalNoise(double x);

    double evalNoise(double x, double y);

    double evalNoise(double x, double y, double z);
}
