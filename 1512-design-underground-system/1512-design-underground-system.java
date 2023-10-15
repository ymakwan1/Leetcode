class UndergroundSystem {
    HashMap<Integer, CheckInData> checkInMap;
    HashMap<String, StationData> stationDataMap;

    public static class CheckInData{
        int id;
        String stationName;
        int t;
        public CheckInData(int idIn, String stationNameIn, int tIn){
            id = idIn;
            stationName = stationNameIn;
            t = tIn;
        }
    }

    public static class StationData{
        int totalTime;
        int totalTrips;
        
        public StationData(int totalTimeIn, int totalTripsIn) {
            totalTime = totalTimeIn;
            totalTrips = totalTripsIn;
        }
    }
    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        stationDataMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInData(id, stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInData checkIn = checkInMap.get(id);
        String route = checkIn.stationName + "->" + stationName;
        int travelTime = t - checkIn.t;

        if(!stationDataMap.containsKey(route)){
            stationDataMap.put(route, new StationData(0, 0));
        }

        StationData stationData = stationDataMap.get(route);
        stationData.totalTime += travelTime;
        stationData.totalTrips++;

    }
    
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        if(!stationDataMap.containsKey(route)){
            return 0.0;
        }

        StationData stationData = stationDataMap.get(route);

        return (double) stationData.totalTime / stationData.totalTrips;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */