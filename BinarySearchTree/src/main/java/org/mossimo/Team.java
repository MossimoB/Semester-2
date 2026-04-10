package org.mossimo;

import java.util.ArrayList;
import java.util.List;

/*
 * <T> is a generic type parameter. It lets the Team class work with any type
 * (for example: Player, Coach, String, etc.) while still keeping type safety.
 *
 * Instead of hardcoding a specific class, <T> acts as a placeholder that gets
 * replaced with a real type when the class is used.
 *
 * Example:
 *   Team<Player> team = new Team<>();
 *   -> Here, T becomes Player, so playerList stores Player objects only.
 *
 * Benefits:
 * - Reusability: the same Team class works with different types.
 * - Type safety: only objects of type T can be added (no casting needed).
 * - Compile-time checks: errors are caught early if wrong types are used.
 *
 * Note:
 * In this code, playerList is declared as List<T>, but the constructor takes
 * List<Player>. Ideally, it should also use List<T> to stay consistent:
 *
 *   public Team(List<T> playerList) { ... }
 */

// Class-level generics

public class Team<T extends Player> { // team of T can only be a TYPE of player
                                      // basketball, football, hockey, etc
    protected List<T> playerList;

    public Team() {
        this.playerList = new ArrayList<>();
    }

    public void add(T player) {
        playerList.add(player);
    }
}
