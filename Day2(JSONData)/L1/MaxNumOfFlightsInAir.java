package javaJSONHandling;

import java.util.*;

class Event {
    int time;
    boolean isDeparture;

    public Event(int time, boolean isDeparture) {
        this.time = time;
        this.isDeparture = isDeparture;
    }
}

public class MaxNumOfFlightsInAir {
    public static void main(String[] args) {
        String[] flights = {
                "1030-1230", "730-1000", "9300-1330", "700-1100", "1000-1300", "600-900", "830-1200", "1030-1530", "800-1400"};

        List<Event> events = new ArrayList<>();
        for (String flight : flights) {
            String[] times = flight.split("-");
            int departureTime = Integer.parseInt(times[0]);
            int arrivalTime = Integer.parseInt(times[1]);
            events.add(new Event(departureTime, true));
            events.add(new Event(arrivalTime, false));
        }

        events.sort((a, b) -> (a.time == b.time) ? Boolean.compare(a.isDeparture, b.isDeparture) : (a.time - b.time));
        int maxFlights = 0, currentFlights = 0;
        for (Event event : events) {
            if (event.isDeparture) {
                currentFlights++;
                maxFlights = Math.max(maxFlights, currentFlights);
            } else {
                currentFlights--;
            }
        }

        System.out.println("Maximum number of flights in the air at the same time: " + maxFlights);
    }

}
