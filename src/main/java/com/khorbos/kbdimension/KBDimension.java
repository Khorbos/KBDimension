package com.khorbos.kbdimension;

import com.khorbos.kbdimension.core.init.Registries;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
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
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        Registries.initRegistries(modEventBus);
    }

    private void setup(final FMLCommonSetupEvent event){}

    private void doClientStuff(final FMLClientSetupEvent event){}

    @SubscribeEvent
    public void onServerStarting(final FMLServerStartingEvent event){}

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event){
        final IForgeRegistry<Item> registry = event.getRegistry();
        Registries.BLOCKS.getEntries().stream()
                .map(RegistryObject::get).forEach(block -> {
                    final Item.Properties properties = new Item.Properties().group(ItemGroup.MISC);
                    final BlockItem blockItem = new BlockItem(block, properties);
                    blockItem.setRegistryName(block.getRegistryName());
                    registry.register(blockItem);

                });
        KBDimension.LOGGER.debug("KBDimensionMod Registry Initialized");
    }
}
