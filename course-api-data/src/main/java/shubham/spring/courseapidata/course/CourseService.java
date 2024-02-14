package shubham.spring.courseapidata.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String id){

        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(id)
                .forEach(courses::add);

        return courses;
    }

    public Course getCourse(String id){
        Optional<Course> optionalTopic = courseRepository.findById(id);
        if (optionalTopic.isPresent()) {
            return optionalTopic.get();
        } else {
            // Handle case where topic is not found, for example:
            throw new RuntimeException("Topic not found for id: " + id);
        }
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);

    }

    public void deleteCourse(String id) {

        courseRepository.deleteById(id);
    }
}
