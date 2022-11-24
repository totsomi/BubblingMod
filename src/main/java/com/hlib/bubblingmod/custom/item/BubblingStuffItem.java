package com.hlib.bubblingmod.custom.item;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.hlib.bubblingmod.BubbleMod;
import com.hlib.bubblingmod.registries.BubbleItems;
import net.minecraft.ChatFormatting;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeSpawnEggItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class BubblingStuffItem extends Item implements DyeableLeatherItem {
private static final String COLOR = "0";

    public BubblingStuffItem( Properties properties) {
        super(properties.stacksTo(1).durability(500).tab(CreativeModeTab.TAB_TOOLS));


    }

    public static int  getGemColor(ItemStack stack){
        return stack.getOrCreateTag().getInt(COLOR);
    }

    public static void setGemColor(ItemStack stack, int color){
       stack.getOrCreateTag().putInt(COLOR, color);
    }

    public static int getItemColor(ItemStack stack, int tintIndex){
      if(tintIndex == 0){
          return getGemColor(stack);
      }else {
          return 16777215;
      }
    }

    @Override
    public int getBarColor(ItemStack stack) {
        super.getBarColor(stack);
        return getGemColor(stack);
    }
    /*@Override
    public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> stacks) {
        ItemStack stack = new ItemStack(this);
        if (stacks.contains("blue_")){
       for (DyeColor color : DyeColor.values()){
           setStaffColor(stack, color.BLUE.getId());
       }
        }
        super.fillItemCategory(tab, stacks);
    }*/

    @Override
    public InteractionResult useOn(UseOnContext context) {
        ItemStack stack = context.getItemInHand();
        Player player = context.getPlayer();
        player.getCooldowns().addCooldown(this,20);
        stack.hurtAndBreak(1,player, (player1 -> {
            player1.broadcastBreakEvent(context.getHand());
        }));
        return super.useOn(context);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        super.appendHoverText(stack, level, components, flag);

        components.add(Component.literal("[" + String.valueOf(stack.getTag().get(COLOR)) + "]"));
        //stack.setHoverName(Component.literal("Bubbling Staff(" + DyeColor.byName(COLOR,DyeColor.byId(getGemColor(stack))) + ")"));
    }




    /*@Override
    public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> stacks) {

        if (tab == CreativeModeTab.TAB_TOOLS) {
                for (DyeColor color : DyeColor.values()) {
                    ItemStack stack = new ItemStack(this);
                    setGemColor(stack, color.getFireworkColor());
                    stacks.add(stack);


                }
            }

        super.fillItemCategory(tab, stacks);
    }*/

}
