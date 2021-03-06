// 
// Decompiled by Procyon v0.5.36
// 

package qolskyblockmod.pizzaclient.features.macros.ai.pathfinding.pathfinder;

import qolskyblockmod.pizzaclient.util.MathUtil;
import java.util.Collection;
import java.util.ArrayList;
import qolskyblockmod.pizzaclient.features.macros.ai.pathfinding.util.BetterBlockPos;
import java.util.List;

public class PathNode
{
    public final List<BetterBlockPos> moves;
    public final BetterBlockPos currentPos;
    public int cost;
    
    public PathNode(final BetterBlockPos pos, final List<BetterBlockPos> moves) {
        this.currentPos = pos;
        (this.moves = new ArrayList<BetterBlockPos>(moves)).add(this.currentPos);
        this.cost = MathUtil.abs(this.currentPos.field_177962_a - PathFinder.path.goalPos.field_177962_a) + MathUtil.abs(this.currentPos.field_177961_c - PathFinder.path.goalPos.field_177961_c);
    }
    
    public PathNode() {
        this.currentPos = PathFinder.path.currentPos;
        this.moves = new ArrayList<BetterBlockPos>();
        PathFinder.path.checked.add(this.currentPos);
    }
    
    public int getCost() {
        return MathUtil.abs(this.currentPos.field_177962_a - PathFinder.path.goalPos.field_177962_a) + MathUtil.abs(this.currentPos.field_177961_c - PathFinder.path.goalPos.field_177961_c);
    }
}
