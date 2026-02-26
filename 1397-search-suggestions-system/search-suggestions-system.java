import java.util.*;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        Arrays.sort(products);   // Step 1: Sort products
        
        List<List<String>> result = new ArrayList<>();
        String prefix = "";
        
        for (char ch : searchWord.toCharArray()) {
            prefix += ch;    // Build prefix
            List<String> suggestions = new ArrayList<>();
            
            for (String product : products) {
                if (product.startsWith(prefix)) {
                    suggestions.add(product);
                }
                
                if (suggestions.size() == 3) {
                    break;   // Only 3 suggestions needed
                }
            }
            
            result.add(suggestions);
        }
        
        return result;
    }
}