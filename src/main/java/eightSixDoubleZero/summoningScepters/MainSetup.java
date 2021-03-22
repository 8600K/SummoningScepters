package eightSixDoubleZero.summoningScepters;

import eightSixDoubleZero.summoningScepters.core.init.BlockInit;
import eightSixDoubleZero.summoningScepters.core.init.ItemInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("summoningscepters")
public class MainSetup
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "summoningscepters";
    public static final ItemGroup SUMMONING_SCEPTERS = new SummoningGroup("summoningTab");

    public MainSetup() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);


        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        //LOGGER.info("HELLO FROM PREINIT");

    }

    public static class SummoningGroup extends ItemGroup
    {

        public SummoningGroup(String label) {
            super(label);
        }

        @Override
        public ItemStack makeIcon() {
            return ItemInit.ZOMBIE_SUMMON_TOME.get().getDefaultInstance();
        }


    }
}
