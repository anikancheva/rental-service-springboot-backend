package web.projects.wheeler.service;

import org.springframework.stereotype.Service;
import web.projects.wheeler.db.entities.Listing;
import web.projects.wheeler.db.entities.Vehicle;
import web.projects.wheeler.db.entities.VehicleType;
import web.projects.wheeler.db.repositories.ListingRepository;
import web.projects.wheeler.db.repositories.VehicleRepository;
import web.projects.wheeler.models.CreateListingModel;
import web.projects.wheeler.models.ListingModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListingService {

    private final ListingRepository listingRepository;
    private final VehicleRepository vehicleRepository;

    public ListingService(ListingRepository listingRepository, VehicleRepository vehicleRepository) {
        this.listingRepository = listingRepository;
        this.vehicleRepository = vehicleRepository;
    }

    //    public Listing findById(Long id){
//        return listingRepository.findById(id).orElse(null);
//    }
    public List<ListingModel> findAll() {
        List<Listing> all = listingRepository.findAll();
       return mapToListingModel(all);
    }

    public List<ListingModel> findAllOfType(String type) {
        List<Listing> all =listingRepository.findAllByVehicleType(VehicleType.valueOf(type));
        return mapToListingModel(all);
    }

    public Listing create(CreateListingModel listingModel) {

        //TODO error handling
        Vehicle created = vehicleRepository.save(new Vehicle()
                .setType(VehicleType.valueOf(listingModel.getType()))
                .setBrand(listingModel.getBrand())
                .setModel(listingModel.getModel())
                .setYear(listingModel.getYear())
                .setSeats(listingModel.getSeats())
                .setDoors(listingModel.getDoors())
                .setPicUrl(listingModel.getPicUrl())
                .setOwner(listingModel.getOwner()));

        Listing listing = new Listing()
                .setVehicle(created)
                .setPrice(listingModel.getPrice())
                .setCreator(listingModel.getOwner());

        return listingRepository.save(listing);
    }

    private List<ListingModel> mapToListingModel(List<Listing> listings){
        List<ListingModel> listingModels = new ArrayList<>();
        listings.forEach(l -> listingModels.add(new ListingModel()
                .setUsername(l.getCreator().getUsername())
                .setPhoneNo(l.getCreator().getPhoneNo())
                .setPrice(l.getPrice())
                .setYear(l.getVehicle().getYear())
                .setBrand(l.getVehicle().getBrand())
                .setModel(l.getVehicle().getModel())
                .setSeats(l.getVehicle().getSeats())
                .setDoors(l.getVehicle().getDoors())
                .setImageUrl(l.getVehicle().getPicUrl())));

        return listingModels;
    }
}
