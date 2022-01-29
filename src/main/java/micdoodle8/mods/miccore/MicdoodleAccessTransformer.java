package micdoodle8.mods.miccore;

import java.io.IOException;
import net.minecraftforge.fml.common.asm.transformers.AccessTransformer;

public class MicdoodleAccessTransformer extends AccessTransformer
{

    public MicdoodleAccessTransformer() throws IOException
    {
        super("META-INF/accesstransformer.cfg");
    }
}
