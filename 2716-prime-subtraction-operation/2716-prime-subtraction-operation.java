class Solution {
    private List<Integer> primes = generatePrimes(1000);

    public boolean primeSubOperation(int[] nums) {
        int prevValue = 0;
        for(int currValue : nums){
            if(currValue <= prevValue){
                return false;
            }

            int target = currValue - prevValue;
            int primeIndex = binarySearchLargestPrime(target);

            if(primeIndex != -1){
                currValue -= primes.get(primeIndex);
            }

            prevValue = currValue;
        }

        return true;
    }

    private List<Integer> generatePrimes(int max){
        boolean[] isPrime = new boolean[max + 1];
        for(int i = 2; i <= max; i++){
            isPrime[i] = true;
        }

        for(int i = 2; i * i <= max; i++){
            if(isPrime[i]){
                for(int j = i * i; j <= max; j += i){
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= max; i++){
            if(isPrime[i]){
                primes.add(i);
            }
        }

        return primes;
    }

    private int binarySearchLargestPrime(int target){
        int left = 0;
        int right = primes.size() - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(primes.get(mid) >= target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return right;
    }
}