/**
 * Cette classe permet de créer un fichier JSON contenant des données d'albums et de singles,
 * puis d'écrire ces données dans un fichier JSON.
 *
 * @Author: Aaron Osorio
 * @Courriel: moncourriel@courriel.com
 * @Code-permamnent: AAAA82090909
 * @Groupe: 30
 */


// Importe la classe JSONArray du package net.sf.json.
//import net.sf.json.JSONArray;
// La classe JSONArray permet de créer et de manipuler des tableaux JSON.

// Importe la classe JSONObject du package net.sf.json.
//import net.sf.json.JSONObject;
// La classe JSONObject permet de créer et de manipuler des objets JSON.

// Importe la classe IOException du package java.io.
import java.io.IOException;
// La classe IOException est utilisée pour gérer les exceptions liées aux erreurs d'entrée/sortie.

// Importe la classe ArrayList du package java.util.
import java.util.ArrayList;
// La classe ArrayList permet de créer et de manipuler des listes dynamiques d'objets.

import java.io.BufferedWriter;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class AlbumWriter {

    /**
     * Le point d'entrée du programme. Cette méthode crée une liste d'albums et de singles, les convertit
     * en format JSON, puis écrit ces données dans un fichier JSON.
     *
     * @param args Les arguments de la ligne de commande (non utilisés dans cette application).
     */
    public static void main(String[] args) {
        // Crée une liste vide d'objets Album pour stocker les données d'albums et de singles.
        ArrayList<Album> albums = new ArrayList<>();

        // Ajoute trois éléments (deux albums et un single) à la liste d'albums.
        albums.add(new Album("album", "Cypress Hill", "Temple of Boom", 1996, 4));
        albums.add(new Album("album", "La compagnie créole", "Un ti-bo", 1990, 2));
        albums.add(new Album("Single", "Aimer", "Escalate", 2020, 5));

        // Crée un objet JSONArray pour stocker les données JSON des albums.
        JSONArray arrayAlbum = new JSONArray();

        // Parcourt la liste d'albums pour convertir chaque album en objet JSON.
        for (Album album : albums) {
            // Crée un objet JSON pour représenter un album ou un single.
            JSONObject albumJSON = new JSONObject();
            albumJSON.put("type", album.getType());
            albumJSON.put("title", album.getTitre());
            albumJSON.put("artist", album.getArtiste());
            albumJSON.put("publication", album.getPublication());
            albumJSON.put("rating", album.getRating());

            // Ajoute l'objet JSON de l'album au tableau JSON.
            arrayAlbum.add(albumJSON);
        }

        // Crée un objet JSON global qui contient le tableau d'albums.
        JSONObject collection = new JSONObject();
        collection.put("collection", arrayAlbum);

        try  {
            // Écrit les données JSON dans un fichier avec une indentation de 2 espaces.
            String jsonString = JSONValue.toJSONString(collection);
            DiskFile.saveStringIntoFile("nouveau-fichier-JSON.json", jsonString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}