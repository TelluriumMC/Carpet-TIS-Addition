package carpettisaddition;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.script.CarpetExpression;
import carpet.script.annotation.AnnotationParser;
import carpettisaddition.translations.TISAdditionTranslations;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;


public class CarpetTISAdditionServer implements CarpetExtension
{
    public static final CarpetTISAdditionServer INSTANCE = new CarpetTISAdditionServer();
    public static final String name = "carpet-tis-addition";
    public static final String fancyName = "Carpet TIS Addition";
    public static final String compactName = name.replace("-","");  // carpettisaddition
    // should be the same as the version in gradlew.properties
    // "undefined" will be replaced with build number during github action
    public static final String version = "1.20.0+build.undefined";
    public static final Logger LOGGER = LogManager.getLogger(fancyName);
    public static MinecraftServer minecraft_server;

    @Override
    public String version()
    {
        return name;
    }

    public static void registerExtension()
    {
        CarpetServer.manageExtension(INSTANCE);
    }

    @Override
    public void onGameStarted()
    {
        CarpetServer.settingsManager.parseSettingsClass(CarpetTISAdditionSettings.class);
    }

    @Override
    public void onServerLoaded(MinecraftServer server)
    {
        minecraft_server = server;
    }

    /**
     * Carpet has issue (bug) to call onServerLoadedWorlds in IntegratedServer, so just do it myself to make sure it works properly
     * Only in <= 1.15.x
     */
    public void onServerLoadedWorldsCTA(MinecraftServer server)
    {

    }

    @Override
    public void onServerClosed(MinecraftServer server)
    {

    }

    @Override
    public void onTick(MinecraftServer server)
    {

    }

    public static void onCarpetClientHello(ServerPlayerEntity player)
    {

    }

    @Override
    public void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher)
    {
    }

    @Override
    public Map<String, String> canHasTranslations(String lang)
    {
        return TISAdditionTranslations.getTranslationFromResourcePath(lang);
    }
}
