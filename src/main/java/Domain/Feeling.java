package Domain;

public class Feeling {
    private String name;

    public Feeling(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object obj){
        if (obj == null) return false;
        if (!Feeling.class.isAssignableFrom(obj.getClass())) return false;
        final Feeling currant = (Feeling) obj;
        if (this.name == Feelings.EARFEELING.toString() && currant.name == Feelings.EYEFEELING.toString()) return true;
        if (!this.name.equals(currant.name)) return false;

        return true;
    }
}
