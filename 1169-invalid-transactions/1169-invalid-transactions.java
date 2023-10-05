import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> invalidTransactions = new ArrayList<>();
        
        for (int i = 0; i < transactions.length; i++) {
            String[] parts = transactions[i].split(",");
            String name = parts[0];
            int time = Integer.parseInt(parts[1]);
            int amount = Integer.parseInt(parts[2]);
            String city = parts[3];
            
            if (amount > 1000) {
                invalidTransactions.add(transactions[i]);
                continue;
            }
            
            boolean isInvalid = false;
            
            for (int j = 0; j < transactions.length; j++) {
                if (i != j) {
                    String[] otherParts = transactions[j].split(",");
                    String otherName = otherParts[0];
                    int otherTime = Integer.parseInt(otherParts[1]);
                    String otherCity = otherParts[3];
                    
                    if (name.equals(otherName) &&
                        Math.abs(time - otherTime) <= 60 &&
                        !city.equals(otherCity)) {
                        isInvalid = true;
                        break;
                    }
                }
            }
            
            if (isInvalid) {
                invalidTransactions.add(transactions[i]);
            }
        }
        
        return invalidTransactions;
    }
}
