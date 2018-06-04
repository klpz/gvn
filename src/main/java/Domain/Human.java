package Domain;

public class Human {
    private Feeling feeling;
    private String name;
    private String ms = "";

    public Human(String name, Feeling feeling) {
        this.feeling = feeling;
        this.name = name;
    }

    public String getMs() {
        return ms;
    }

    public String getName() {
        return name;
    }

    public Feeling getFeeling() {
        return feeling;
    }

    public void setFeeling(Feeling feeling){
        this.feeling = feeling;
    }

    public void clap(Fish fish, Human target) {
        if(fish.getOwner() == this.name){
            fish.changeOwner(target.name);
            ms += this.name + " молниеносным движением легонько хлопнул " + target.name + "а ладонью по уху,\n";
            System.out.print(this.name + " молниеносным движением легонько хлопнул " + target.name + " а ладонью по уху,\n");
            target.feeling = new Feeling(Feelings.DISGUST.toString());
            pickup(fish.slippedIntoHisEarCanal(target));
            //System.out.print("\nЭто то что мне нужно\n" + ms + "\n\n\n");
        }
    }

    public void pickup(Human target) {
        ms += "и он с отвращением почувствовал, как рыбка проскользнула в его слуховой канал.\n";
        ms += target.name + " в ужасе попытался было выковырять ее оттуда,\n";
        System.out.print(target.name + "в ужасе попытался было выковырять ее оттуда,\n");
        if (target.getFeeling().equals(new Feeling(Feelings.HORROR.toString()))){
            //ms += "но вдруг застыл в удивлении.\n";
            System.out.println("но вдруг застыл в удивлении.\n");
            target.feeling = new Feeling(Feelings.SURPRISED.toString());
            feelSomethingNew(target);
        }
    }
    public void feelSomethingNew(Human target){
        target.feeling = new Feeling(Feelings.EARFEELING.toString());
        if (target.feeling.equals(new Feeling(Feelings.EYEFEELING.toString()))){
            ms += "Он испытал слуховое ощущение, эквивалентное зрительному,";
            System.out.print("Он испытал слуховое ощущение, эквивалентное зрительному,\n");

        }
    }

    public void lookAtTheTwoBlackSilhouettes(){
        ms +="которое вы испытываете, когда глядите на два черных силуэта\n";
        System.out.print("которое вы испытываете, когда глядите на два черных силуэта\n");
        if (this.feeling.equals(new Feeling(Feelings.EYEFEELING.toString()))){
            seeTheWhiteVase();
        }
    }

    public void seeTheWhiteVase(){
        ms += " и вдруг начинаете видеть вместо них белую вазу.\n";
        System.out.print(" и вдруг начинаете видеть вместо них белую вазу.\n");
    }

    public boolean lookAtTheColoredDotsOnThePaper(){
        if (this.feeling.equals(new Feeling(Feelings.EYEFEELING.toString()))){
            ms += "Или когда смотрите на разноцветные точки на бумаге, из которых вдруг выплывает цифра шесть, означающая,\n";
            System.out.print("Или когда смотрите на разноцветные точки на бумаге, из которых вдруг выплывает цифра шесть, означающая,\n");
            return true;
        }
        return false;
    }
}
