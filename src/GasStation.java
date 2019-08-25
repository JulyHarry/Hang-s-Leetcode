public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas = 0, totalcost = 0, start = 0;
        int len = Math.min(gas.length, cost.length);
        for (int i : gas) {
            totalcost += i;
        }
        for (int i : cost) {
            totalgas += i;
        }
        if (totalcost > totalgas) return -1;
        for (int i = 0; i < len; i++) {
            if (gas[i] < cost[i]) {
                continue;
            }else {

            }

        }
        return 0;
    }
}
