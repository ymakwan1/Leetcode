import java.util.HashMap;

class UndergroundSystem {
    
    private HashMap<Integer, CheckInData> checkInMap;
    private HashMap<String, StationData> stationDataMap;
    
    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        stationDataMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInData(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInData checkInData = checkInMap.get(id);
        String route = checkInData.stationName + "->" + stationName;
        int travelTime = t - checkInData.time;
        
        if (!stationDataMap.containsKey(route)) {
            stationDataMap.put(route, new StationData(0, 0));
        }
        
        StationData stationData = stationDataMap.get(route);
        stationData.totalTime += travelTime;
        stationData.totalTrips++;
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        if (!stationDataMap.containsKey(route)) {
            return 0.0;
        }
        
        StationData stationData = stationDataMap.get(route);
        return (double) stationData.totalTime / stationData.totalTrips;
    }
    
    private static class CheckInData {
        String stationName;
        int time;
        
        public CheckInData(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }
    
    private static class StationData {
        int totalTime;
        int totalTrips;
        
        public StationData(int totalTime, int totalTrips) {
            this.totalTime = totalTime;
            this.totalTrips = totalTrips;
        }
    }
}
