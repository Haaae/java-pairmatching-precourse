package pairmatching.domain;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pairmatching.view.Enum.Course;

public class CrewMemberReader {
    private final List<Crew> backend;
    private final List<Crew> frontend;
    private final Path backendPath = Paths.get(".\\src\\main\\resources\\backend-crew.md");
    private final Path frontendPath = Paths.get(".\\src\\main\\resources\\frontend-crew.md");
    private final Charset charset = StandardCharsets.UTF_8;
    private static final CrewMemberReader crewMemberReader = new CrewMemberReader();

    private CrewMemberReader() {
        backend = readCrewMember(backendPath, Course.BACKEND);
        frontend = readCrewMember(frontendPath, Course.FRONTEND);
    }

    public static CrewMemberReader getInstance() {
        return crewMemberReader;
    }

    public List<Crew> readCrews(Course course) {
        if (course.equals(Course.BACKEND)) {
            return backend;
        }
        return frontend;
    }

    private List<Crew> readCrewMember(final Path URL, Course course) {
        return convertCrews(readCrewFile(URL), course);
    }

    private List<Crew> convertCrews(List<String> crewFile, Course course) {
        final List<Crew> crews = new ArrayList<>();

        for(String name : crewFile){
            crews.add(new Crew(course, name));
        }

        return crews;
    }

    private List<String> readCrewFile(final Path URL) {
        List<String> list = new ArrayList<String>();

        try{
            list = Files.readAllLines(URL,charset);
        }catch(IOException e){
            e.printStackTrace();
        }

        return Collections.unmodifiableList(list);
    }

}
