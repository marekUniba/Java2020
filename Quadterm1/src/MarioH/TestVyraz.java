package MarioH;
//import LISTTestScoring.LISTTestScoring;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestVyraz {
//    private static LISTTestScoring scoring = null;

    @BeforeClass
    public static void initScoring() {
//        scoring = new LISTTestScoring();
//        scoring.setScore("lang:common_list_test_scoring_name", 0, 100);
    }

    static Vyraz v0 = new Operator('+',
                new Operator('*', new Konstanta(3), new Konstanta(4)),
                new Operator('-', new Konstanta(1), new Konstanta(2))
        );
    static Vyraz v1 = new Operator('-',
                new Operator('-', new Konstanta(3), new Konstanta(4)),
                new Operator('-', new Konstanta(1), new Konstanta(2))
        );
    static Vyraz v2 = new Operator('-',
                new Operator('-', new Konstanta(3), new Konstanta(4)),
                new Operator('+', new Konstanta(1), new Konstanta(2))
        );
    static Vyraz v3 = new Operator('/',
                new Operator('-', new Konstanta(3), new Konstanta(4)),
                new Operator('*', new Konstanta(1), new Konstanta(0))
        );
    static Vyraz v4 = new Operator('/',
                new Operator('-', new Konstanta(1), new Konstanta(1)),
                new Operator('-', new Konstanta(1), new Konstanta(1))
        );
    static Vyraz v34 = new Operator('*', v3, v4);
    static Vyraz v43 = new Operator('/', v4, v3);
    static Vyraz v3443 = new Operator('*', v34, v43);
    static Vyraz v34_43 = new Operator('/', v34, v43);
    static Vyraz v12 = new Operator('/', v1, v2);
    static Vyraz v23 = new Operator('*', v2, v3);
    static Vyraz v1223 = new Operator('*', v12, v23);

    static Vyraz[] vyrazy = {v0, v1, v2, v3, v4,
            v34, v43, v3443,v34_43, v12, v23, v1223
    };

    @Test
    public void to_String() {
        for(Vyraz v : vyrazy) {
            String dummy = v.toString();
        }
//        scoring.updateScore("lang:common_list_test_scoring_name",20);
        assertTrue(v0.toString().contains("3*4"));
        assertTrue(v1.toString().contains("4"));
        assertTrue(v2.toString().contains("1+2"));
        int[] lengths = {
        7,
        9,
        9,
        11,
        11,
        23,
        25,
        49,
        51,
        23,
        23,
        49};
        int index = 0;
        for(Vyraz v : vyrazy) {
            assertTrue("not optimized (easy) " + v.toString(), v.toString().length() < 1.7*lengths[index++]);
        }
//        scoring.updateScore("lang:common_list_test_scoring_name",10);
        index = 0;
        for(Vyraz v : vyrazy) {
            assertTrue("slightly optimized (medium) " + v.toString(), v.toString().length() < 1.2*lengths[index++]);
        }
//        scoring.updateScore("lang:common_list_test_scoring_name",10);
        index = 0;
        for(Vyraz v : vyrazy) {
            assertTrue("very cool (hard) " + v.toString(), v.toString().length() <= lengths[index++]);
        }
//        scoring.updateScore("lang:common_list_test_scoring_name",10);
    }

    @Test
    public void eval() {
        Integer[] results = {
                11
                ,0
                ,-4
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null
                ,0
                ,null
                ,null};
        int index = 0;
        for(Vyraz v : vyrazy) {
            assertEquals("eval " + v, results[index++], v.eval());
        }
//        scoring.updateScore("lang:common_list_test_scoring_name",40);
    }

    @Test
    public void lessEqual() {
        assertTrue("+ <= *", Vyraz.lessEqual('+','*'));
        assertFalse("* <= +", Vyraz.lessEqual('*','+'));
        assertTrue("+ <= +", Vyraz.lessEqual('+','+'));
        assertTrue("+ <= -", Vyraz.lessEqual('+','-'));
        assertTrue("* <= /", Vyraz.lessEqual('*','/'));
        assertFalse("* <= -", Vyraz.lessEqual('*','-'));
        assertFalse("/ <= -", Vyraz.lessEqual('/','-'));
        assertTrue("/ <= /", Vyraz.lessEqual('/','/'));
//        scoring.updateScore("lang:common_list_test_scoring_name",20);
    }
}