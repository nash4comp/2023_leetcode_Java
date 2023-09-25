package Graphs;

public class NOS {
    public static void main(String args[]) {
        char[][] map1 = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        char[][] map2 = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        char[][] map3 = {
            {'1','0','1','0','1'},
            {'0','1','0','1','0'},
            {'1','0','1','0','1'},
            {'0','1','0','1','0'}
        };
        System.out.println("Number of island: " + getNos(map1));
        System.out.println("Number of island: " + getNos(map2));
        System.out.println("Number of island: " + getNos(map3));


    }

    public static int getNos(char[][] map) {
        int count = 0;
        for(int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == '1') {
                    dfs(map, i, j);
                    count++;
                }
            }
        }
        return count;
    }


    public static void dfs(char[][] map, int i, int j) {
        if (i < 0 ||
            j < 0 ||
            i >= map.length ||
            j >= map[0].length ||
            map[i][j] == '0') {
                return;
            }
            map[i][j] = '0';

            dfs(map, i, j + 1);
            dfs(map, i + 1, j);
            dfs(map, i - 1, j);
            dfs(map, i, j - 1);

    }

}
