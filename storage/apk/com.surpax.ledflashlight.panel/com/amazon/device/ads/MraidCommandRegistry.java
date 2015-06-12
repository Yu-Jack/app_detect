// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Map;

class MraidCommandRegistry
{
    private static Map commandMap;
    
    static {
        (MraidCommandRegistry.commandMap = new HashMap()).put("close", new MraidCommandRegistry$MraidCommandFactory() {
            @Override
            public final MraidCommand create(final Map map, final MraidView mraidView) {
                return new MraidCommandClose(map, mraidView);
            }
        });
        MraidCommandRegistry.commandMap.put("expand", new MraidCommandRegistry$MraidCommandFactory() {
            @Override
            public final MraidCommand create(final Map map, final MraidView mraidView) {
                return new MraidCommandExpand(map, mraidView);
            }
        });
        MraidCommandRegistry.commandMap.put("usecustomclose", new MraidCommandRegistry$MraidCommandFactory() {
            @Override
            public final MraidCommand create(final Map map, final MraidView mraidView) {
                return new MraidCommandUseCustomClose(map, mraidView);
            }
        });
        MraidCommandRegistry.commandMap.put("open", new MraidCommandRegistry$MraidCommandFactory() {
            @Override
            public final MraidCommand create(final Map map, final MraidView mraidView) {
                return new MraidCommandOpen(map, mraidView);
            }
        });
        MraidCommandRegistry.commandMap.put("playVideo", new MraidCommandRegistry$MraidCommandFactory() {
            @Override
            public final MraidCommand create(final Map map, final MraidView mraidView) {
                return new MraidCommandPlayVideo(map, mraidView);
            }
        });
        MraidCommandRegistry.commandMap.put("log", new MraidCommandRegistry$MraidCommandFactory() {
            @Override
            public final MraidCommand create(final Map map, final MraidView mraidView) {
                return new MraidCommandLogCat(map, mraidView);
            }
        });
    }
    
    static MraidCommand createCommand(final String s, final Map map, final MraidView mraidView) {
        final MraidCommandRegistry$MraidCommandFactory mraidCommandRegistry$MraidCommandFactory = MraidCommandRegistry.commandMap.get(s);
        if (mraidCommandRegistry$MraidCommandFactory != null) {
            return mraidCommandRegistry$MraidCommandFactory.create(map, mraidView);
        }
        return null;
    }
}
