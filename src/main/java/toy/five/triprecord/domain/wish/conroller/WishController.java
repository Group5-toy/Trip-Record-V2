package toy.five.triprecord.domain.wish.conroller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import toy.five.triprecord.domain.wish.service.WishService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class WishController {

    private final WishService wishService;

    @PostMapping("wishes/{tripId}/{userId}")
    public void wishTrip(@PathVariable Long userId, @PathVariable Long tripId) {
        wishService.saveWish(userId, tripId);
    }

    @DeleteMapping("wishes/{tripId}/{userId}")
    public void unWishTrip(@PathVariable Long userId, @PathVariable Long tripId) {
        wishService.deleteWish(userId, tripId);
    }

}
