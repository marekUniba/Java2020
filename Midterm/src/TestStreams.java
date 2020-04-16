import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class TestStreams {
    @BeforeClass
    public static void initScoring() {
    }

    @Test
    public void testStriedavo() {
        List<List<Integer>>res = List.of(
                List.of(0),
                List.of(0,-1,1),
                List.of(0,-1,1,-2,2),
                List.of(0,-1,1,-2,2,-3,3),
                List.of(0,-1,1,-2,2,-3,3,-4,4),
                List.of(0,-1,1,-2,2,-3,3,-4,4,-5,5),
                List.of(0,-1,1,-2,2,-3,3,-4,4,-5,5,-6,6),
                List.of(0,-1,1,-2,2,-3,3,-4,4,-5,5,-6,6,-7,7),
                List.of(0,-1,1,-2,2,-3,3,-4,4,-5,5,-6,6,-7,7,-8,8),
                List.of(0,-1,1,-2,2,-3,3,-4,4,-5,5,-6,6,-7,7,-8,8,-9,9)
        );
        for(int i = 1; i < 10; i++)
            assertArrayEquals("striedavo " + i, res.get(i).toArray(new Integer[0]),
                    Streams.striedavo(i).boxed().collect(Collectors.toList()).toArray(new Integer[0]));
    }

    @Test
    public void testprvocisla() {
        List<List<Integer>>res = List.of(
                List.of(),
                List.of(3, 5, 7, 11, 13, 17, 19),
                List.of(3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37),
                List.of(3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59),
                List.of(3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79),
                List.of(3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97),
                List.of(3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113),
                List.of(3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139),
                List.of(3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157),
                List.of(3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179)
        );
        for(int i = 0; i < 10; i++) {
            IntStream is = IntStream.range(1, 10*i).map(e->2*e+1);
            assertArrayEquals("prvocisla " + i, res.get(i).toArray(new Integer[0]),
                    Streams.prvocisla(is).boxed().collect(Collectors.toList()).toArray(new Integer[0]));
        }
    }

    @Test
    public void testnajvyssiaCifra() {
        List<Long>res = List.of(0L,2L, 2L, 2L, 2L, 2L, 4L, 14L, 22L, 22L);
        for(int i = 0; i < 10; i++) {
            List<Integer> ls = IntStream.range(1, 10*i).map(e->5*e+13).boxed().collect(Collectors.toList());
            //System.out.println(Streams.najvyssiaCifra(ls));
            assertEquals("najvyssiaCifra " + i, res.get(i), Streams.najvyssiaCifra(ls).get(3));
        }
    }

    @Test
    public void testdelitele() {
        List<List<Integer>>res = List.of(
                List.of(),
                List.of(),
                List.of(1, 3),
                List.of(1, 5),
                List.of(1, 7),
                List.of(1, 3, 9),
                List.of(1, 11),
                List.of(1, 13),
                List.of(1, 3, 5, 15),
                List.of(1, 17)
        );
        for(int i = 2; i < 10; i++) {
            IntStream is = IntStream.range(1, 10*i).map(e->2*e+1);
            assertArrayEquals("delitele " + i, res.get(i).toArray(new Integer[0]),
                    Streams.delitele(is).get(2*i-1).toArray(new Integer[0]));
        }
    }
}