package Codility.Wayfair.Exercise;

import java.io.*;
import java.util.*;

public class LeaderBoard {

    private Map<Integer, Player> players;

    public LeaderBoard(Map<Integer, Player> players) {
        this.players = players;
    }

    public Double add_score(Integer player_id, Integer score) {
        Player player;
        if (players.containsKey(player_id)) {
            player = players.get(player_id);
        } else {
            player = new Player(new ArrayList<>());
            players.put(player_id, player);
        }
        return player.add_score(score);
    }

    public List<Integer> top(Integer max) {
        // create list of all
        List<Integer> all = getPlayersByOrder();
        // return sublist of max
        return all.subList(0, max);
    }

    private List<Integer> getPlayersByOrder() {
        List<Integer> ordered = new ArrayList<>(players.keySet());
        ordered.sort((o1, o2) -> {
            Player p1 = players.get(o1);
            Player p2 = players.get(o2);
            return (int) (p2.getAverage() - p1.getAverage());
        });
        return ordered;
    }

    public void reset(Integer player_id) {
        if (!players.containsKey(player_id)) {
            return;
        }
        Player player = players.get(player_id);
        player.reset();
    }


    public static void main(String[] args) {
        LeaderBoard leaderBoard = new LeaderBoard(new HashMap<>());
        leaderBoard.add_score(1, 50);
        System.out.println(leaderBoard.add_score(2, 80) == 80);
        System.out.println(leaderBoard.add_score(2, 70) == 75);
        System.out.println(leaderBoard.add_score(2, 60) == 70);
        System.out.println(leaderBoard.add_score(3, 90) == 90);
        System.out.println(leaderBoard.add_score(3, 85) == 87.5);


        System.out.println(leaderBoard.top(3).equals(Arrays.asList(3, 2, 1)));
        System.out.println(leaderBoard.top(2).equals(Arrays.asList(3, 2)));

        leaderBoard.reset(3);

        System.out.println(leaderBoard.top(3).equals(Arrays.asList(2, 1, 3)));
    }
}
