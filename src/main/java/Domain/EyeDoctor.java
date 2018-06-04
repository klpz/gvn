package Domain;

public class EyeDoctor
{
    private String ms = "";
    public EyeDoctor(){

    }

    public String getMs() {
        return ms;
    }

    public void writeBill(){
        ms += "что окулист выпишет вам счет за новые очки.\n";
        System.out.print("что окулист выпишет вам счет за новые очки.\n");
    }
}
