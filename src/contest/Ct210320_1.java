package contest;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * https://leetcode-cn.com/contest/biweekly-contest-48/problems/design-authentication-manager/
 * @author HarryUp
 * @date 2021/3/20
 */
public class Ct210320_1 {
    int timeToLive;
    HashMap<String, Integer> map;

    public Ct210320_1(int timeToLive) {
        this.timeToLive = timeToLive;
        map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        if (map.containsKey(tokenId)) {
            int pre = map.get(tokenId);
            if (pre <= currentTime) {
                map.remove(tokenId);
            }
        }
        map.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if(map.containsKey(tokenId)) {
            int pre = map.get(tokenId);
            if (pre <= currentTime) {
                map.remove(tokenId);
            } else {
                map.put(tokenId, currentTime + timeToLive);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int cnt = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > currentTime) {
                cnt++;
            }
        }
        return cnt;
    }
}
