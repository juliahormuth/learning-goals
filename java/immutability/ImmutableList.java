import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableList {
    List<String> immutableList = Collections.unmodifiableList(new ArrayList<String>());

    public List<String> getList() {
        return immutableList;
    }

    public void setList(String name) {
        this.immutableList.add(name);
    }
}
