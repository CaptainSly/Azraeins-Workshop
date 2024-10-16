package io.azraein.azraeinworkshop.component;

import java.util.function.UnaryOperator;

import io.azraein.azraeinworkshop.AzraeinWorkshop;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModDataComponents {

    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES = DeferredRegister
            .createDataComponents(ResourceKey.createRegistryKey(
                    ResourceLocation.fromNamespaceAndPath(AzraeinWorkshop.MOD_ID, "components/")),
                    AzraeinWorkshop.MOD_ID);

    private static <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name,
            UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return DATA_COMPONENT_TYPES.register(name, () -> builderOperator.apply(DataComponentType.builder()).build());
    }

    public static void register(IEventBus eventBus) {
        DATA_COMPONENT_TYPES.register(eventBus);
    }

}
