package facades;

import facades.exceptions.CreationSalonImpossibleException;
import facades.exceptions.SalonPortantCeNomDejaExistantException;

public interface FonctionnalitesSalons {


    void creationSalon(String pseudo,String nomSalon) throws SalonPortantCeNomDejaExistantException, CreationSalonImpossibleException;
}
