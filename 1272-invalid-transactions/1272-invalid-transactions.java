class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> invalidTransactions = new ArrayList<>();
        int n = transactions.length;
        for(int i = 0; i < n; i++){
            String[] parts = transactions[i].split(",");
            String name1 = parts[0];
            int time1 = Integer.parseInt(parts[1]);
            int amout1 = Integer.parseInt(parts[2]);
            String city1 = parts[3];

            if(amout1 > 1000){
                invalidTransactions.add(transactions[i]);
                continue;
            }
            boolean isInvalid = false;
            for(int j = 0; j < n; j++){
                if(i!=j){
                    String[] otherParts = transactions[j].split(",");
                    String name2 = otherParts[0];
                    int time2 = Integer.parseInt(otherParts[1]);
                    int amout2 = Integer.parseInt(otherParts[2]);
                    String city2 = otherParts[3];

                    if(name1.equals(name2) && Math.abs(time2-time1) <= 60 && !(city1.equals(city2))){
                        isInvalid = true;
                        break;
                    }

                }
            }

            if(isInvalid){
                invalidTransactions.add(transactions[i]);
            }
        }
        return invalidTransactions;
    }
}