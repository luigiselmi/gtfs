package it.datiaperti.gtfs;

import it.datiaperti.gtfs.pb.GtfsRealtime.FeedEntity;
import it.datiaperti.gtfs.pb.GtfsRealtime.FeedMessage;

import java.io.IOException;
import java.net.URL;


public class Main {
  
  public static final String ROME_RTGTFS_VEHICLE_POSITIONS_FEED = "https://romamobilita.it/sites/default/files/rome_rtgtfs_vehicle_positions_feed.pb"; 

  public static void main(String[] args) throws IOException {

    URL url = new URL(ROME_RTGTFS_VEHICLE_POSITIONS_FEED);
    FeedMessage feed = FeedMessage.parseFrom(url.openStream());
    for (FeedEntity entity : feed.getEntityList()) {
      System.out.println(entity.getVehicleOrBuilder().toString());
 
    }

  }

}
