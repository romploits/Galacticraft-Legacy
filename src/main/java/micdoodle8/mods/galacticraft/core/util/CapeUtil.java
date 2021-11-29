package micdoodle8.mods.galacticraft.core.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.experimental.UtilityClass;
import micdoodle8.mods.galacticraft.core.Constants;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Optional;

import javax.annotation.Nonnull;

@UtilityClass
public class CapeUtil
{
    
    public static class CapeResource extends ResourceLocation {

        public CapeResource(String cape)
        {
            super(Constants.MOD_ID_CORE, "textures/misc/capes/cape_" + cape + ".png");
        }
    }
    
    private static class ListURL {
        private URL url;
        
        private ListURL(String url) {
            try
            {
                this.url = new URL(url);
            } catch (MalformedURLException e)
            {
                this.url = null;
            }
        }
        
        static ListURL of(String url) {
            return new ListURL(url);
        }
        
        public URLConnection get() {
            try
            {
                return url.openConnection();
            } catch (IOException e)
            {
                return null;
            }
        }
    }

    private static ListURL jsonList = ListURL.of("https://raw.githubusercontent.com/TeamGalacticraft/capes/legacy/capesList.json");

    public static Optional<CapeResource> getCape(String uuid)
    {
        StringBuilder object = new StringBuilder();
        List<String> lines = readLines(jsonList.get());
        for (String line : lines)
        {
            object.append(line);
        }
        JsonElement json = new JsonParser().parse(object.toString());
        JsonObject obj = json.getAsJsonObject();
        
        return Optional.ofNullable(new CapeResource(obj.getAsJsonObject("players").get(uuid).getAsString()));
    }

    private static List<String> readLines(@Nonnull URLConnection connection)
    {
        try (InputStream inputStream = connection.getInputStream())
        {
            return IOUtils.readLines(inputStream, "UTF-8");
            
        } catch (IOException e)
        {
            GCLog.error(e, "Error parsing lines from InputStream!");
            return null;
        }
    }
}
