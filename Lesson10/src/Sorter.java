import java.util.Collection;

public interface Sorter {

    public <T extends Comparable<? super T>> Collection sort(Collection<T> collection);
}
