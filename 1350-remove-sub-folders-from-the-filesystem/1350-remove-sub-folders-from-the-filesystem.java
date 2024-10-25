class Solution {
    public List<String> removeSubfolders(String[] folder) {
        //Sort
        Arrays.sort(folder);

        List<String> result = new ArrayList<>();

        //Add first folder
        result.add(folder[0]);

        //Iterate the array
        for(int i = 1; i < folder.length; i++){
            String lastFolder = result.get(result.size() - 1);
            //Check if the current folder is a subfolder of the last added folder
            if(!folder[i].startsWith(lastFolder + "/")){
                result.add(folder[i]);
            }
        }

        return result;
    }
}