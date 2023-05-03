/**
 * @author [Muhammad Imran]
 * @email [muhammadghouseimran.zahirudeen@cognizant.com]
 * @create date 2023-05-01 21:30:20
 * @modify date 2023-05-01 21:30:20
 */

package sample.pojo;

import java.util.List;
import java.util.stream.Collectors;

public class Festival {
    public List<Band> bands;
    public String     name;

    public List<Band> getBands () {
        return this.bands.stream()
                .sorted((band1, band2) -> band1.getName().compareToIgnoreCase(band2.getName()))
                .collect(Collectors.toList());
    }

    public String getName () {
        return this.name;
    }
}
