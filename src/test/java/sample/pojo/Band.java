/**
 * @author [Muhammad Imran]
 * @email [muhammadghouseimran.zahirudeen@cognizant.com]
 * @create date 2023-05-01 21:30:20
 * @modify date 2023-05-01 21:30:20
 */

package sample.pojo;

public class Band {
    public String name;
    public String recordLabel;

    public String getName () {
        return this.name;
    }

    public String getRecordLabel () {
        return this.recordLabel;
    }

    public void setName (final String name) {
        this.name = name;
    }

    public void setRecordLabel (final String recordLabel) {
        this.recordLabel = recordLabel;
    }
}
