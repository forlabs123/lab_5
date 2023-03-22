package org.example.commands;

/**
 * Class 'exit'.
 * Terminates the program.
 */

public class Exit extends Command {
    /**
     * Changes the flag value.
     * Terminates the program execution
     * @param args
     */
    @Override
    public void execute(String[] args) {
        setFlag(false);

    }
}