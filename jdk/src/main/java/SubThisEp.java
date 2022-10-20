import com.sun.org.apache.bcel.internal.generic.FSUB;

import java.util.ArrayList;
import java.util.List;

public class SubThisEp extends ThisEscape{
    public SubThisEp(List source) {
        super(source);
    }

    @Override
    public void age() {
        System.out.println(a);
    }

    public static void main(String[] args) {
        SubThisEp subThisEp = new SubThisEp(new ArrayList());
    }
}
