package com.example.tutorialv1.datagen;

import com.example.tutorialv1.TutorialV1;
import com.example.tutorialv1.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TutItemTags extends ItemTagsProvider {

    public TutItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
        super(generator, blockTags, TutorialV1.MODID, helper);
    }

    @Override
    protected void addTags() {
        tag(Tags.Items.ORES)
                .add(Registration.MYSTERIOUS_ORE_OVERWORLD_ITEM.get())
                .add(Registration.MYSTERIOUS_ORE_NETHER_ITEM.get())
                .add(Registration.MYSTERIOUS_ORE_END_ITEM.get())
                .add(Registration.MYSTERIOUS_ORE_DEEPSLATE_ITEM.get())

                .add(Registration.KUPA_ORE_OVERWORLD_ITEM.get())
                .add(Registration.KUPA_ORE_NETHER_ITEM.get())
                .add(Registration.KUPA_ORE_END_ITEM.get())
                .add(Registration.KUPA_ORE_DEEPSLATE_ITEM.get());
        tag(Tags.Items.INGOTS)
                .add(Registration.MYSTERIOUS_INGOT.get())

                .add(Registration.KUPA_INGOT.get());
        tag(Registration.MYSTERIOUS_ORE_ITEM)
                .add(Registration.MYSTERIOUS_ORE_OVERWORLD_ITEM.get())
                .add(Registration.MYSTERIOUS_ORE_NETHER_ITEM.get())
                .add(Registration.MYSTERIOUS_ORE_END_ITEM.get())
                .add(Registration.MYSTERIOUS_ORE_DEEPSLATE_ITEM.get());

        tag(Registration.KUPA_ORE_ITEM)
                .add(Registration.KUPA_ORE_OVERWORLD_ITEM.get())
                .add(Registration.KUPA_ORE_NETHER_ITEM.get())
                .add(Registration.KUPA_ORE_END_ITEM.get())
                .add(Registration.KUPA_ORE_DEEPSLATE_ITEM.get());
    }

    @Override
    public String getName() {
        return "Tutorial Tags";
    }
}
