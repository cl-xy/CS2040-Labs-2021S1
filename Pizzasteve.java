import java.util.*;

public class Pizzasteve {
    ArrayList<City> cities;
    long[] grandpaDist;
    long[] pSteveDist;

    public class City {
        //public int id
        public ArrayList<Integer> nextCities;
        public ArrayList<Long> distances;

        /*public City(int nextCity, long distance) {
            this.nextCities.add(nextCity);
            this.distances.add(distance);
        }*/

        public City() {
            this.nextCities = new ArrayList<>();
            this.distances = new ArrayList<>();
        }

        public String toString() {
            String citiesStr = nextCities.toString();
            String distancesStr = distances.toString();
            String output = "cities: " + citiesStr;
            CharSequence newLine= "\n";
            output += newLine;
            output += "distances:" + distancesStr;
            return output;
        }
    }

    public class ChosenCity implements Comparable<ChosenCity> {
        long distFromSource;
        int id;

        public ChosenCity(int id, long distFromSource) {
            this.id = id;
            this.distFromSource = distFromSource;
        }

        public int compareTo(ChosenCity other) {
            if (distFromSource < other.distFromSource) {
                return -1;
            } else if (distFromSource > other.distFromSource) {
                return 1;
            }
            return 0;
        }
    }

    public long[] dijkstra(int startId, int n) {
        long[] dists = new long[n+1];

        for (int i = 0; i <= n; i++) {
            dists[i] = Long.MAX_VALUE;
        }

        dists[startId] = 0;

        PriorityQueue<ChosenCity> pq = new PriorityQueue<>();
        pq.offer(new ChosenCity(startId, 0));

        while (pq.size() > 0) {
            ChosenCity curr = pq.poll();
            int currId = curr.id;
            long dist = curr.distFromSource;
            ArrayList<Integer> nextCities = cities.get(currId).nextCities;
            ArrayList<Long> nextDist = cities.get(currId).distances;

            if (dists[currId] != dist) {
                continue;
            }

            for (int i = 0; i < nextCities.size(); i++) {
                int next = nextCities.get(i);
                long w = nextDist.get(i);
                
                if (dists[next] > dists[currId] + w) {
                    dists[next] = dists[currId] + w;
                    pq.offer(new ChosenCity(next, dists[next]));
                }
            }
        }
        return dists;
    }
        
    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int Grandpa = sc.nextInt();
        int PizzaSteve = sc.nextInt();

        cities = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            cities.add(new City());
        }
        
        grandpaDist = new long[n+1];
        pSteveDist = new long[n+1];

        for (int i = 0; i < m; i++) {
            int startCity = sc.nextInt();
            int nextCity = sc.nextInt();
            long distance = sc.nextLong();
            
            City curr = cities.get(startCity);
            curr.nextCities.add(nextCity);
            curr.distances.add(distance);
            cities.set(startCity,curr);
        }
        
        grandpaDist = dijkstra(Grandpa, n);
        pSteveDist = dijkstra(PizzaSteve, n);

        //store max of grandpaDist & pSteveDist
        long[] combined = new long[n+1];
        /*for (int i = 0; i <= n; i++) {
            System.out.println(cities.get(i));
        }*/
        
        long infinity = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (grandpaDist[i] == infinity || pSteveDist[i] == infinity) {
                combined[i] = infinity;
            } else if (grandpaDist[i] >= pSteveDist[i]) {
                combined[i] = grandpaDist[i];
            } else {
                combined[i] = pSteveDist[i];
            }
        }
      
        boolean canTravel = false;
        long minDist = infinity;

        for (int i = 1; i <= n; i++) {
            if (combined[i] != infinity) {
                canTravel = true;
                //break;
            }
            
            if (combined[i] < minDist) {
                minDist = combined[i];
            }
        }  
        //System.out.println(Arrays.toString(grandpaDist));
        //System.out.println(Arrays.toString(pSteveDist));
        //System.out.println(Arrays.toString(combined));

        if (canTravel) {
            System.out.println(minDist);
        } else {
            System.out.println("Sad");
        }
    }

    public static void main(String args[]) {
        Pizzasteve runner = new Pizzasteve();
        runner.run();
    }
}
