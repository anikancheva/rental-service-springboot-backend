package web.projects.wheeler.web;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import web.projects.wheeler.db.entities.UserModel;
import web.projects.wheeler.models.CreateListingModel;
import web.projects.wheeler.models.ListingDetailsModel;
import web.projects.wheeler.models.ListingModel;
import web.projects.wheeler.service.ListingService;
import web.projects.wheeler.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/listings")
@CrossOrigin(origins = "http://localhost:3000/", exposedHeaders = {"Authorization"})
public class ListingController {

    private final ListingService listingService;
    private final UserService userService;

    public ListingController(ListingService listingService, UserService userService) {
        this.listingService = listingService;
        this.userService = userService;
    }

    @GetMapping("/")
    private ResponseEntity<List<ListingModel>> fetchAllListings() {
        return ResponseEntity.ok(listingService.findAll());
    }

    @GetMapping("/{type}")
    public ResponseEntity<List<ListingModel>> fetchAllOfType(@PathVariable String type) {
        return ResponseEntity.ok(listingService.findAllOfType(type.toUpperCase()));
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<ListingDetailsModel> fetchOne(@PathVariable Long id) {
        return ResponseEntity.ok(listingService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ListingDetailsModel> create(@RequestBody CreateListingModel listingModel) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserModel user = userService.getUserByUsername(username);
        listingModel.setOwner(user);

        ListingDetailsModel created = listingService.create(listingModel);
        if (null != created) {
            return ResponseEntity.status(201).body(created);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }
}
