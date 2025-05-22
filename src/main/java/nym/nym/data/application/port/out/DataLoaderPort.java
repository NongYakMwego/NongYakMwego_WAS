package nym.nym.data.application.port.out;

import java.util.List;

public interface DataLoaderPort<T> {
    void load(List<T> data);
}
