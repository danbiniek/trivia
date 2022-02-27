package com.adaptionsoft.games.uglytrivia;

import java.util.Objects;

public interface RollProcessor {

    void execute();

    default RollProcessor andThen(RollProcessor rollProcessor) {
        Objects.requireNonNull(rollProcessor);
        return () -> {
            this.execute();
            rollProcessor.execute();
        };
    }
}
