/**
 * Cette classe permet de parser un fichier JSON contenant des données sur des albums et des singles,
 * et de les convertir en une liste d'objets 'Album' pour une manipulation plus aisée.
 *
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

// Importe la classe JSONSerializer du package net.sf.json.
//import net.sf.json.JSONSerializer;
// La classe JSONSerializer permet de sérialiser/désérialiser des objets JSON.

// Importe la classe IOException du package java.io.
import java.io.IOException;
// La classe IOException est utilisée pour gérer les exceptions liées aux erreurs d'entrée/sortie.

// Importe la classe ArrayList du package java.util.
import java.util.ArrayList;
// La classe ArrayList permet de créer et de manipuler des listes dynamiques d'objets.

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class JsonParser {

    /**
     * Cette méthode privée de la classe 'JsonParser' permet d'extraire les données d'albums et de singles
     * depuis un tableau JSON et de les ajouter à une liste d'objets 'Album'.
     *
     * @param albums La liste d'objets 'Album' dans laquelle les données extraites seront ajoutées.
     * @param donneesContenuDansJSON Le tableau JSON contenant les données d'albums et de singles à extraire.
     */
    private static void extraireDonneesDepuisFichierJSONVersAlbum( ArrayList < Album > albums, JSONArray donneesContenuDansJSON ){

        // Parcourt chaque élément du tableau JSON.
        for (int i = 0; i < donneesContenuDansJSON.size(); ++i) {
            // Récupère l'objet JSON représentant un album ou un single.
            JSONObject album = (JSONObject) donneesContenuDansJSON.get(i);

            // Crée un nouvel objet 'Album' à partir des données JSON et l'ajoute à la liste.
            albums.add(new Album(
                    (String) album.get("type"),
                    (String) album.get("artist"),
                    (String) album.get("title"),
                    ((Long) album.get("publication")).intValue(),
                    ((Long) album.get("rating")).intValue()
            ));
        }

    }

    /**
     * Extrait les données depuis un fichier JSON et les convertit en une liste d'objets 'Album'.
     *
     * @param nomFichierJSON Le nom du fichier JSON à parser.
     * @return Une liste d'objets 'Album' contenant les données extraites du fichier JSON.
     * @throws IOException En cas d'erreur d'entrée/sortie lors de la lecture du fichier JSON.
     * @throws ParseException En cas d'erreur d'entrée/sortie lors de la lecture du fichier JSON.
     */
    public static ArrayList<Album> jsonFileToAlbum(String nomFichierJSON) throws IOException, ParseException {
        ArrayList<Album> albums = new ArrayList<>();

        // Charge le contenu du fichier JSON en tant que chaîne de caractères JSON.
        String jsonString = DiskFile.loadFileIntoString(nomFichierJSON);

        // Crée un analyseur JSON simple.
        JSONParser parser = new JSONParser();

        // Analyse la chaîne JSON en un objet JSON.
        JSONObject objet = (JSONObject) parser.parse(jsonString);

        // Récupère le tableau JSON contenant les données d'albums et de singles.
        JSONArray donneesContenuDansJSON = (JSONArray) objet.get("collection");

        // Appelle la méthode privée pour extraire les données et les ajouter à la liste d'albums.
        extraireDonneesDepuisFichierJSONVersAlbum(albums, donneesContenuDansJSON);

        // Retourne la liste d'albums complétée.
        return albums;
    }

}