package re.netology;

import java.util.HashMap;

public class Game {
    private HashMap<String, Integer> map = new HashMap<>();

    public void register(Player player) {
        map.put(player.getName(), player.getStrength());
    }

    public int round(String playerName1, String playerName2) {
        int playerStrength1 = findPlayer(playerName1);
        int playerStrength2 = findPlayer(playerName2);

        if (playerStrength1 > playerStrength2) {
            return 1;
        } else if (playerStrength1 < playerStrength2) {
            return 2;
        }
        return 0;
    }

    private int findPlayer(String playerName) {
            if (!map.containsKey(playerName)) {
                throw new NotRegisteredException(playerName);
            }
            return map.get(playerName);
        }
    }
