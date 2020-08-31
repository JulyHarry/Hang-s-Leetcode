import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KeysAndRoomsTest {

    @Test
    void canVisitAllRoomsDfsI() {
        List<Integer> li = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        li.add(1);
        list.add(li);
        li = new ArrayList<>();
        li.add(2);
        list.add(li);
        li = new ArrayList<>();
        li.add(3);
        list.add(li);
        li  = new ArrayList<>();
        list.add(li);

        KeysAndRooms kr = new KeysAndRooms();
        boolean canVisitAllRooms = kr.canVisitAllRoomsDfsI(list);
        Assert.assertEquals(canVisitAllRooms, true);

        li = new ArrayList<>();
        list = new ArrayList<>();
        li.add(1);
        li.add(3);
        list.add(li);
        li = new ArrayList<>();
        li.add(3);
        li.add(0);
        li.add(1);
        list.add(li);
        li = new ArrayList<>();
        li.add(2);
        list.add(li);
        li = new ArrayList<>();
        li.add(0);
        list.add(li);

        canVisitAllRooms = kr.canVisitAllRoomsDfsI(list);
        Assert.assertEquals(canVisitAllRooms, false);
    }

    @Test
    void canVisitAllRoomsDfsII() {
        List<Integer> li = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        li.add(1);
        list.add(li);
        li = new ArrayList<>();
        li.add(2);
        list.add(li);
        li = new ArrayList<>();
        li.add(3);
        list.add(li);
        li  = new ArrayList<>();
        list.add(li);

        KeysAndRooms kr = new KeysAndRooms();
        boolean canVisitAllRooms = kr.canVisitAllRoomsDfsII(list);
        Assert.assertEquals(canVisitAllRooms, true);

        li = new ArrayList<>();
        list = new ArrayList<>();
        li.add(1);
        li.add(3);
        list.add(li);
        li = new ArrayList<>();
        li.add(3);
        li.add(0);
        li.add(1);
        list.add(li);
        li = new ArrayList<>();
        li.add(2);
        list.add(li);
        li = new ArrayList<>();
        li.add(0);
        list.add(li);

        canVisitAllRooms = kr.canVisitAllRoomsDfsII(list);
        Assert.assertEquals(canVisitAllRooms, false);
    }

    @Test
    void canVisitAllRoomsBfs() {
        List<Integer> li = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        li.add(1);
        list.add(li);
        li = new ArrayList<>();
        li.add(2);
        list.add(li);
        li = new ArrayList<>();
        li.add(3);
        list.add(li);
        li  = new ArrayList<>();
        list.add(li);

        KeysAndRooms kr = new KeysAndRooms();
        boolean canVisitAllRooms = kr.canVisitAllRoomsBfs(list);
        Assert.assertEquals(canVisitAllRooms, true);

        li = new ArrayList<>();
        list = new ArrayList<>();
        li.add(1);
        li.add(3);
        list.add(li);
        li = new ArrayList<>();
        li.add(3);
        li.add(0);
        li.add(1);
        list.add(li);
        li = new ArrayList<>();
        li.add(2);
        list.add(li);
        li = new ArrayList<>();
        li.add(0);
        list.add(li);

        canVisitAllRooms = kr.canVisitAllRoomsBfs(list);
        Assert.assertEquals(canVisitAllRooms, false);
    }
}