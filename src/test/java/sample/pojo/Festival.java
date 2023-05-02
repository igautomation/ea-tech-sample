package sample.pojo;

import java.util.List;

public class Festival {
    public List<Band> bands;
    public String     name;

    public List<Band> getBands () {
        return this.bands;
    }

    public String getName () {
        return this.name;
    }
}
