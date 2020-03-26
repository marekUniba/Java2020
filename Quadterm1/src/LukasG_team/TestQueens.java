package LukasG_team;

import LISTTestScoring.LISTTestScoring;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

public class TestQueens {
    private static LISTTestScoring scoring = null;

    @BeforeClass
    public static void initScoring() {
        scoring = new LISTTestScoring();
        scoring.setScore("lang:common_list_test_scoring_name", 0, 100);
    }

    static Queens q4 = new Queens(new int[]{2, 0, 3, 1});
    static Queens q6 = new Queens(new int[]{1, 3, 5, 0, 2, 4});
    static Queens q8 = new Queens(new int[]{3,7,0,4,6,1,5,2});
    static Queens[] queens = new Queens[]{ q4, q6, q8};

    @org.junit.Test
    public void testConstructor() {
        int[] perm = new int[]{0,1,2,3,4};
        Queens q1 = new Queens(perm);
        perm[0]=1; perm[1] = 0;
        Queens q2 = new Queens(perm);
        assertNotEquals("konstruktor si nevytvori kopiu pola",q1.toString(), q2.toString());
        scoring.updateScore("lang:common_list_test_scoring_name",20);
    }

    @org.junit.Test
    public void testToString() {
        int[] perm = new int[]{0,1,2,3,4,5,6,7,8,9};
        Queens q = new Queens(perm);
        for(int e : perm) {
            if (!q.toString().contains(""+e))
                fail("toString nevypisuje vsetky prvky riesenia");
        }
        scoring.updateScore("lang:common_list_test_scoring_name",10);
    }

    @org.junit.Test
    public void compareTo() {
        @SuppressWarnings("unused")
        Comparable<Queens> q = new Queens(new int[]{0,1,2,3,4});
        assertEquals("compareTo", 0,
                new Queens(new int[]{0,1,2,3,4}).compareTo(new Queens(new int[]{0,1,2,3,4})));
        assertEquals("compareTo", -1,
                new Queens(new int[]{0,1,2,3,4}).compareTo(new Queens(new int[]{0,2,1,3,4})));
        assertEquals("compareTo", -1,
                new Queens(new int[]{0,1,2,3,4}).compareTo(new Queens(new int[]{0,1,2,4,3})));
        assertEquals("compareTo", 1,
                new Queens(new int[]{0,4,2,3,1}).compareTo(new Queens(new int[]{0,1,2,3,4})));
        assertEquals("compareTo", 1,
                new Queens(new int[]{0,1,2,4,3}).compareTo(new Queens(new int[]{0,1,2,3,4})));
        scoring.updateScore("lang:common_list_test_scoring_name",20);
    }

    @org.junit.Test
    public void clockwise90() {
        for(Queens q : queens) {
            assertEquals("4xclockwise90", 0,
                    q.compareTo(q.clockwise90().clockwise90().clockwise90().clockwise90()));

        }
        assertEquals("clockwise90", 0, q4.compareTo(q4.clockwise90()));

        assertNotEquals("clockwise90", 0, q6.compareTo(q6.clockwise90()));
        assertEquals("2xclockwise90", 0, q6.compareTo(q6.clockwise90().clockwise90()));

        assertNotEquals("clockwise90", 0, q8.compareTo(q8.clockwise90()));
        assertNotEquals("2xclockwise90", 0, q8.compareTo(q8.clockwise90().clockwise90()));
        assertNotEquals("3xclockwise90", 0, q8.compareTo(q8.clockwise90().clockwise90().clockwise90()));
        scoring.updateScore("lang:common_list_test_scoring_name",20);
    }

    @org.junit.Test
    public void horizontalFlip() {
        for(Queens q : queens) {
            assertEquals("horizontalFlip", 0,
                    q.compareTo(q.horizontalFlip().horizontalFlip()));
        }
        assertNotEquals("horizontalFlip", 0, q4.compareTo(q4.horizontalFlip()));

        assertNotEquals("horizontalFlip", 0, q6.compareTo(q6.horizontalFlip()));

        assertNotEquals("horizontalFlip", 0, q8.compareTo(q8.horizontalFlip()));
        scoring.updateScore("lang:common_list_test_scoring_name",20);
    }

    @org.junit.Test
    public void veritcalFlip() {
        for(Queens q : queens) {
            assertEquals("veritcalFlip", 0,
                    q.compareTo(q.verticalFlip().verticalFlip()));
        }
        assertNotEquals("verticalFlip", 0, q4.compareTo(q4.verticalFlip()));

        assertNotEquals("verticalFlip", 0, q6.compareTo(q6.verticalFlip()));

        assertNotEquals("verticalFlip", 0, q8.compareTo(q8.verticalFlip()));
        scoring.updateScore("lang:common_list_test_scoring_name",10);
    }
}