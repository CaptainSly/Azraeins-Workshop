package io.azraein.azraeinworkshop;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import io.azraein.azraeinworkshop.block.ModBlocks;
import io.azraein.azraeinworkshop.item.ModCreativeModeTabs;
import io.azraein.azraeinworkshop.item.ModItems;
import io.azraein.azraeinworkshop.item.tiers.ModArmorMaterials;
import io.azraein.azraeinworkshop.sounds.ModSoundEvents;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(AzraeinWorkshop.MOD_ID)
public class AzraeinWorkshop {
    public static final String MOD_ID = "azraeinworkshop";
    public static final Logger LOGGER = LogUtils.getLogger();

    public AzraeinWorkshop(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

        ModSoundEvents.register(modEventBus);

        ModArmorMaterials.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
