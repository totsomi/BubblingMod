package com.hlib.bubblingmod.untils;

import com.hlib.bubblingmod.custom.item.BubblingStuffItem;
import com.hlib.bubblingmod.registries.BubbleItems;
import net.minecraft.client.model.ColorableHierarchicalModel;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;

public class ColorHandlers {
    public static void registerItemColor(RegisterColorHandlersEvent.Item event){
        event.getItemColors().register(BubblingStuffItem::getItemColor, BubbleItems.BUBBLING_STAFF.get().asItem());
    }
}
