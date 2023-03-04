package web.projects.wheeler.service;

import org.springframework.stereotype.Service;
import web.projects.wheeler.db.entities.*;
import web.projects.wheeler.db.repositories.ListingRepository;
import web.projects.wheeler.db.repositories.ReviewRepository;
import web.projects.wheeler.db.repositories.VehicleRepository;
import web.projects.wheeler.models.CreateListingModel;
import web.projects.wheeler.models.ListingDetailsModel;
import web.projects.wheeler.models.ListingModel;
import web.projects.wheeler.models.ReviewModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListingService {

    private final ListingRepository listingRepository;
    private final VehicleRepository vehicleRepository;
    private final ReviewRepository reviewRepo;

    public ListingService(ListingRepository listingRepository, VehicleRepository vehicleRepository, ReviewRepository reviewRepo) {
        this.listingRepository = listingRepository;
        this.vehicleRepository = vehicleRepository;
        this.reviewRepo = reviewRepo;
    }

    public ListingDetailsModel findById(Long id) {
        Listing listing = listingRepository.findById(id).orElse(null);
        assert listing != null;
        return mapToListingDetailsModel(listing);
    }

    public List<ListingModel> findAll() {
        List<Listing> all = listingRepository.findAll();
        return mapToListingModel(all);
    }

    public List<ListingModel> findAllOfType(String type) {
        List<Listing> all;
        if (type.equals(Category.EXOTIC.name())) {
            all = listingRepository.findAllByVehicleCategory(Category.valueOf(type));
        } else {
            all = listingRepository.findAllByVehicleType(VehicleType.valueOf(type));
        }
        return mapToListingModel(all);
    }

    public ListingDetailsModel create(CreateListingModel listingModel) {

        Vehicle toAdd = new Vehicle()
                .setType(VehicleType.valueOf(listingModel.getType()))
                .setBrand(listingModel.getBrand())
                .setModel(listingModel.getModel())
                .setYear(listingModel.getYear())
                .setSeats(listingModel.getSeats())
                .setDoors(listingModel.getDoors())
                .setPicUrl(listingModel.getPicUrl())
                .setOwner(listingModel.getOwner());
        Category category = switch (listingModel.getType()) {
            case "CAR", "TRUCK", "VAN", "MOTORCYCLE", "BIKE", "RV" -> Category.REGULAR;
            case "BOAT", "TRACTOR", "HELICOPTER", "COMBINE", "LAWNMOWER" -> Category.EXOTIC;
            default -> null;
        };
        toAdd.setCategory(category);

        try {
            Vehicle created = vehicleRepository.save(toAdd);
            Listing listing = listingRepository.save(new Listing()
                    .setVehicle(created)
                    .setPrice(listingModel.getPrice())
                    .setCreator(listingModel.getOwner()));

            return mapToListingDetailsModel(listing);
        } catch (RuntimeException e) {
            return null;
        }


    }

    private List<ListingModel> mapToListingModel(List<Listing> listings) {
        List<ListingModel> listingModels = new ArrayList<>();
        listings.forEach(l -> listingModels.add(new ListingModel()
                .setId(l.getId())
                .setPrice(l.getPrice())
                .setYear(l.getVehicle().getYear())
                .setBrand(l.getVehicle().getBrand())
                .setModel(l.getVehicle().getModel())
                .setImageUrl(l.getVehicle().getPicUrl())));

        return listingModels;
    }

    private ListingDetailsModel mapToListingDetailsModel(Listing listing) {
        List<Review> reviews = reviewRepo.getReviewsByListingId(listing.getId());

        List<ReviewModel> reviewModels = reviews.stream().map(r -> new ReviewModel()
                        .setId(r.getId())
                        .setListingId(r.getListing().getId())
                        .setAuthor(r.getAuthor().getUsername())
                        .setContent(r.getContent())
                        .setLikes(r.getLikes())
                        .setDislikes(r.getDislikes()))
                .toList();
        return new ListingDetailsModel()
                .setId(listing.getId())
                .setUsername(listing.getCreator().getUsername())
                .setPhoneNo(listing.getCreator().getPhoneNo())
                .setBrand(listing.getVehicle().getBrand())
                .setModel(listing.getVehicle().getModel())
                .setYear(listing.getVehicle().getYear())
                .setSeats(listing.getVehicle().getSeats())
                .setDoors(listing.getVehicle().getDoors())
                .setImageUrl(listing.getVehicle().getPicUrl())
                .setPrice(listing.getPrice())
                .setReviews(reviewModels);
    }
}
