package pk.edu.nust.seecs.gradebook;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pk.edu.nust.seecs.gradebook.dao.CloDao;
import pk.edu.nust.seecs.gradebook.dao.ContentDao;
import pk.edu.nust.seecs.gradebook.dao.CourseDao;
import pk.edu.nust.seecs.gradebook.dao.StudentDao;
import pk.edu.nust.seecs.gradebook.dao.TeacherDao;
import pk.edu.nust.seecs.gradebook.entity.Clo;
import pk.edu.nust.seecs.gradebook.entity.Content;
import pk.edu.nust.seecs.gradebook.entity.Course;
import pk.edu.nust.seecs.gradebook.entity.Student;
import pk.edu.nust.seecs.gradebook.entity.Teacher;

/**
 * My main App. 
 * <p>
 This executes everything.
 */

public class App {

    public static void main(String[] args) {
        CloDao clodao = new CloDao();

        // Add new clo
        Clo clo = new Clo();
        clo.setName("CLO 1");
        clo.setDescription("Design efficient solutions for algorithmic problems");
        clo.setPlo("2");
        clodao.addClo(clo);

        clodao.updateClo(clo);

        // Delete an existing clo
        //dao.deleteClo(1);

        // Get all clos
        for (Clo iter : clodao.getAllClos()) {
            System.out.println(iter);
        }

        // Get clo by id
        System.out.println(clodao.getCloById(1));


        
        
        // 1. Create 2 courses
        CourseDao cDao = new CourseDao();
        Course course = new Course();
        course.setClasstitle("AdvanceProgramming");
//        course.setContents();
        course.setCreditHours(4);
        course.setEndsOn(new Date(2016, 6, 3));
        course.setStartsOn(new Date(2016, 2, 1));

        
        // 2. teachers for each course
        TeacherDao teacherDao = new TeacherDao();
        Teacher teacher = new Teacher();
        teacher.setName("Fahad Satti");
        Set<Course> crs = new HashSet<>();
        crs.add(course);
        teacher.setCourses(crs);
        
        
        course.setTeacher(teacher);        
        
        // 3. 3 students for each
        StudentDao stDao = new StudentDao();
        Student st = new Student();
        st.setCourses(crs);
        st.setName("Junaid Ahmed");
        
        Student st1 = new Student();
        st1.setCourses(crs);
        st1.setName("Shahzad Malik");
        
        Student st2 = new Student();
        st2.setCourses(crs);
        st2.setName("Umar Ahsan");
        
        
     // 4. 2 contents for each course
        ContentDao contentDao = new ContentDao();
        Content content = new Content();
//        content.setClo(clo);
        content.setCourse(course);
        content.setDescription("Advanced Programming Course");
        content.setEndtime(new Date(2016, 6, 3));
        content.setStarttime(new Date(2016, 2, 1));
        content.setTitle("Content for Advanced Programming.");
        
        Set<Student> stList = new HashSet<>();
        stList.add(st);
        stList.add(st1);
        content.setStudents(stList);
        
        
        
        // 5. clos for each content for course
        CloDao cloDao2 = new CloDao();
        Clo clo2 = new Clo();
        clo2.setName("CLOs for AP");
        clo2.setDescription("CLOs are necessary");
        clo2.setPlo("3");
        clo2.setBtLevel("Normal");
        
        List<Clo> cloList = new ArrayList<>();
        cloList.add(clo);
        cloList.add(clo2);
        content.setClo(cloList);
        
        cDao.addCourse(course);
        teacherDao.addTeacher(teacher);
        stDao.addStudent(st);
        stDao.addStudent(st1);
        stDao.addStudent(st2);
        contentDao.addContent(content);
        cloDao2.addClo(clo2);
    }

}