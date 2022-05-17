package com.example.tutorialv1.datagen;

import com.example.tutorialv1.TutorialV1;
import com.example.tutorialv1.setup.Registration;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TutBlockStates extends BlockStateProvider {

    public TutBlockStates(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, TutorialV1.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        registerPowergen();
        registerPgen();

        simpleBlock(Registration.MYSTERIOUS_ORE_OVERWORLD.get());
        simpleBlock(Registration.MYSTERIOUS_ORE_NETHER.get());
        simpleBlock(Registration.MYSTERIOUS_ORE_END.get());
        simpleBlock(Registration.MYSTERIOUS_ORE_DEEPSLATE.get());

        simpleBlock(Registration.KUPA_ORE_OVERWORLD.get());
        simpleBlock(Registration.KUPA_ORE_NETHER.get());
        simpleBlock(Registration.KUPA_ORE_END.get());
        simpleBlock(Registration.KUPA_ORE_DEEPSLATE.get());
    }

    private void registerPowergen() {
        BlockModelBuilder frame = models().getBuilder("block/powergen/main");
        frame.parent(models().getExistingFile(mcLoc("cube")));

        floatingCube(frame, 0f, 0f, 0f, 1f, 16f, 1f);
        floatingCube(frame, 15f, 0f, 0f, 16f, 16f, 1f);
        floatingCube(frame, 0f, 0f, 15f, 1f, 16f, 16f);
        floatingCube(frame, 15f, 0f, 15f, 16f, 16f, 16f);

        floatingCube(frame, 1f, 0f, 0f, 15f, 1f, 1f);
        floatingCube(frame, 1f, 15f, 0f, 15f, 16f, 1f);
        floatingCube(frame, 1f, 0f, 15f, 15f, 1f, 16f);
        floatingCube(frame, 1f, 15f, 15f, 15f, 16f, 16f);

        floatingCube(frame, 0f, 0f, 1f, 1f, 1f, 15f);
        floatingCube(frame, 15f, 0f, 1f, 16f, 1f, 15f);
        floatingCube(frame, 0f, 15f, 1f, 1f, 16f, 15f);
        floatingCube(frame, 15f, 15f, 1f, 16f, 16f, 15f);

        floatingCube(frame, 1f, 1f, 1f, 15f, 15f, 15f);

        frame.texture("window", modLoc("block/powergen_window"));
        frame.texture("particle", modLoc("block/powergen_off"));

        createPowergenModel(Registration.POWERGEN.get(), frame);
    }

    private void registerPgen() {
        BlockModelBuilder frame = models().getBuilder("block/pgen/main");
        frame.parent(models().getExistingFile(mcLoc("cube")));

        floatingCube(frame, 0f, 0f, 0f, 2f, 16f, 2f);
        floatingCube(frame, 14f, 0f, 0f, 16f, 16f, 2f);
        floatingCube(frame, 0f, 0f, 14f, 2f, 16f, 16f);
        floatingCube(frame, 14f, 0f, 14f, 16f, 16f, 16f);

        floatingCube(frame, 2f, 0f, 0f, 14f, 2f, 2f);
        floatingCube(frame, 2f, 14f, 0f, 14f, 16f, 2f);
        floatingCube(frame, 2f, 0f, 14f, 14f, 2f, 16f);
        floatingCube(frame, 2f, 14f, 14f, 14f, 16f, 16f);

        floatingCube(frame, 0f, 0f, 2f, 2f, 2f, 14f);
        floatingCube(frame, 14f, 0f, 2f, 16f, 2f, 14f);
        floatingCube(frame, 0f, 14f, 2f, 2f, 16f, 14f);
        floatingCube(frame, 14f, 14f, 2f, 16f, 16f, 14f);

        floatingCube(frame, 2f, 2f, 2f, 14f, 14f, 14f);

        frame.texture("window", modLoc("block/pgen_window"));
        frame.texture("particle", modLoc("block/pgen_off"));

        createPgenModel(Registration.PGEN.get(), frame);
    }

    private void floatingCube(BlockModelBuilder builder, float fx, float fy, float fz, float tx, float ty, float tz) {
        builder.element().from(fx, fy, fz).to(tx, ty, tz).allFaces((direction, faceBuilder) -> faceBuilder.texture("#window")).end();
    }

    private void createPowergenModel(Block block, BlockModelBuilder frame) {
        BlockModelBuilder singleOff = models().getBuilder("block/powergen/singleoff").element().from(3, 3, 3).to(13, 13, 13).face(Direction.DOWN).texture("#single").end().end().texture("single", modLoc("block/powergen_off"));
        BlockModelBuilder singleOn = models().getBuilder("block/powergen/singleon").element().from(3, 3, 3).to(13, 13, 13).face(Direction.DOWN).texture("#single").end().end().texture("single", modLoc("block/powergen_on"));

        MultiPartBlockStateBuilder bld = getMultipartBuilder(block);

        bld.part().modelFile(frame).addModel();

        BlockModelBuilder[] models = new BlockModelBuilder[]{singleOff, singleOn};
        for (int i = 0; i < 2; i++) {
            boolean powered = i == 1;
            bld.part().modelFile(models[i]).addModel().condition(BlockStateProperties.POWERED, powered);
            bld.part().modelFile(models[i]).rotationX(180).addModel().condition(BlockStateProperties.POWERED, powered);
            bld.part().modelFile(models[i]).rotationX(90).addModel().condition(BlockStateProperties.POWERED, powered);
            bld.part().modelFile(models[i]).rotationX(270).addModel().condition(BlockStateProperties.POWERED, powered);
            bld.part().modelFile(models[i]).rotationY(90).rotationX(90).addModel().condition(BlockStateProperties.POWERED, powered);
            bld.part().modelFile(models[i]).rotationY(270).rotationX(90).addModel().condition(BlockStateProperties.POWERED, powered);
        }
    }

    private void createPgenModel(Block block, BlockModelBuilder frame) {
        BlockModelBuilder singleOff = models().getBuilder("block/pgen/singleoff").element().from(4, 4, 4).to(12, 12, 12).face(Direction.DOWN).texture("#single").end().end().texture("single", modLoc("block/pgen_off"));
        BlockModelBuilder singleOn = models().getBuilder("block/pgen/singleon").element().from(4, 4, 4).to(12, 12, 12).face(Direction.DOWN).texture("#single").end().end().texture("single", modLoc("block/pgen_on"));

        MultiPartBlockStateBuilder bld = getMultipartBuilder(block);

        bld.part().modelFile(frame).addModel();

        BlockModelBuilder[] models = new BlockModelBuilder[]{singleOff, singleOn};
        for (int i = 0; i < 2; i++) {
            boolean powered = i == 1;
            bld.part().modelFile(models[i]).addModel().condition(BlockStateProperties.POWERED, powered);
            bld.part().modelFile(models[i]).rotationX(180).addModel().condition(BlockStateProperties.POWERED, powered);
            bld.part().modelFile(models[i]).rotationX(90).addModel().condition(BlockStateProperties.POWERED, powered);
            bld.part().modelFile(models[i]).rotationX(270).addModel().condition(BlockStateProperties.POWERED, powered);
            bld.part().modelFile(models[i]).rotationY(90).rotationX(90).addModel().condition(BlockStateProperties.POWERED, powered);
            bld.part().modelFile(models[i]).rotationY(270).rotationX(90).addModel().condition(BlockStateProperties.POWERED, powered);
        }
    }
}
