package Domain;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.*;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


public class TestEnvironmant {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private Fish MagicFish;
    private Human Arthur;
    private Human Ford;
    private Human You;
    private EyeDoctor eyeDoctor;

    @Before
    public void setup(){
        System.setOut(new PrintStream(outContent));
        MagicFish = new Fish("Форд");
        Arthur = new Human("Артур", new Feeling(Feelings.NORMAL.toString()));
        Ford = new Human("Форд", new Feeling(Feelings.NORMAL.toString()));
        You = new Human("Вы",new Feeling(Feelings.EYEFEELING.toString()));
        eyeDoctor = new EyeDoctor();
    }

    @After
    public void destroy(){
        System.setOut(System.out);
        MagicFish = null;
        Arthur = null;
        Ford = null;
        You = null;
        eyeDoctor = null;
    }

    @Test
    public void clap() {
        assertEquals(MagicFish.getOwner(), Ford.getName());
        if(MagicFish.getOwner() == Ford.getName()){
            MagicFish.changeOwner(Arthur.getName());
            Arthur.setFeeling(new Feeling(Feelings.DISGUST.toString()));
        }
        assertEquals(MagicFish.getOwner(), Arthur.getName());
        assertEquals(Arthur.getFeeling().getName(), Feelings.DISGUST.toString());
    }

    @Test
    public void assertEqualsEquals(){
        Arthur.setFeeling(new Feeling(Feelings.EARFEELING.toString()));
        assertTrue(Arthur.getFeeling().equals(new Feeling(Feelings.EYEFEELING.toString())));
        assertTrue(Arthur.getFeeling().equals(new Feeling(Feelings.EARFEELING.toString())));
        assertFalse(Arthur.getFeeling().equals(new Feeling(Feelings.NORMAL.toString())));
    }

    @Test
    public void feelSomethingNew(){
        if (You.lookAtTheColoredDotsOnThePaper()){
            eyeDoctor.writeBill();
        }
        assertEquals("Или когда смотрите на разноцветные точки на бумаге, из которых вдруг выплывает цифра шесть, означающая,\nчто окулист выпишет вам счет за новые очки.\n", outContent.toString());
    }

    @Test
    public void textText(){
        Ford.clap(MagicFish, Arthur);
        You.lookAtTheTwoBlackSilhouettes();
        You.lookAtTheColoredDotsOnThePaper();
        eyeDoctor.writeBill();
        assertEquals("Форд молниеносным движением легонько хлопнул Артура ладонью по уху,\n" +
                "и он с отвращением почувствовал, как рыбка проскользнула в его слуховой канал.\n" +
                "Артур в ужасе попытался было выковырять ее оттуда,\n" +
                "Он испытал слуховое ощущение, эквивалентное зрительному,которое вы испытываете, когда глядите на два черных силуэта\n" +
                " и вдруг начинаете видеть вместо них белую вазу.\n" +
                "Или когда смотрите на разноцветные точки на бумаге, из которых вдруг выплывает цифра шесть, означающая,\n" +
                "что окулист выпишет вам счет за новые очки.\n", Ford.getMs()+You.getMs()+ eyeDoctor.getMs());
    }
}
