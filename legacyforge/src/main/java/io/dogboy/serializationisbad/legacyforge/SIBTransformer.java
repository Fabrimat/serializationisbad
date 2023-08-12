package io.dogboy.serializationisbad.legacyforge;

import cpw.mods.fml.relauncher.IClassTransformer;
import io.dogboy.serializationisbad.core.Patches;

public class SIBTransformer implements IClassTransformer {
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (Patches.getPatchModuleForClass(transformedName) == null) return basicClass;

        return Patches.patchClass(basicClass, transformedName, false);
    }

    @Override
    public byte[] transform(String name, byte[] bytes) {
        return transform(name, name, bytes);
    }
}
