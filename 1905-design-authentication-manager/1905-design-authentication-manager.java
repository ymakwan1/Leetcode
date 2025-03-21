class AuthenticationManager {
    private final HashMap<String, Integer> tokenMap;
    private final int timeToLive;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.tokenMap = new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        tokenMap.put(tokenId, currentTime + timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(tokenMap.containsKey(tokenId) && tokenMap.get(tokenId) > currentTime){
            tokenMap.put(tokenId, currentTime + timeToLive);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        tokenMap.values().removeIf(expTime -> expTime <= currentTime);
        return tokenMap.size();
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */