package tsm;

// Janne Rajuvaara
// NTK17SP 2018

import java.util.SortedSet;
import java.lang.Object;
import java.util.DoubleSummaryStatistics;

public class GreedyTSM {

    private SortedSet<City> _cities;
    private City _current;
    private City _next;
    private double _jump;
    private double _distance = Double.MAX_VALUE;
    private double _finalDistance;
    private String _path;

    public GreedyTSM(SortedSet<City> cities)
    {
        _cities = cities;
    }

    public String solve()
    {
        crunch();
        return _path + ", kokonaismatka oli " + _finalDistance;
    }

    public void crunch()
    {
        // otetaan laiskuuden kunniaksi alkupisteeksi ensimmäinen kaupunki.
        _current = _cities.first();
        _cities.remove(_cities.first());
        _path = "" + _current.get_id();


        // ei-toimiva algoritmi kek
        int i = _cities.size();
        do
        {
            for (City c : _cities)
            {
                _jump = calculateDistance(_current, c);
                System.out.println(_current.get_id() + " etäisyys kaupunkiin " + c.get_id() + " on " + _jump);
                if (_jump < _distance) {
                    _next = c;
                    _distance = _jump;
                }
            }
            _cities.remove(_next);
            _finalDistance += _jump;
            _path += " -> " + _next.get_id();
            i++;
        } while (i < _cities.size());
    }

    private double calculateDistance(City current, City c) {
        double powX = (current.get_x() - c.get_x() * 1.0);
        double powY = (current.get_y() - c.get_y() * 1.0);
        return Math.sqrt((Math.pow(powX,powX) + Math.pow(powY, powY)));
    }
}
