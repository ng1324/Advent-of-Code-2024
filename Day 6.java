import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<String[]> mp = new ArrayList <String[]>();
        String line = bf.readLine();
        int posx = -1;
        int posy = -1;
        
        while (line != null) {
            String[] line_split = line.split("");
            if (posx == -1) {
                for (int i = 0; i < line_split.length; i++) {
                    if (line_split[i].equals("^")) {
                        posx = i;
                    }
                }
                posy += 1;
            }
            mp.add(line_split);
            line = bf.readLine();
        }
        
        System.out.println("Starting position: " + posx + "," + posy);
        
        int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        int this_dir = 0;
        int end = 0;
        int counter = 1;
        int thisx = posx, thisy = posy;
        
        while (end == 0) {
            int nextx = thisx + dir[this_dir][0];
            int nexty = thisy + dir[this_dir][1];
            if (nextx < 0 || nextx >= mp.get(0).length || nexty < 0 || nexty >= mp.size()) {
                end = 1;
                break;
            }
            if (mp.get(nexty)[nextx].equals("#")) {
                this_dir += 1;
                if (this_dir == 4) {
                    this_dir = 0;
                }
                continue;
            }
            if (!mp.get(thisy)[thisx].equals("X")) {
                mp.get(thisy)[thisx] = "X";
                counter += 1;
            }
            thisx = nextx;
            thisy = nexty;
        }
        
        System.out.println("Part 1: " + counter);
        
        int end2 = 0;
        while (end2 == 0) {
            int nextx = posx + dir[this_dir][0];
            int nexty = posy + dir[this_dir][1];
            if (nextx < 0 || nextx >= mp.get(0).length || nexty < 0 || nexty >= mp.size()) {
                end = 1;
                break;
            }
            if (mp.get(nexty)[nextx].equals("#")) {
                this_dir += 1;
                if (this_dir == 4) {
                    this_dir = 0;
                }
                continue;
            }
            if (!mp.get(posy)[posx].equals("X")) {
                mp.get(posy)[posx] = "X";
                counter += 1;
            }
            posx = nextx;
            posy = nexty;
        }
  }
}
