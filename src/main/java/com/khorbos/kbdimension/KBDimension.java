package com.khorbos.kbdimension;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(KBDimension.ID)
@Mod.EventBusSubscriber(modid = KBDimension.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class KBDimension
{
    public static final String ID = "kbdimension";
    private static final Logger LOGGER = LogManager.getLogger();

    public KBDimension() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    }

    private void setup(final FMLCommonSetupEvent event){}

    private void doClientStuff(final FMLClientSetupEvent event){}

    @SubscribeEvent
    public void onServerStarting(final FMLServerStartingEvent event){}
}
