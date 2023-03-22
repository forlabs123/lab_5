package org.example.commands;

import org.example.Exeption.WrongAmountOfElementsException;
import org.example.File.Collection;
import org.example.model.Organization;

import java.util.ArrayList;
import java.util.Collections;

/**
 *  The 'PrintFieldAscendingOrganization' class is a command that prints all organization that workers have in order.
 */
public class PrintFieldAscendingOrganization extends Command {
    private Collection collection;

    public PrintFieldAscendingOrganization(Collection collection) {
        this.collection = collection;
    }

    /**
     * Prints all the organization types in the system
     */
    @Override
    public void execute(String[] args) {
        if (!(args.length <1)) throw new WrongAmountOfElementsException();
        ArrayList<Organization> organizations = new ArrayList<>(collection.getOrganisation());
        Collections.sort(organizations);
        for(Organization organization : organizations){
            System.out.println(organization.toString());
        }
    }
}
