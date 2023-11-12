package toy.five.triprecord.domain.wish.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.five.triprecord.domain.wish.entity.Wish;
import toy.five.triprecord.domain.wish.repository.WishRepository;
import toy.five.triprecord.domain.trip.entity.Trip;
import toy.five.triprecord.domain.trip.repository.TripRepository;
import toy.five.triprecord.domain.user.entity.User;
import toy.five.triprecord.domain.user.repository.UserRepository;
import toy.five.triprecord.global.exception.BaseException;

import static toy.five.triprecord.global.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
public class WishService {

    private final WishRepository wishRepository;
    private final UserRepository userRepository;
    private final TripRepository tripRepository;

    @Transactional
    public void saveWish(Long userId, Long tripId) {
        User findUser = findUserById(userId);
        Trip findTrip = findTripById(tripId);

        Wish wish = Wish.builder()
                .user(findUser)
                .trip(findTrip)
                .build();

        wishRepository.save(wish);
        findTrip.plusWishCount();
    }

    @Transactional
    public void deleteWish(Long userId, Long tripId) {
        wishRepository.findByUserAndTrip(
                findUserById(userId),
                findTripById(tripId)
        ).orElseThrow(() -> new BaseException(LIKE_NO_EXIST));
    }

    private User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new BaseException(USER_NO_EXIST));
    }

    private Trip findTripById(Long tripId) {
        return tripRepository.findById(tripId)
                .orElseThrow(() -> new BaseException(TRIP_NO_EXIST));
    }
}
