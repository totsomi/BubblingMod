package com.hlib.bubblingmod.registries;

import com.hlib.bubblingmod.BubbleMod;
import com.hlib.bubblingmod.custom.item.BubblingStuffItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BubbleItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BubbleMod.MODID);

    public static final RegistryObject<Item> BUBBLING_STAFF = ITEMS.register("bubbling_staff", ()-> new BubblingStuffItem( new Item.Properties()));
   // public static final RegistryObject<Item> BLUE_BUBBLIING_STAFF = ITEMS.register("blue_bubbling_staff", ()-> new BubblingStuffItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));



    public static void register(IEventBus eventBus){
       ITEMS.register(eventBus);
    }

}
