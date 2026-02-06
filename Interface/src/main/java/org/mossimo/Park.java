package org.mossimo;

public interface Park {
    void register();        // abstract

    /**
     * cancel the parking
     */
    default void cancel() {
        System.out.println("The parking is canceled.");
    }
}
