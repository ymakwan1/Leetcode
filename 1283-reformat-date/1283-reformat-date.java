class Solution {
    public String reformatDate(String date) {
        String[] parts = date.split(" ");
        StringBuilder str = new StringBuilder();
        String dates = handleDate(parts[0]);
        String month = handleMonth(parts[1]);
        str.append(parts[2]).append("-").append(month).append("-").append(dates);
        return str.toString();
    }

    public String handleDate(String dates){
        String result = dates.replaceAll("[a-zA-Z]", "");
        if(result.length() == 1){
            return "0"+result;
        }
        return result;
    }

    public String handleMonth(String month){
        Map<String, Integer> monthMap = new HashMap<>();
        monthMap.put("Jan", 1);
        monthMap.put("Feb", 2);
        monthMap.put("Mar", 3);
        monthMap.put("Apr", 4);
        monthMap.put("May", 5);
        monthMap.put("Jun", 6);
        monthMap.put("Jul", 7);
        monthMap.put("Aug", 8);
        monthMap.put("Sep", 9);
        monthMap.put("Oct", 10);
        monthMap.put("Nov", 11);
        monthMap.put("Dec", 12);
        
        if(String.valueOf(monthMap.get(month)).length() == 1){
            return "0"+String.valueOf(monthMap.get(month));
        }

        return String.valueOf(monthMap.get(month));
    }
}