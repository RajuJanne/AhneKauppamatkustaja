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
    private double _distance = 0;
    private double _finalDistance;
    private String _path;

    GreedyTSM(SortedSet<City> cities)
    {
        _cities = cities;
    }

    String solve()
    {
        crunch();
        //return _path + ", kokonaismatka oli " + _finalDistance;
        return "" + _finalDistance;
    }

    void crunch()
    {
        // otetaan laiskuuden kunniaksi alkupisteeksi ensimmäinen kaupunki.
        _current = _cities.first();
        _cities.remove(_cities.first());
        _path = "" + _current.get_id();


        // toimiva algoritmi

        do
        {
            for (City c : _cities)
            {
                _jump = calculateDistance(_current, c);
                if (_jump < _distance || _distance == 0) {
                    _next = c;
                    _distance = _jump;
                }
            }
            _cities.remove(_next);
            _finalDistance += _jump;
//            _path += "(" + _jump + ") -> " + _next.get_id();
            _current = _next;
            _distance = 0;

        } while (_cities.size() > 0);
    }

    private double calculateDistance(City current, City c) {
        double powX = (current.get_x() - c.get_x() * 1.0);
        double powY = (current.get_y() - c.get_y() * 1.0);
        // palautetaan etäisyydet 2 desimaalin tarkkuudella
        // sqrt(a² + b²) * 100 --> tulos taikuroidaan inttiin, jolloin saadaan kokonaisluku
        // jaetaan kokonaisluku double satasella, niin saadaan paluuarvolle kivasti oikee formaatti
        final double v = (int) Math.round(Math.sqrt(Math.pow(powX, 2) + Math.pow(powY, 2)) * 100) / (double) 100;
        return v;
    }
}
