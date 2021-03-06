// 
// Decompiled by Procyon v0.5.36
// 

package qolskyblockmod.pizzaclient.features.macros.ai.pathfinding.pathfinder;

import java.util.Iterator;
import qolskyblockmod.pizzaclient.util.PlayerUtil;
import qolskyblockmod.pizzaclient.features.macros.ai.movement.Movement;
import net.minecraft.util.EnumChatFormatting;
import qolskyblockmod.pizzaclient.features.macros.ai.pathfinding.Pathfinding;
import net.minecraftforge.common.MinecraftForge;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Collections;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ChatComponentText;
import qolskyblockmod.pizzaclient.util.Utils;
import qolskyblockmod.pizzaclient.PizzaClient;
import qolskyblockmod.pizzaclient.features.macros.ai.pathfinding.path.base.PathBase;

public class PathFinder extends BasePathfinder
{
    public PathFinder(final PathBase path) {
        super(path);
    }
    
    @Override
    public boolean run(final boolean messages) {
        if (PathFinder.path == null) {
            PizzaClient.mc.field_71439_g.func_145747_a((IChatComponent)new ChatComponentText(Utils.ERROR_MESSAGE + "Path returned null. Please report this."));
            return false;
        }
        try {
            if (PathFinder.path.currentPos.equals(PathFinder.path.goalPos)) {
                this.shutdown();
                return true;
            }
            PathFinder.nodes = new ArrayList<PathNode>(Collections.singletonList(new PathNode()));
            while (!PathFinder.path.finished) {
                for (final PathNode node : new ArrayList<PathNode>(PathFinder.nodes)) {
                    PathFinder.nodes.remove(node);
                    if (PathFinder.path.addBlock(node)) {
                        MinecraftForge.EVENT_BUS.register((Object)Pathfinding.instance);
                        break;
                    }
                }
                if (PathFinder.nodes.size() == 0) {
                    if (messages) {
                        PizzaClient.mc.field_71439_g.func_145747_a((IChatComponent)new ChatComponentText("PizzaClient > " + EnumChatFormatting.RED + "Failed to find a path."));
                    }
                    this.shutdown();
                    return false;
                }
                PathFinder.path.onTick();
            }
            if (messages) {
                PizzaClient.mc.field_71439_g.func_145747_a((IChatComponent)new ChatComponentText("PizzaClient > " + EnumChatFormatting.GREEN + "Found Path!"));
            }
            if (PathFinder.path.moves.size() != 0) {
                PathFinder.path.onBeginMove();
                while (PathFinder.path.moves != null && PathFinder.path.moves.size() != 0) {
                    if (PizzaClient.mc.field_71462_r != null) {
                        Movement.disableMovement();
                        Utils.sleep(200);
                        PlayerUtil.closeScreen();
                    }
                    else {
                        PathFinder.path.move();
                    }
                }
                PathFinder.path.onEndMove();
            }
            Movement.disableMovement();
            this.shutdown();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            PizzaClient.mc.field_71439_g.func_145747_a((IChatComponent)new ChatComponentText("PizzaClient > " + EnumChatFormatting.RED + "PizzaClient caught an logged an exception when calculating the path. Please report this."));
            this.shutdown();
            return false;
        }
    }
}
