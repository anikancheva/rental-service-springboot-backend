package web.projects.wheeler.web;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import web.projects.wheeler.db.entities.Listing;
import web.projects.wheeler.db.entities.UserModel;
import web.projects.wheeler.models.CreateListingModel;
import web.projects.wheeler.service.ListingService;
import web.projects.wheeler.service.UserService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/listings")
@CrossOrigin
public class ListingController {

    private final ListingService listingService;
    private final UserService userService;

    public ListingController(ListingService listingService, UserService userService) {
        this.listingService = listingService;
        this.userService = userService;
    }

    @GetMapping()
    private ResponseEntity<List<Listing>> fetchAllListings() {
        return ResponseEntity.ok(listingService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Listing> fetchListingById(@PathVariable Long id) {
        return ResponseEntity.ok(listingService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<Listing> create(@RequestBody CreateListingModel listingModel) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserModel user = userService.getUserByUsername(username);
        listingModel.setOwner(user);

        Listing created = null;
        try {
            created = listingService.create(listingModel);
            return ResponseEntity.created(URI.create(String.format("/listings/%d", created.getId()))).body(created);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(created);
        }

    }
}
