package com.example.tutorialv1.datagen;

import com.example.tutorialv1.TutorialV1;
import com.example.tutorialv1.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TutItemModels extends ItemModelProvider {

    public TutItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, TutorialV1.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(Registration.MYSTERIOUS_ORE_OVERWORLD_ITEM.get().getRegistryName().getPath(), modLoc("block/mysterious_ore_overworld"));
        withExistingParent(Registration.MYSTERIOUS_ORE_NETHER_ITEM.get().getRegistryName().getPath(), modLoc("block/mysterious_ore_nether"));
        withExistingParent(Registration.MYSTERIOUS_ORE_END_ITEM.get().getRegistryName().getPath(), modLoc("block/mysterious_ore_end"));
        withExistingParent(Registration.MYSTERIOUS_ORE_DEEPSLATE_ITEM.get().getRegistryName().getPath(), modLoc("block/mysterious_ore_deepslate"));

        singleTexture(Registration.RAW_MYSTERIOUS_CHUNK.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/raw_mysterious_chunk"));
        singleTexture(Registration.MYSTERIOUS_INGOT.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/mysterious_ingot"));


        withExistingParent(Registration.KUPA_ORE_OVERWORLD_ITEM.get().getRegistryName().getPath(), modLoc("block/kupa_ore_overworld"));
        withExistingParent(Registration.KUPA_ORE_NETHER_ITEM.get().getRegistryName().getPath(), modLoc("block/kupa_ore_nether"));
        withExistingParent(Registration.KUPA_ORE_END_ITEM.get().getRegistryName().getPath(), modLoc("block/kupa_ore_end"));
        withExistingParent(Registration.KUPA_ORE_DEEPSLATE_ITEM.get().getRegistryName().getPath(), modLoc("block/kupa_ore_deepslate"));

        singleTexture(Registration.RAW_KUPA_CHUNK.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/raw_kupa_chunk"));
        singleTexture(Registration.KUPA_INGOT.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/kupa_ingot"));

        withExistingParent(Registration.POWERGEN_ITEM.get().getRegistryName().getPath(), modLoc("block/powergen/main"));

        withExistingParent(Registration.PGEN_ITEM.get().getRegistryName().getPath(), modLoc("block/pgen/main"));
    }
}
