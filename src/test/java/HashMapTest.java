import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by m805958 on 5/12/15.
 */
public class HashMapTest {
    HashMap<Integer, String > hashMap = new HashMap<Integer, String>();

    @Before
    public void setUp() {
        hashMap.put(10000, "hi");
        hashMap.put(1, "bye");
        hashMap.put(null, "really?");
    }

    @Test
    public void putShouldAddToHashMap() {
        assertEquals(hashMap.size(), 3);
    }

    @Test
    public void getShouldReturnValueFromHashMap() {
        assertEquals(hashMap.get(10000), "hi");
    }

    @Test
    public void secondValueInNewKeyRepalcesFirstValue() {
        hashMap.put(0, "sup");
        assertTrue(hashMap.get(0).equals("sup"));
    }

    @Test
    public void clearRemovesAllContentFromAHashMap() {
        hashMap.clear();
        assertFalse(hashMap.size() > 0);
    }

    @Test
    public void keyInHashMapCanBeNull() {
        hashMap.put(null, "really?");
        assertTrue(hashMap.containsValue("really?"));
        assertTrue(hashMap.containsKey(null));
        System.out.println(hashMap.entrySet());
    }

    @Test (expected = IllegalArgumentException.class)
    public void negativeInitialCapacityTest() {
        new HashMap<Object, Object>(-1);
    }

}
