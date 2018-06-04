package Domain;

public class Fish {
    private String owner;

    public String ms = "";

    public Fish(String owner){
        this.owner = owner;
    }

    public void changeOwner(String owner){
        this.owner = owner;
    }

    public Human slippedIntoHisEarCanal(Human target){
        ms += "и он с отвращением почувствовал, как рыбка проскользнула в его слуховой канал.";
        System.out.print("и он с отвращением почувствовал, как рыбка проскользнула в его слуховой канал.\n");
        target.setFeeling(new Feeling(Feelings.HORROR.toString()));
        return target;
    }

    public String getOwner(){
        return owner;
    }
}
