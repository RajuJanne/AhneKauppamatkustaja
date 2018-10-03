package tsm;

// Janne Rajuvaara
// NTK17SP 2018

import java.util.SortedSet;

public class GreedyTSM {

    private SortedSet<City> _cities;
    private City current;
    private double[] _distances;
    private double _finalDistance;
    private String[] _path;

    public GreedyTSM(SortedSet<City> cities)
    {
        _cities = cities;
    }

    public String solve()
    {
        crunch();
        return "";
    }

    public void crunch()
    {
        // otetaan laiskuuden kunniaksi alkupisteeksi ensimmäinen kaupunki.
        current = _cities.first();
        _cities.remove(_cities.first());


        int i = _cities.size();
        for (City c : _cities)
        {
            double powX = (current.get_x() - c.get_x() * 1.0);
            double powY = (current.get_y() - c.get_y() * 1.0);
            _distances[i] = Math.sqrt((Math.pow(powX,powX) + Math.pow(powY, powY)));
        }
    }
}
