package ro.ase.acs.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TrainTicket extends PublicTransportTicket{
    private TrainType trainType;

    static Set<TrainTicket> tickets = new HashSet<>();
    public TrainTicket(String departure, String destination, int distance, TrainType trainType) {
        super(departure, destination, distance);
        this.trainType = trainType;
    }

    static void issueTicket(TrainTicket x) {
        if(!tickets.contains(x)) {
            tickets.add(x);
        }
    }

    static Collection<TrainTicket> getTickets(){
        return tickets;
    }
    @Override
    public float getDiscount(){
        if(this.trainType.equals("REGIO")){
            return 0.5f;
        } else if(this.trainType.equals("INTERREGIO")) {
            return 0.25f;
        } else {
            return 0;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        TrainTicket copy = (TrainTicket) super.clone();
        copy.trainType=this.trainType;
        return copy;
    }

    public TrainType getTrainType() {
        return trainType;
    }
    public String getDeparture(){
        return super.departure;
    }
    public String getDestination() {
        return super.destination;
    }

    public int getDistance() {
        return super.distance;
    }

    @Override
    public float getPrice() {
        return super.getPrice()*distance*getDiscount();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("> ");
        sb.append(departure);
        sb.append(" ");
        sb.append(destination);
        sb.append(" ");
        sb.append(distance);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if(super.equals(o)) return false;
        TrainTicket that = (TrainTicket) o;
        return trainType == that.trainType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),trainType);
    }
}
