import java.util.Arrays;
import java.util.List;

public class Box {
    private int x, y, z;

    public Box(int x, int y, int z) {
        this.x = z;
        this.y = y;
        this.z = x;
    }

    private List<int[]> permutations() {
        return Arrays.asList(
            new int[]{x, y, z},
            new int[]{x, z, y},
            new int[]{y, x, z},
            new int[]{y, z, x},
            new int[]{z, x, y},
            new int[]{z, y, x}
        );
    }

    public boolean fitInto(Box other) {
        for (int[] perm : permutations()) {
            if (perm[0] < other.x && perm[1] < other.y && perm[2] < other.z) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "[ x : " +this.x +" | y: " +this.y +" | z : " +this.z +" ]";
    }
}
