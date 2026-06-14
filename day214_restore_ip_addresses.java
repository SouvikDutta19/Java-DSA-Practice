import java.util.*;

public class day214_restore_ip_addresses {

    public static List<String> restoreIpAddresses(
            String s) {

        List<String> result =
                new ArrayList<>();

        backtrack(
                s,
                0,
                0,
                "",
                result
        );

        return result;
    }

    static void backtrack(String s,
                          int index,
                          int parts,
                          String current,
                          List<String> result) {

        if (parts == 4 &&
            index == s.length()) {

            result.add(
                    current.substring(
                            0,
                            current.length() - 1
                    )
            );
            return;
        }

        if (parts == 4)
            return;

        for (int len = 1;
             len <= 3 &&
             index + len <= s.length();
             len++) {

            String part =
                    s.substring(
                            index,
                            index + len
                    );

            if ((part.startsWith("0")
                    && part.length() > 1)
                    ||
                    Integer.parseInt(part)
                            > 255)
                continue;

            backtrack(
                    s,
                    index + len,
                    parts + 1,
                    current + part + ".",
                    result
            );
        }
    }
}