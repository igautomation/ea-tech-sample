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
