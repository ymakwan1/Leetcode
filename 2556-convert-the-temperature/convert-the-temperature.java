
class Solution {
    public double[] convertTemperature(double celsius) {
        List<Double> list = new ArrayList<>();
        list.add(celsius+273.15);
        list.add(celsius*1.80+32.00);
        double[] doubleArray = list.stream().mapToDouble(Double::doubleValue).toArray();

        return doubleArray;
    }
}