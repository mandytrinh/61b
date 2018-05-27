package creatures;
import huglife.*;

import java.awt.Color;
import java.util.Map;
import java.util.List;

public class Clorus extends Creature
{
    /** red color. */
    private int r;
    /** green color. */
    private int g;
    /** blue color. */
    private int b;

    public Clorus(double e)
    {
        super("clorus");
        energy = e;
        r = 0;
        b = 0;
        g = 0;
    }

    public Clorus()
    {
        this(1);
    }

    public Color color()
    {
        r = 34;
        b = 231;
        g = 0;
        return color(r, g, b);
    }

    @Override
    public Clorus replicate()
    {
        energy = energy * 0.5;
        Clorus babyClorus = new Clorus(energy);
        return babyClorus;
    }

    @Override
    public void attack(Creature c)
    {
        energy = energy + c.energy();
    }

    @Override
    public void stay()
    {
        energy = energy - 0.01;
    }
    @Override
    public void move()
    {
        energy = energy - 0.03;
    }
    @Override
    public Action chooseAction(Map<Direction, Occupant> neighbors)
    {
        Clorus c = new Clorus(energy);
        List<Direction> emptySpots = getNeighborsOfType(neighbors, "empty");
        List<Direction> plips = getNeighborsOfType(neighbors,"plip");
        if (emptySpots.size() == 0)
        {
            return new Action(Action.ActionType.STAY);
        }
        else if (plips.size() > 0)
        {
            Direction attackDir = HugLifeUtils.randomEntry(plips);
            return new Action(Action.ActionType.ATTACK);
        }
        else if (emptySpots.size() > 0)
        {
            if (energy >= 1)
            {
                Direction replicateDir = HugLifeUtils.randomEntry(emptySpots);
                return new Action(Action.ActionType.REPLICATE);
            }
            return new Action(Action.ActionType.MOVE);
        }
        return new Action(Action.ActionType.STAY);
    }


}
