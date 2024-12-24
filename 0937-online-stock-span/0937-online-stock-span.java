class StockSpanner {
    List<Integer> stock;
    public StockSpanner() {
        stock = new ArrayList<>();
    }
    
    public int next(int price) {
        stock.add(price);
        int count = 1;
        for(int i = stock.size() - 2; i >=0; i--){
            if(stock.get(i) <= price){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */