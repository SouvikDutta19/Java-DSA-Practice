import java.util.*;

public class day201_text_justification {

    public static List<String> fullJustify(String[] words, int maxWidth){

        List<String> result = new ArrayList<>();
        int i = 0;

        while(i < words.length){

            int j = i, len = 0;

            while(j < words.length && len + words[j].length() + (j-i) <= maxWidth){
                len += words[j].length();
                j++;
            }

            int spaces = maxWidth - len;
            int gaps = j - i - 1;

            StringBuilder line = new StringBuilder();

            if(j == words.length || gaps == 0){

                for(int k=i;k<j;k++){
                    line.append(words[k]);
                    if(k < j-1) line.append(" ");
                }

                while(line.length() < maxWidth)
                    line.append(" ");
            }
            else{

                int space = spaces / gaps;
                int extra = spaces % gaps;

                for(int k=i;k<j;k++){
                    line.append(words[k]);

                    if(k < j-1){
                        for(int s=0;s<space;s++) line.append(" ");
                        if(extra-- > 0) line.append(" ");
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}