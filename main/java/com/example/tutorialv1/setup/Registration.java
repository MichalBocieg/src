package com.example.tutorialv1.setup;

import com.example.tutorialv1.TutorialV1;
import com.example.tutorialv1.blocks.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.example.tutorialv1.TutorialV1.MODID;

public class Registration {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MODID);
    private static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, MODID);

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
        BLOCK_ENTITIES.register(bus);
        CONTAINERS.register(bus);
    }

    public static final BlockBehaviour.Properties ORE_BLOCK_PROPERTIES = BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops();
    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(ModSetup.ITEM_GROUP);

    //kazdy block musi miec item zeby dalo sie go trzymac w eq
    public static final RegistryObject<Block> MYSTERIOUS_ORE_OVERWORLD = BLOCKS.register("mysterious_ore_overworld", () -> new Block(ORE_BLOCK_PROPERTIES));
    public static final RegistryObject<Item> MYSTERIOUS_ORE_OVERWORLD_ITEM = fromBlock(MYSTERIOUS_ORE_OVERWORLD);
    public static final RegistryObject<Block> MYSTERIOUS_ORE_NETHER = BLOCKS.register("mysterious_ore_nether", () -> new Block(ORE_BLOCK_PROPERTIES));
    public static final RegistryObject<Item> MYSTERIOUS_ORE_NETHER_ITEM = fromBlock(MYSTERIOUS_ORE_NETHER);
    public static final RegistryObject<Block> MYSTERIOUS_ORE_END = BLOCKS.register("mysterious_ore_end", () -> new Block(ORE_BLOCK_PROPERTIES));
    public static final RegistryObject<Item> MYSTERIOUS_ORE_END_ITEM = fromBlock(MYSTERIOUS_ORE_END);
    public static final RegistryObject<Block> MYSTERIOUS_ORE_DEEPSLATE = BLOCKS.register("mysterious_ore_deepslate", () -> new Block(ORE_BLOCK_PROPERTIES));
    public static final RegistryObject<Item> MYSTERIOUS_ORE_DEEPSLATE_ITEM = fromBlock(MYSTERIOUS_ORE_DEEPSLATE);

    public static final RegistryObject<Item> RAW_MYSTERIOUS_CHUNK = ITEMS.register("raw_mysterious_chunk", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> MYSTERIOUS_INGOT = ITEMS.register("mysterious_ingot", () -> new Item(ITEM_PROPERTIES));

    public static final Tags.IOptionalNamedTag<Block> MYSTERIOUS_ORE = BlockTags.createOptional(new ResourceLocation(TutorialV1.MODID, "mysterious_ore"));
    public static final Tags.IOptionalNamedTag<Item> MYSTERIOUS_ORE_ITEM = ItemTags.createOptional(new ResourceLocation(TutorialV1.MODID, "mysterious_ore"));

    public static final RegistryObject<PowergenBlock> POWERGEN = BLOCKS.register("powergen", PowergenBlock::new);
    public static final RegistryObject<Item> POWERGEN_ITEM = fromBlock(POWERGEN);
    public static final RegistryObject<BlockEntityType<PowergenBE>> POWERGEN_BE = BLOCK_ENTITIES.register("powergen", () -> BlockEntityType.Builder.of(PowergenBE::new, POWERGEN.get()).build(null));
    public static final RegistryObject<MenuType<PowergenContainer>> POWERGEN_CONTAINER = CONTAINERS.register("powergen",
            () -> IForgeMenuType.create((windowId, inv, data) -> new PowergenContainer(windowId, data.readBlockPos(), inv, inv.player)));

    public static final RegistryObject<PowergenBlock> PGEN = BLOCKS.register("pgen", PowergenBlock::new);
    public static final RegistryObject<Item> PGEN_ITEM = fromBlock(PGEN);
    public static final RegistryObject<BlockEntityType<PowergenBE>> PGEN_BE = BLOCK_ENTITIES.register("pgen", () -> BlockEntityType.Builder.of(PowergenBE::new, PGEN.get()).build(null));
    public static final RegistryObject<MenuType<PowergenContainer>> PGEN_CONTAINER = CONTAINERS.register("pgen",
            () -> IForgeMenuType.create((windowId, inv, data) -> new PowergenContainer(windowId, data.readBlockPos(), inv, inv.player)));

    //testing czy umiem zrobic wlasny zestaw do rudy
    public static final RegistryObject<Block> KUPA_ORE_OVERWORLD = BLOCKS.register("kupa_ore_overworld", () -> new Block(ORE_BLOCK_PROPERTIES));
    public static final RegistryObject<Item> KUPA_ORE_OVERWORLD_ITEM = fromBlock(KUPA_ORE_OVERWORLD);
    public static final RegistryObject<Block> KUPA_ORE_NETHER = BLOCKS.register("kupa_ore_nether", () -> new Block(ORE_BLOCK_PROPERTIES));
    public static final RegistryObject<Item> KUPA_ORE_NETHER_ITEM = fromBlock(KUPA_ORE_NETHER);
    public static final RegistryObject<Block> KUPA_ORE_END = BLOCKS.register("kupa_ore_end", () -> new Block(ORE_BLOCK_PROPERTIES));
    public static final RegistryObject<Item> KUPA_ORE_END_ITEM = fromBlock(KUPA_ORE_END);
    public static final RegistryObject<Block> KUPA_ORE_DEEPSLATE = BLOCKS.register("kupa_ore_deepslate", () -> new Block(ORE_BLOCK_PROPERTIES));
    public static final RegistryObject<Item> KUPA_ORE_DEEPSLATE_ITEM = fromBlock(KUPA_ORE_DEEPSLATE);

    public static final RegistryObject<Item> RAW_KUPA_CHUNK = ITEMS.register("raw_kupa_chunk", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> KUPA_INGOT = ITEMS.register("kupa_ingot", () -> new Item(ITEM_PROPERTIES));

    public static final Tags.IOptionalNamedTag<Block> KUPA_ORE = BlockTags.createOptional(new ResourceLocation(TutorialV1.MODID, "kupa_ore"));
    public static final Tags.IOptionalNamedTag<Item> KUPA_ORE_ITEM = ItemTags.createOptional(new ResourceLocation(TutorialV1.MODID, "kupa_ore"));


    // Convenience function: Take a RegistryObject<Block> and make a corresponding RegistryObject<Item> from it
    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));

    }
}
