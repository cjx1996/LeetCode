package All_Problems;

import java.util.ArrayList;

/**
 * @author cjx
 * @create 2020-12-11-16:39
 * @description
 */
public class Dota2Senate_649 {
    public static void main(String[] args) {
        String senate = "RDD";
        System.out.println(predictPartyVictory(senate));
    }

    public static String predictPartyVictory(String senate) {
        String returnString = "";
        if (senate == "R") {
            returnString = "Radiant";
        }
        if (senate == "D") {
            returnString = "Dire";
        }

        char[] chars = senate.toCharArray();
        ArrayList<Integer> listD = new ArrayList<>();
        ArrayList<Integer> listR = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'R') {

                listR.add(i);
            }
            if (chars[i] == 'D') {

                listD.add(i);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (listR.get(0) == i) {
                listD.remove(0);
            }
            if (listD.get(0) == i) {
                listR.remove(0);
            }
        }
        int sizeR = listR.size();
        int sizeD = listD.size();
        while ((sizeD + sizeR) != 0) {
            if (sizeD != 0 && sizeR != 0) {
                if (listR.get(0) > listD.get(0)) {
                    returnString += chars[listD.remove(0)];
                    sizeD--;
                } else {
                    returnString += chars[listR.remove(0)];
                    sizeR--;
                }
            } else if (sizeD != 0) {
                for (Integer i : listD) {
                    returnString += chars[i];
                }
            } else if (sizeR != 0) {
                for (Integer i : listR) {
                    returnString += chars[i];
                }
            }
        }
        return null;
    }
}
