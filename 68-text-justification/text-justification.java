import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i;
            int lineLength = 0;

            // Step 1: Find how many words fit in one line
            while (j < words.length && 
                  lineLength + words[j].length() + (j - i) <= maxWidth) {
                lineLength += words[j].length();
                j++;
            }

            int wordCount = j - i;
            int totalSpaces = maxWidth - lineLength;

            StringBuilder line = new StringBuilder();

            // Step 2: Last line OR single word
            if (j == words.length || wordCount == 1) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k != j - 1) line.append(" ");
                }

                // Fill remaining spaces
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } 
            else {
                // Step 3: Fully justified line
                int spacesPerGap = totalSpaces / (wordCount - 1);
                int extraSpaces = totalSpaces % (wordCount - 1);

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k != j - 1) {
                        // Add spaces
                        int spaces = spacesPerGap + (extraSpaces > 0 ? 1 : 0);
                        for (int s = 0; s < spaces; s++) {
                            line.append(" ");
                        }
                        if (extraSpaces > 0) extraSpaces--;
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}