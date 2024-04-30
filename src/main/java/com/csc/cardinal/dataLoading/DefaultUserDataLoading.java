package com.csc.cardinal.dataLoading;

import com.csc.cardinal.park.ParkEntity;
import com.csc.cardinal.park.ParkRepository;
import com.csc.cardinal.user.UserEntity;
import com.csc.cardinal.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/***
 * @Author Jacob
 */
@Component
public class DefaultUserDataLoading implements CommandLineRunner {

    private static UserRepository userRepository;
    @Autowired
    public DefaultUserDataLoading(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private static ParkRepository parkRepository;
    @Autowired
    public void setParkRepository(final ParkRepository parkRepository) {
        this.parkRepository = parkRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Insert default values into the database
        createUser("jacob", "email@email.com", "password", "Jacob", "Greene");
        createUser("andrew", "email@email.com", "password", "Andrew", "Nice");
        createUser("christian", "email@email.com", "password", "Christian", "Wilson");

        createPark("Oak Hollow Park", "Oak Hollow Park is a spacious park featuring a lake, picnic areas, trails, and sports fields.", 4.5, 120, "1841 Eastchester Dr", "Guilford", "City of High Point Parks and Recreation");
        createPark("Tanglewood Park", "Tanglewood Park is a large recreational area with gardens, trails, golf courses, and a campground.", 4.7, 200, "4061 Clemmons Rd", "Forsyth", "Forsyth County Parks and Recreation");
        createPark("Hagan Stone Park", "Hagan Stone Park offers hiking trails, fishing lakes, picnic areas, and camping facilities in a serene natural setting.", 4.3, 90, "5920 Hagan Stone Park Rd", "Guilford", "Guilford County Parks and Recreation");
        createPark("Salem Lake Park", "Salem Lake Park features a picturesque lake with boating and fishing opportunities, as well as walking and biking trails.", 4.6, 150, "1001 Salem Lake Rd", "Forsyth", "City of Winston-Salem Parks and Recreation");
        createPark("Bur-Mil Park", "Bur-Mil Park offers a variety of outdoor activities including golf, hiking, fishing, and playgrounds.", 4.4, 110, "5834 Bur-Mil Club Rd", "Guilford", "Guilford County Parks and Recreation");
        createPark("Holly Ridge Golf Links", "Holly Ridge Golf Links is a scenic golf course with challenging holes and beautiful views of the surrounding countryside.", 4.8, 180, "7933 US-311", "Guilford", "Holly Ridge Golf Links");
        createPark("Belews Lake", "Belews Lake is a popular spot for boating, fishing, and picnicking, offering beautiful views and recreational opportunities.", 4.5, 130, "Belews Lake", "Forsyth", "Forsyth County Parks and Recreation");
        createPark("Kernersville Lake Park", "Kernersville Lake Park features walking trails, a playground, and a disc golf course, making it a great destination for outdoor recreation.", 4.3, 95, "201 W Mountain St", "Forsyth", "Town of Kernersville Parks and Recreation");
        createPark("City Lake Park", "City Lake Park offers fishing, boating, and picnicking facilities along with walking trails and playgrounds for families to enjoy.", 4.6, 140, "602 W Main St", "Guilford", "City of Jamestown Parks and Recreation");
        createPark("Shaffner Park", "Shaffner Park is a neighborhood park with playgrounds, sports fields, and picnic areas, providing opportunities for outdoor fun for all ages.", 4.2, 85, "2001 Pittsboro St", "Forsyth", "City of Winston-Salem Parks and Recreation");
        createPark("Bryan Park", "Bryan Park offers a variety of recreational activities including golf, tennis, hiking, and picnicking, set amidst scenic natural surroundings.", 4.7, 175, "6275 Bryan Park Rd", "Guilford", "City of Greensboro Parks and Recreation");
        createPark("Triad Park", "Triad Park is a large regional park with walking trails, playgrounds, sports fields, and a dog park, providing ample space for outdoor activities.", 4.5, 125, "9652 W Market St", "Forsyth", "Forsyth County Parks and Recreation");
        createPark("Country Park", "Country Park features walking trails, picnic areas, and a lake, offering a peaceful escape in the heart of the city.", 4.4, 105, "3905 Nathanael Greene Dr", "Guilford", "City of Greensboro Parks and Recreation");
        createPark("Bethabara Park", "Bethabara Park is a historic site with walking trails, gardens, and restored colonial buildings, providing a glimpse into North Carolina's past.", 4.6, 145, "2147 Bethabara Rd", "Forsyth", "City of Winston-Salem Parks and Recreation");
        createPark("Burke Park", "Burke Park is a neighborhood park with playgrounds, sports fields, and walking trails, offering recreational opportunities for local residents.", 4.3, 100, "601 Griffith Rd", "Guilford", "City of Greensboro Parks and Recreation");
        createPark("Salem Creek Greenway", "Salem Creek Greenway is a scenic trail along Salem Creek, perfect for walking, running, and biking, with beautiful views of nature and wildlife.", 4.5, 135, "Salem Creek Greenway", "Forsyth", "City of Winston-Salem Parks and Recreation");
        createPark("Horsepen Creek Park", "Horsepen Creek Park offers walking trails, a playground, and open green space, providing a peaceful environment for outdoor recreation.", 4.2, 90, "3900 Horse Pen Creek Rd", "Guilford", "City of Greensboro Parks and Recreation");
        createPark("Ivey M Redmon Sports Complex", "Ivey M Redmon Sports Complex features sports fields, walking trails, and playgrounds, making it a popular destination for outdoor activities and events.", 4.7, 170, "788 Beeson Rd", "Guilford", "City of Kernersville Parks and Recreation");
        createPark("Washington Park", "Washington Park is a community park with sports fields, playgrounds, and picnic areas, providing opportunities for outdoor recreation and family fun.", 4.4, 110, "269 W Acadia Ave", "Forsyth", "City of Winston-Salem Parks and Recreation");
        createPark("Oak Ridge Town Park", "Oak Ridge Town Park offers walking trails, sports fields, and playgrounds, providing recreational opportunities for residents of all ages.", 4.6, 150, "6231 Lisa Dr", "Guilford", "Town of Oak Ridge Parks and Recreation");

    }

    public void createUser(String username, String email, String password,
                           String firstName, String lastName) {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userRepository.save(user);
    }

    public static void createPark( String name, String desc,
                                   Double ratingTotal, int ratingCount, String address,
                                   String county, String operator) {
        ParkEntity park = new ParkEntity();
        park.setName(name);
        park.setDescription(desc);
        park.setRating_Total(ratingTotal);
        park.setRating_Count(ratingCount);
        park.setAddress(address);
        park.setCounty(county);
        park.setOperator(operator);
        parkRepository.save(park);
    }
}
