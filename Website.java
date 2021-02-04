import java.util.*;

public class Website {

    //store all unique countries
    HashSet<String> uniqueCountries = new HashSet<String>();
    
    //store the list of unique IPs for each country
    HashMap<String, HashSet<String>> uniqueIPs = new HashMap<>();

    //store total duration of accessing for each IP
    HashMap<String, Integer> IPMaxDuration = new HashMap<>();
    
    //store the max total duration from any IP for each country
    HashMap<String, Integer> countryMaxDuration = new HashMap<>();

    /*update the uniqueIPs hashmap
    pre-cond: only 1 way to spell each country
    eg. "japan" & not "Japan" so that the key value will be the same
    post-cond: uniqueIPs updated with the latest query.
    */
    public void updateUniqueIPs(String country, String IP) {
        if (uniqueIPs.containsKey(country)) {
            HashSet<String> existingHS = uniqueIPs.get(country);
            existingHS.add(IP);
            uniqueIPs.put(country, existingHS);
        } else {
            HashSet<String> hs = new HashSet<String>();
            hs.add(IP);
            uniqueIPs.put(country, hs);
        }
    }

    /* update the hashmap IPMaxDuration
    pre-cond: only 1 way to spell each country
    eg. "japan" & not "Japan" so that the key value will be the same
    post-cond: IPMaxDuration is updated with the latest query*/
    public void updateIPMaxDuration(String IP, int duration) {
        if (IPMaxDuration.containsKey(IP)) {
            int currentIPMax = IPMaxDuration.get(IP);
            IPMaxDuration.put(IP, currentIPMax + duration);
        } else {
            IPMaxDuration.put(IP, duration);
        }
    }

    /* update the hashmap countryMaxDuration
    pre-cond: only 1 way to spell each country
    eg. "japan" & not "Japan" so that the key value will be the same
    post-cond: the hashmap is updated with the 
    max duration for any IP for the specific country key*/
    public void updateCountryMaxDuration(String country, int duration, String IP) {
        if (countryMaxDuration.containsKey(country)) {
            int currentCountryMax = countryMaxDuration.get(country);
            countryMaxDuration.put(country, Math.max(currentCountryMax, IPMaxDuration.get(IP)));
            
        } else {
            countryMaxDuration.put(country, duration);
        }
    }

    /* perform updating whenever query one comes.
    pre-cond: methods called must be correctly defined.
    post-cond: all hashmaps get updated with the new input values */
    public void query1(String IP, String country, int duration) {
        uniqueCountries.add(country);
        updateUniqueIPs(country, IP);
        updateIPMaxDuration(IP, duration);
        updateCountryMaxDuration(country, duration, IP);        
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int numQueries = sc.nextInt();
        
        for (int i = 0; i < numQueries; i++) {
            int type = sc.nextInt();
            if (type == 1) { 
                query1(sc.next(), sc.next(), sc.nextInt());
            } else if (type == 2) {
                String country = sc.next();

                //checks if the hashmap 'countryMaxDuration' contains the country key
                if (countryMaxDuration.containsKey(country)) {
                System.out.println(countryMaxDuration.get(country));
                } else {
                    System.out.println(0);
                }
            } else if (type == 3) {
                System.out.println(uniqueCountries.size());
            } else {
                String inputCountry = sc.next();

                //checks if the hashmap 'uniqueIPs' contains the inputCountry key
                if (uniqueIPs.containsKey(inputCountry)) {
                    System.out.println(uniqueIPs.get(inputCountry).size());
                } else {
                    System.out.println(0);
                }    
            }
        }
    }

    public static void main(String args[]) {
        Website runner = new Website();
        runner.run();
    }
}
