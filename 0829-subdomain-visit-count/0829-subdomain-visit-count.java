class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>();

        for(String cp : cpdomains){
            String[] parts = cp.split(" ");
            int visit = Integer.parseInt(parts[0]);
            String domain = parts[1];

            String cur = domain;
            while(true){
                counts.put(cur, counts.getOrDefault(cur, 0)+visit);
                int dotIndex = cur.indexOf('.');
                if(dotIndex == -1)
                    break;
                cur = cur.substring(dotIndex+1);
            }
        }

        List<String> result = new ArrayList<>(counts.size());
        for(Map.Entry<String, Integer> entry : counts.entrySet()){
            result.add(entry.getValue()+" "+ entry.getKey());
        }
        return result;

        
    }
}