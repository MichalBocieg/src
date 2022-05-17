package com.example.tutorialv1.datagen;

import com.example.tutorialv1.setup.Registration;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class TutRecipes extends RecipeProvider {

    public TutRecipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.MYSTERIOUS_ORE_ITEM),
                        Registration.MYSTERIOUS_INGOT.get(), 1.0f, 100)
                .unlockedBy("has_ore", has(Registration.MYSTERIOUS_ORE_ITEM))
                .save(consumer, "mysterious_ingot1");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.RAW_MYSTERIOUS_CHUNK.get()),
                        Registration.MYSTERIOUS_INGOT.get(), 0.0f, 100)
                .unlockedBy("has_chunk", has(Registration.RAW_MYSTERIOUS_CHUNK.get()))
                .save(consumer, "mysterious_ingot2");

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.KUPA_ORE_ITEM),
                        Registration.KUPA_INGOT.get(), 2.0f, 150)
                .unlockedBy("has_ore", has(Registration.KUPA_ORE_ITEM))
                .save(consumer, "kupa_ingot1");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.RAW_KUPA_CHUNK.get()),
                        Registration.KUPA_INGOT.get(), 1.0f, 100)
                .unlockedBy("has_chunk", has(Registration.RAW_KUPA_CHUNK.get()))
                .save(consumer, "kupa_ingot2");

        ShapedRecipeBuilder.shaped(Registration.POWERGEN.get())
                .pattern("mmm")
                .pattern("x#x")
                .pattern("#x#")
                .define('x', Tags.Items.DUSTS_REDSTONE)
                .define('#', Tags.Items.INGOTS_IRON)
                .define('m', Registration.MYSTERIOUS_INGOT.get())
                .group("tutorialv1powergen")
                .unlockedBy("mysterious", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.MYSTERIOUS_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.PGEN.get())
                .pattern("xxx")
                .pattern("x#x")
                .pattern("mmm")
                .define('x', Blocks.DIRT)
                .define('#', Tags.Items.GEMS_DIAMOND)
                .define('m', Registration.KUPA_INGOT.get())
                .group("tutorialv1pauagen")
                .unlockedBy("kupa", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.KUPA_INGOT.get()))
                .save(consumer);
    }
}
