package com.github.johnsonadeshina.blogpost.io;

import java.util.List;

public interface BlogDAO<E> {
    void writeAll(List<E> e);

    List<E> ReadAll();
}
