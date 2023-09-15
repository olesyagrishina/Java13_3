package Task;
import Task.Epic;
import Task.Meeting;
import Task.SimpleTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void WhenSimpleTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void WhenSimpleTaskNotMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean expected = false;
        boolean actual = simpleTask.matches("Навестить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void WhenEpicMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        boolean expected = true;
        boolean actual = epic.matches("Молоко");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void WhenEpicNotMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        boolean expected = false;
        boolean actual = epic.matches("Сок");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void WhenMeetingTopicMatches() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = true;
        boolean actual = meeting.matches("Выкатка 3й версии приложения");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void WhenMeetingProjectMatches() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = true;
        boolean actual = meeting.matches("Приложение НетоБанка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void WhenMeetingNotMatches() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = false;
        boolean actual = meeting.matches("Позвонить родителям");

        Assertions.assertEquals(expected, actual);
    }
}
