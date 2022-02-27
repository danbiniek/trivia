package com.adaptionsoft.games.uglytrivia;

import java.util.Objects;

public interface RollExecutor {

    void execute();

    default RollExecutor andThen(RollExecutor rollExecutor) {
        Objects.requireNonNull(rollExecutor);
        return () -> {
            this.execute();
            rollExecutor.execute();
        };
    }
}
