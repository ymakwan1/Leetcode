class Solution {
    public String reformatDate(String date) {
        Map<String, String> monthMap = new HashMap<>();
        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");

        String[] parts = date.split(" ");
        StringBuilder str = new StringBuilder();
        str.append(parts[2]).append("-").append(monthMap.get(parts[1]));
        String dates = parts[0].replaceAll("[a-zA-Z]", "");

        if(dates.length() == 1){
            dates = "0"+dates;
        }
        str.append("-").append(dates);
        return str.toString();
    }
}