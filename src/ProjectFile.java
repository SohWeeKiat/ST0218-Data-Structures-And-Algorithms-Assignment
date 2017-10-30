
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Wee Kiat
 */
public class ProjectFile {

    private final String FilePath;

    public ProjectFile(String Path) {
        this.FilePath = Path;
    }

    public ArrayList<Project> ParseFile() {
        ArrayList<Project> projects = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FilePath))){
            int ProjectCount = Integer.parseInt(br.readLine());
            for (int i = 0; i < ProjectCount; i++) {
                String line = br.readLine();
                StringTokenizer st = new StringTokenizer(line, ",", false);

                String ProjectTitle = st.nextToken();
                String School = st.nextToken();
                String SupervisorName = st.nextToken();

                Project p = new Project(ProjectTitle, School, SupervisorName);

                int StudentCount = Integer.parseInt(st.nextToken());
                for (int x = 0; x < StudentCount; x++) {
                    String AdminNo = st.nextToken();
                    String StudentName = st.nextToken();
                    String Course = st.nextToken();
                    char Gender = st.nextToken().charAt(0);

                    p.AddStudent(new Student(StudentName, AdminNo, Course, Gender));
                }
                projects.add(p);
            }
            return projects;
        } catch (IOException ex) {

        }
        return projects;
    }

    public void OutputFile(Project p) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FilePath))) {
            writer.write("Title:\t\t" + p.getTitle() + "\r\n");
            writer.write("School:\t\t" + p.getSchool() + "\r\n");
            writer.write("Supervisor:\t\t" + p.getSupervisor() + "\r\n");
            writer.write("Students:\t\t");
            int Count = 0;
            for (Student s : p.getStudents()) {
                if (Count++ > 0) {
                    writer.write(" ==> ");
                }
                writer.write(s.getName());
            }
            writer.write("\r\n---------------");
        }
    }
}
