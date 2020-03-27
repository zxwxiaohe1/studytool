
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @author heyong
 * @date 2020/3/27
 */
public class AccountEncoding {

    private Map<String, String> enChar = new HashMap<>();

    private AccountEncoding() {
        enChar.put("0", "z");
        enChar.put("1", "a");
        enChar.put("2", "b");
        enChar.put("3", "c");
        enChar.put("4", "d");
        enChar.put("5", "e");
        enChar.put("6", "f");
        enChar.put("7", "g");
        enChar.put("8", "h");
        enChar.put("9", "i");
        enChar.put("a", "j");
        enChar.put("b", "k");
        enChar.put("c", "l");
        enChar.put("d", "m");
        enChar.put("e", "n");
        enChar.put("f", "o");
        enChar.put("g", "p");
        enChar.put("h", "q");
        enChar.put("i", "r");
        enChar.put("j", "s");
        enChar.put("k", "t");
        enChar.put("l", "u");
        enChar.put("m", "v");
        enChar.put("n", "w");
        enChar.put("o", "x");
        enChar.put("p", "y");
        enChar.put("q", "0");
        enChar.put("r", "1");
        enChar.put("s", "2");
        enChar.put("t", "3");
        enChar.put("u", "4");
        enChar.put("v", "5");
        enChar.put("w", "6");
        enChar.put("x", "7");
        enChar.put("y", "8");
        enChar.put("z", "9");
        enChar.put("A", "A");
        enChar.put("B", "B");
        enChar.put("C", "C");
        enChar.put("D", "D");
        enChar.put("E", "E");
        enChar.put("F", "F");
        enChar.put("G", "G");
        enChar.put("H", "H");
        enChar.put("I", "I");
        enChar.put("J", "J");
        enChar.put("K", "K");
        enChar.put("L", "L");
        enChar.put("M", "M");
        enChar.put("N", "N");
        enChar.put("O", "O");
        enChar.put("P", "P");
        enChar.put("Q", "Q");
        enChar.put("R", "R");
        enChar.put("S", "S");
        enChar.put("T", "T");
        enChar.put("U", "U");
        enChar.put("V", "V");
        enChar.put("W", "W");
        enChar.put("X", "X");
        enChar.put("Y", "Y");
        enChar.put("Z", "Z");
        enChar.put("_", ",");
        enChar.put("-", ".");
        enChar.put("@", ">");
        enChar.put("&", "<");
        enChar.put("$", "|");
        enChar.put("#", "=");
    }

    /**
     * Hex编码.
     */
    public String encodeHex(String input) {
        char[] chars = input.toCharArray();
        String output = "";
        for (char c : chars) {
            output += this.enChar.get(String.valueOf(c));
        }
        return output;
    }

    /**
     * Hex解码.
     */
    public String decodeHex(String input) {
        Map<String, String> xenChar = new HashMap<>();
        Iterator<String> it = this.enChar.keySet().iterator();
        while (it.hasNext()) {
            String traget = it.next();
            xenChar.put(enChar.get(traget), traget);
        }
        char[] chars = input.toCharArray();
        String output = "";
        for (char c : chars) {
            output += xenChar.get(String.valueOf(c));
        }
        return output;
    }

    private Boolean isBlank(String target) {
        if (target == null || target.trim() == "") {
            return true;
        }
        return false;
    }

    public String createPassword(String name, String phone, String idNum, String password) {
        if (isBlank(name) || isBlank(phone) || isBlank(idNum) || isBlank(password)) {
            System.out.println("the input parameter is null!");
        }
        List<String> contener = new ArrayList<>();
        contener.add(new StringBuffer(name.toLowerCase()).reverse().toString());
        contener.add(new StringBuffer(phone).reverse().toString());
        contener.add(new StringBuffer(idNum.toLowerCase()).reverse().toString());
        contener.add(password);
        Collections.sort(contener);
        String target = "";
        for (String str : contener) {
            target += str;
        }
        System.out.println("start target = " + target);
        String enCoded = encodeHex(target);
        System.out.println("encode target =" + enCoded);
        return enCoded;
    }

    public static void main(String[] args) throws Exception {

        System.out.println("param1:en/de,param2:name,param3:phone,param4:idNum,param5:password !");
        AccountEncoding ae = new AccountEncoding();
        if ("en".equals(args[0])) {
            String enCoded = ae.createPassword(args[1], args[2], args[3], args[4]);
            try {
                File file = new File("C:\\password.txt");
                FileWriter fileWritter = new FileWriter(file.getName(), true);
                fileWritter.write(enCoded);
                fileWritter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("decode target = " + ae.decodeHex(args[1]));
        }
    }
}
