import planes.ExperimentalPlane;
import models.ClassificationLevel;
import models.ExperimentalTypes;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void testGetPlanes(){
        Assert.assertFalse(new Airport(planes)
                .getPlanes()
                .isEmpty());
    }

    @Test
    public void testGetPassengerPlanes(){
        Assert.assertFalse(new Airport(planes)
                            .getPassengerPlanes()
                            .isEmpty());
    }

    @Test
    public void testGetMilitaryPlanes(){
        Assert.assertFalse(new Airport(planes)
                .getMilitaryPlanes()
                .isEmpty());
    }

    @Test
    public void testGetExperimentalPlanes(){
        Assert.assertFalse(new Airport(planes)
                .getExperimentalPlanes()
                .isEmpty());
    }

    @Test
    public void testGetTransportMilitaryPlanes() {
        Assert.assertTrue(
                new Airport(planes)
                        .getTransportMilitaryPlanes()
                        .stream()
                        .allMatch(plane -> plane.getType() == MilitaryType.TRANSPORT)
        );
    }

    @Test
    public void testGetBomberMilitaryPlanes() {
        Assert.assertTrue(
                new Airport(planes)
                        .getBomberMilitaryPlanes()
                        .stream()
                        .allMatch(plane -> plane.getType() == MilitaryType.BOMBER)
        );
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        Airport airport = new Airport(planes);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(planeWithMaxPassengerCapacity, expectedPlaneWithMaxPassengersCapacity);
    }

    @Test
    public void testSortByMaxCapacityAreAscending() {
        final AtomicInteger maxCapacity = new AtomicInteger(Integer.MIN_VALUE);
        Assert.assertTrue(
                new Airport(planes)
                        .sortByMaxLoadCapacity()
                        .getPlanes()
                        .stream()
                        .allMatch(plane -> plane.getMaxLoadCapacity() >= maxCapacity.getAndSet(plane.getMaxLoadCapacity()))
        );
    }

    @Test
    public void testSortByMaxSpeedAreAscending() {
        final AtomicInteger maxSpeed = new AtomicInteger(Integer.MIN_VALUE);
        Assert.assertTrue(
                new Airport(planes)
                        .sortByMaxSpeed()
                        .getPlanes()
                        .stream()
                        .allMatch(plane -> plane.getMaxSpeed() >= maxSpeed.getAndSet(plane.getMaxSpeed()))
        );
    }

    @Test
    public void testSortByMaxDistanceAreAscending() {
        final AtomicInteger maxDistance = new AtomicInteger(Integer.MIN_VALUE);
        Assert.assertTrue(
                new Airport(planes)
                        .sortByMaxDistance()
                        .getPlanes()
                        .stream()
                        .allMatch(plane -> plane.getMaxFlightDistance() >= maxDistance.getAndSet(plane.getMaxFlightDistance()))
        );
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        Assert.assertTrue(
                new Airport(planes)
                        .getBomberMilitaryPlanes()
                        .stream()
                        .anyMatch(plane -> plane.getType() == MilitaryType.BOMBER)
        );
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        Assert.assertFalse(
                new Airport(planes)
                        .getExperimentalPlanes()
                        .stream()
                        .anyMatch(plane -> plane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED));
    }
}
