package com.example.tutorialv1.datagen;

import com.example.tutorialv1.TutorialV1;
import com.example.tutorialv1.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import static com.example.tutorialv1.blocks.PowergenBlock.MESSAGE_POWERGEN;
import static com.example.tutorialv1.blocks.PowergenBlock.SCREEN_TUTORIAL_POWERGEN;
import static com.example.tutorialv1.setup.ModSetup.TAB_NAME;

public class TutLanguageProvider extends LanguageProvider {

    public TutLanguageProvider(DataGenerator gen, String locale) {
        super(gen, TutorialV1.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + TAB_NAME, "Tutorial");

        add(Registration.MYSTERIOUS_ORE_OVERWORLD.get(), "Mysterious ore");
        add(Registration.MYSTERIOUS_ORE_NETHER.get(), "Mysterious ore");
        add(Registration.MYSTERIOUS_ORE_END.get(), "Mysterious ore");
        add(Registration.MYSTERIOUS_ORE_DEEPSLATE.get(), "Mysterious ore");

        add(Registration.RAW_MYSTERIOUS_CHUNK.get(), "Mysterious Raw Chunk");
        add(Registration.MYSTERIOUS_INGOT.get(), "Mysterious Ingot");

        add(Registration.KUPA_ORE_OVERWORLD.get(), "Poo ore");
        add(Registration.KUPA_ORE_NETHER.get(), "Poo ore");
        add(Registration.KUPA_ORE_END.get(), "Poo ore");
        add(Registration.KUPA_ORE_DEEPSLATE.get(), "Poo ore");

        add(Registration.RAW_KUPA_CHUNK.get(), "Poo Raw Chunk");
        add(Registration.KUPA_INGOT.get(), "Poo Ingot");

        add(MESSAGE_POWERGEN, "Power generator generating %s per tick!");
        add(SCREEN_TUTORIAL_POWERGEN, "Power generator");

        add(Registration.POWERGEN.get(), "Power generator");

        add(Registration.PGEN.get(), "P. generator");
    }
}
